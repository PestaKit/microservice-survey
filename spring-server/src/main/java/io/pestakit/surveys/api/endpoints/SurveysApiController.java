package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.SurveysApi;
import io.pestakit.surveys.entities.SurveyEntity;
import io.pestakit.surveys.model.Question;
import io.pestakit.surveys.model.Survey;
import io.pestakit.surveys.repositories.SurveysRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by ali.miladi on 21.11.2017.
 */
@Controller
public class SurveysApiController implements SurveysApi {

    @Autowired
    Environment environment;

    private static final String CONTEXT_PATH = "/api";

    private static final String SERVER_PORT = "8080";
    private static final String LOCAL_HOSTADDRESS = "http://localhost";
    private static final String QUESTIONS_ENDPOINT = "/questions/";

    private String prefix = LOCAL_HOSTADDRESS + ":" + SERVER_PORT;

    private  String questionsEndpointAddress =  prefix + CONTEXT_PATH + QUESTIONS_ENDPOINT;

    @Autowired
    SurveysRepository surveysRepository;

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
                        || !url.substring(0, questionsEndpointAddress.length()).equals(questionsEndpointAddress))
                    return badRequest().build();
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
    public ResponseEntity<Survey> findSurveyById(@ApiParam(value = "ID of survey to fetch", required = true)
                                                 @PathVariable("id_survey")
                                                         Long idSurvey) {
        SurveyEntity entity = surveysRepository.findOne(idSurvey);
        if (entity != null) {
            Survey survey = toSurvey(entity);
            return ok(survey);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        for (SurveyEntity entity :
                surveysRepository.findAll()) {
            surveys.add(toSurvey(entity));
        }
        return ok(surveys);
    }

    private SurveyEntity toSurveyEntity(Survey survey) {
        SurveyEntity surveyEntity = new SurveyEntity();
        surveyEntity.setTitle(survey.getTitle());
        surveyEntity.setQuestions(survey.getQuestions());
        return surveyEntity;
    }

    private Survey toSurvey(SurveyEntity entity) {
        Survey survey = new Survey();
        survey.setTitle(entity.getTitle());
        survey.setQuestions(entity.getQuestions());
        return survey;
    }
}
