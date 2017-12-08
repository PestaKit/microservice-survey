package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.AnswersApi;
import io.pestakit.surveys.entities.AnswerEntity;
import io.pestakit.surveys.entities.ChoiceEntity;
import io.pestakit.surveys.model.Answer;
import io.pestakit.surveys.model.Choice;
import io.pestakit.surveys.model.Survey;
import io.pestakit.surveys.repositories.AnswersRepository;
import io.pestakit.surveys.validators.AnswerValidator;
import io.swagger.annotations.ApiParam;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by ali.miladi on 07.12.2017.
 */

@Controller
public class AnswersApiController implements AnswersApi {

    @Autowired
    AnswersRepository answersRepository;

    @Override
    public ResponseEntity<Void> createAnswer(@ApiParam(value = "The answer to be created", required = true)
                                             @Valid
                                             @RequestBody Answer answer) {
        AnswerEntity entity = toAnswerEntity(answer);
        answersRepository.save(entity);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return created(location).build();
    }

    @Override
    public ResponseEntity<Answer> findAnswerById(@ApiParam(value = "ID of answer to fetch", required = true)
                                                 @PathVariable("id_answer") Long idAnswer) {
        return ok(toAnswer(answersRepository.findOne(idAnswer)));
    }

    @Override
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = new ArrayList<>();
        for (AnswerEntity entity : answersRepository.findAll()){
            answers.add(toAnswer(entity));
        }
        return ok(answers);
    }


    private Answer toAnswer(AnswerEntity entity) {
        Answer answer = new Answer();
        List<Choice> choices = new ArrayList<>();
        for (ChoiceEntity choiceEntity : entity.getChoices()) {
            choices.add(QuestionsApiController.toChoice(choiceEntity));
        }
        answer.setChoices(choices);
        answer.setIdQuestion(entity.getIdQuestion());
        answer.setIdSurvey(entity.getIdSurvey());
        answer.setIdUser(entity.getIdUser());
        answer.setTimestamp(entity.getTimestamp());
        return answer;
    }

    private AnswerEntity toAnswerEntity(Answer answer) {
        AnswerEntity entity = new AnswerEntity();
        List<ChoiceEntity> choiceEntities = entity.getChoices();
        for (Choice choice : answer.getChoices()) {
            choiceEntities.add(QuestionsApiController.toChoiceEntity(choice));
        }
        entity.setChoices(choiceEntities);
        entity.setIdQuestion(answer.getIdQuestion());
        entity.setIdSurvey(answer.getIdSurvey());
        entity.setIdUser(answer.getIdUser());
        entity.setTimestamp(DateTime.now().toString());
        return entity;
    }

    @Autowired
    AnswerValidator answerValidator;

    @InitBinder("answer")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(answerValidator);
    }

}
