package io.pestakit.surveys.validators;

import io.pestakit.surveys.entities.QuestionEntity;
import io.pestakit.surveys.model.Survey;
import io.pestakit.surveys.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.List;

/**
 * Created by ali.miladi on 01.12.2017.
 */
@Component
public class SurveyValidator implements Validator {

    // For the moment, we hard code the questions urls TODO improve this later
    private static final String CONTEXT_PATH = "/api";
    private static final String SERVER_PORT = "8080";
    private static final String LOCAL_HOSTADDRESS = "http://localhost";
    private static final String QUESTIONS_ENDPOINT = "/questions/";
    private String prefix = LOCAL_HOSTADDRESS + ":" + SERVER_PORT;
    private String questionsEndpointAddress = prefix + CONTEXT_PATH + QUESTIONS_ENDPOINT;

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Survey.class.isAssignableFrom(clazz);
    }


    @Override
    @SuppressWarnings("rawtypes")
    public void validate(Object target, Errors errors) {
        Survey survey = (Survey) target;
        List<String> questions = survey.getQuestionURLs();
        if (questions.size() == 0) {
            errors.rejectValue("questionURLs", "EmptyQuestionURLs");
        }
        // Controlling url patterns
        for (String url : questions) {
            if (url.length() < questionsEndpointAddress.length()
                    || !url.substring(0, questionsEndpointAddress.length()).equals(questionsEndpointAddress)) {
                errors.rejectValue("questionURLs", "BadURL");
            } else {
                Long idQuestion = Long.decode(url.substring(questionsEndpointAddress.length()));
                QuestionEntity questionEntity = questionsRepository.findOne(idQuestion);
                if (questionEntity == null) {
                    errors.rejectValue("questionURLs", "BadQuestionId");
                } else if (questionEntity.getEnabled() == 0){
                    errors.rejectValue("questionURLs", "DisabledQuestion");
                }
            }
        }
    }
}
