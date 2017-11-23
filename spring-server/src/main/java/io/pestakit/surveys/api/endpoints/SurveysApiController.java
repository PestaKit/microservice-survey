package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.SurveysApi;
import io.pestakit.surveys.entities.QuestionEntity;
import io.pestakit.surveys.entities.SurveyEntity;
import io.pestakit.surveys.model.QuestionRef;
import io.pestakit.surveys.model.Survey;
import io.pestakit.surveys.model.SurveyRef;
import io.pestakit.surveys.repositories.QuestionsRepository;
import io.pestakit.surveys.repositories.SurveysRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

/**
 * Created by ali.miladi on 21.11.2017.
 */
@Controller
public class SurveysApiController implements SurveysApi {

    private static final String CONTEXT_PATH = "/api";
    private static final String SERVER_PORT = "8080";
    private static final String LOCAL_HOSTADDRESS = "http://localhost";
    private static final String QUESTIONS_ENDPOINT = "/questions/";
    private String prefix = LOCAL_HOSTADDRESS + ":" + SERVER_PORT;
    private String questionsEndpointAddress = prefix + CONTEXT_PATH + QUESTIONS_ENDPOINT;

    @Autowired
    SurveysRepository surveysRepository;

    @Autowired
    QuestionsRepository questionsRepository;

    @Transactional
    @Override
    public ResponseEntity<Void> createSurvey(@ApiParam(value = "The survey to be created", required = true)
                                             @Valid
                                             @RequestBody
                                                     Survey survey) {
        SurveyEntity entity = toSurveyEntity(survey);
        List<String> questions = entity.getQuestions();
        if (questions.size() != 0) {
            // Controlling url patterns
            for (String url : questions) {
                if (url.length() < questionsEndpointAddress.length()
                        || !url.substring(0, questionsEndpointAddress.length()).equals(questionsEndpointAddress)) {
                    return badRequest().build();
                } else {
                    Long idQuestion = Long.decode(url.substring(questionsEndpointAddress.length()));
                    QuestionEntity questionEntity = questionsRepository.findOne(idQuestion);
                    if (questionEntity == null) {
                        return badRequest().build();
                    }
                    updateUsedField(questionEntity);
                }
            }
            surveysRepository.save(entity);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getId()).toUri();
            return created(location).build();
        } else {
            return badRequest().build();
        }
    }

    @Override
    public ResponseEntity<SurveyRef> findSurveyById(@ApiParam(value = "ID of survey to fetch", required = true)
                                                    @PathVariable("id_survey")
                                                            Long id_survey) {
        SurveyEntity entity = surveysRepository.findOne(id_survey);
        if (entity != null) {
            SurveyRef surveyRef = toSurveyRef(entity);
            return ok(surveyRef);
        } else {
            return notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<SurveyRef>> getAllSurveys() {
        List<SurveyRef> surveyRefs = new ArrayList<>();
        for (SurveyEntity entity :
                surveysRepository.findAll()) {
            surveyRefs.add(toSurveyRef(entity));
        }
        return ok(surveyRefs);
    }

    private SurveyEntity toSurveyEntity(Survey survey) {
        SurveyEntity surveyEntity = new SurveyEntity();
        surveyEntity.setTitle(survey.getTitle());
        surveyEntity.setQuestions(survey.getQuestionURLs());
        return surveyEntity;
    }

    private Survey toSurvey(SurveyEntity entity) {
        Survey survey = new Survey();
        survey.setTitle(entity.getTitle());
        survey.setQuestionURLs(entity.getQuestions());

        return survey;
    }

    private SurveyRef toSurveyRef(SurveyEntity entity) {

        SurveyRef surveyRef = new SurveyRef();

        surveyRef.setTitle(entity.getTitle());
        ArrayList<QuestionRef> questionRefs = new ArrayList<>();
        for (String url : entity.getQuestions()) {
            QuestionRef questionRef = new QuestionRef();
            Long id_question = Long.decode(url.substring(questionsEndpointAddress.length()));
            QuestionEntity questionEntity = questionsRepository.findOne(id_question);
            questionRef.setTitle(questionEntity.getTitle());
            questionRef.setSelf(url);
            questionRefs.add(questionRef);
        }
        surveyRef.setQuestionRefs(questionRefs);

        return surveyRef;
    }

    private Integer updateUsedField(QuestionEntity questionEntity) {
        int used = questionEntity.getUsed();
        Long questionId = questionEntity.getId();
        used++;
        Integer update = questionsRepository.updateUsed(questionId, used);
        return update;
    }
}
