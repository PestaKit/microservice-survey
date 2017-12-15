package io.pestakit.surveys.validators;

import io.pestakit.surveys.api.endpoints.QuestionsApiController;
import io.pestakit.surveys.entities.QuestionEntity;
import io.pestakit.surveys.entities.SurveyEntity;
import io.pestakit.surveys.model.Answer;
import io.pestakit.surveys.repositories.QuestionsRepository;
import io.pestakit.surveys.repositories.SurveysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by ali.miladi on 08.12.2017.
 */
@Component
public class AnswerValidator implements Validator {

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
        SurveyEntity survey = surveysRepository.findOne(answer.getIdSurvey());
        QuestionEntity question = questionsRepository.findOne(answer.getIdQuestion());
        if (survey == null) {
            errors.rejectValue("idSurvey", "NonExistentSurvey");
        }
        if (answer.getChoices().size() == 0) {
            errors.rejectValue("choices", "EmptyList");
        }
        if (question == null) {
            errors.rejectValue("idQuestion", "NonExistentQuestion");
            if (answer.getChoices().size() > 0) {
                errors.rejectValue("choices", "ChoicesForNonExistentQuestion");
            }
        } else {
            if (question.getEnabled() == 0) {
                errors.rejectValue("idQuestion", "DisabledQuestion");
                if (answer.getChoices().size() > 0) {
                    errors.rejectValue("choices", "ChoicesForDisabledQuestion");
                }
            }
            if (answer.getChoices().size() > question.getChoices().size()) {
                errors.rejectValue("choices", "TooMuchChoices");
            }
        }
        // TODO implement choices check against real question
        // TODO implement user authentication here
    }
}

