package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.QuestionsApi;
import io.pestakit.surveys.entities.QuestionEntity;
import io.pestakit.surveys.model.Question;

import io.pestakit.surveys.repositories.QuestionsRepository;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-08T23:16:30.062+01:00")

@Controller
public class QuestionsApiController implements QuestionsApi {

    @Autowired
    QuestionsRepository questionsRepository;

    public ResponseEntity<Void> createQuestion(@ApiParam(value = "The question to be created" ,required=true )  @Valid @RequestBody Question question) {
        QuestionEntity entity = toQuestionEntity(question);
        questionsRepository.save(entity);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return created(location).build();
    }



    public ResponseEntity<Question> findQuestionById(@ApiParam(value = "ID of question to fetch",required=true ) @PathVariable("id_question") Long idQuestion) {
        Question question = toQuestion(questionsRepository.findOne(idQuestion));
        return ok(question);
    }

    public ResponseEntity<List<Question>> questionsGet() {
        List<Question> questions = new ArrayList<>();
        for (QuestionEntity entity : questionsRepository.findAll()){
            questions.add(toQuestion(entity));
        }
        return ok(questions);
    }

    public QuestionEntity toQuestionEntity(Question question){
        QuestionEntity entity = new QuestionEntity();
        entity.setTitle(question.getTitle());
        entity.setUsed(question.getUsed());
        entity.setChoices(question.getChoices());
        entity.setEnabled(question.getEnabled());
        return entity;
    }

    public Question toQuestion(QuestionEntity entity){
        Question question= new Question();
        question.setTitle(entity.getTitle());
        question.setUsed(entity.getUsed());
        question.setChoices(entity.getChoices());
        question.setEnabled(entity.getEnabled());
        return question;
    }

}
