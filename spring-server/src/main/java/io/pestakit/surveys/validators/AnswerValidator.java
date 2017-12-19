package io.pestakit.surveys.validators;

import io.pestakit.surveys.api.endpoints.QuestionsApiController;
import io.pestakit.surveys.entities.ChoiceEntity;
import io.pestakit.surveys.entities.QuestionEntity;
import io.pestakit.surveys.entities.SurveyEntity;
import io.pestakit.surveys.model.Answer;
import io.pestakit.surveys.model.Choice;
import io.pestakit.surveys.repositories.QuestionsRepository;
import io.pestakit.surveys.repositories.SurveysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali.miladi on 08.12.2017.
 */
@Component
public class AnswerValidator implements Validator {

    private final Validator validator;

    public AnswerValidator(LocalValidatorFactoryBean validator) {
        this.validator = validator;
    }

    @Autowired
    SurveysRepository surveysRepository;

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Answer.class.isAssignableFrom(clazz);
    }

    @Override
    @SuppressWarnings("rawtype")
    public void validate(Object target, Errors errors) {
        Answer answer = (Answer) target;
        if (answer.getIdSurvey() != null) {
            SurveyEntity survey = surveysRepository.findOne(answer.getIdSurvey());
            if (survey == null) {
                errors.rejectValue("idSurvey", "NonExistingSurvey");
            }
        }
        if (answer.getIdQuestion() != null) {
            QuestionEntity question = questionsRepository.findOne(answer.getIdQuestion());
            if (question == null) {
                errors.rejectValue("idQuestion", "NonExistingQuestion");
                if (answer.getChoices().size() > 0) {
                    errors.rejectValue("choices", "ChoicesForNonExistingQuestion");
                }
            } else {
                if (question.getEnabled() == 0) {
                    errors.rejectValue("idQuestion", "DisabledQuestion");
                    if (answer.getChoices().size() > 0) {
                        errors.rejectValue("choices", "ChoicesForDisabledQuestion");
                    }
                }
                if (answer.getChoices().size() == 0) {
                    errors.rejectValue("choices", "EmptyList");
                }
                // Deep check of the selected choices. In case that at least one doesn't match, this should not pass
                // the validation
                else if (incorrectSelectedChoices(answer.getChoices(), question.getChoices())) {
                    errors.rejectValue("choices", "SelectedChoicesDontMatchQuestionChoices");
                } else {
                    if (question.getMultipleChoice() == 0 && answer.getChoices().size() != 1) {
                        errors.rejectValue("choices", "TooMuchChoices");
                    }
                    else if (answer.getChoices().size() != 1){
                        // For the moment, we assume that the choices get posted having ordered positions. TODO improve this later
                        for (int i = 0; i < answer.getChoices().size(); i++) {
                            if (answer.getChoices().get(i).getPosition() != i + 1) {
                                errors.rejectValue("choices", "InvalidPositions");
                                break;
                            } else if (answer.getChoices().get(i).getText().length() == 0) {
                                errors.rejectValue("choices", "EmptyText");
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (Object object : answer.getChoices()) {
            ValidationUtils.invokeValidator(validator, object, errors);
        }
    }

    /**
     * Helper method to figure out that the choices posted in an answer really exist in the question or not
     *
     * @param postedChoices          the list of posted choices retrieved from the answer DTO
     * @param existingChoiceEntities the list of choices (entities) existing in the question retrieved from the JPA entity
     * @return true only if there exists at least one choice in the postedChoices that is not present in the
     * existantChoices list
     * false otherwise
     */
    private boolean incorrectSelectedChoices(List<Choice> postedChoices, List<ChoiceEntity> existingChoiceEntities) {
        if (postedChoices.size() > existingChoiceEntities.size())
            return true;
        List<Choice> existingChoices = new ArrayList<>();
        for (ChoiceEntity entity : existingChoiceEntities) {
            existingChoices.add(QuestionsApiController.toChoice(entity));
        }
        for (Choice choice : postedChoices) {
            if (!existingChoices.contains(choice)) {
                return true;
            }
        }
        return false;
    }
}

