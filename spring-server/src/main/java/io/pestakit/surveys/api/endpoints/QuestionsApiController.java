package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.QuestionsApi;
//import io.pestakit.surveys.entities.ChoiceEntity;
import io.pestakit.surveys.entities.ChoiceEntity;
import io.pestakit.surveys.entities.QuestionEntity;
//import io.pestakit.surveys.model.Choice;
import io.pestakit.surveys.model.Choice;
import io.pestakit.surveys.model.Question;

//import io.pestakit.surveys.repositories.ChoicesRepository;
import io.pestakit.surveys.repositories.QuestionsRepository;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-08T23:16:30.062+01:00")

@Controller
public class QuestionsApiController implements QuestionsApi {

    @Autowired
    QuestionsRepository questionsRepository;


    @Override
    public ResponseEntity<Void> createQuestion(@ApiParam(value = "The question to be created" ,required=true )  @Valid @RequestBody Question question) {
        QuestionEntity entity = toQuestionEntity(question);
        questionsRepository.save(entity);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return created(location).build();
    }

    @Override
    public ResponseEntity<Question> findQuestionById(@ApiParam(value = "ID of question to fetch",required=true ) @PathVariable("id_question") Long idQuestion) {
        Question question = toQuestion(questionsRepository.findOne(idQuestion));
        return ok(question);
    }

    @Override
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
        entity.setEnabled(question.getEnabled());
        List<ChoiceEntity> choiceEntities = entity.getChoices();
        for (Choice choice : question.getChoices()){
            choiceEntities.add(toChoiceEntity(choice));
        }
        entity.setChoices(choiceEntities);
        return entity;
    }

    public Question toQuestion(QuestionEntity entity){
        Question question= new Question();
        question.setTitle(entity.getTitle());
        question.setUsed(entity.getUsed());
        List<Choice> choices = new ArrayList<>();
        question.setEnabled(entity.getEnabled());
        for (ChoiceEntity choiceEntity : entity.getChoices()){
            choices.add(toChoice(choiceEntity));
        }
        question.setChoices(choices);
        return question;
    }



    public Choice toChoice(ChoiceEntity entity){
        Choice choice = new Choice();
        choice.setPosition(entity.getPosition());
        choice.setText(entity.getText());
        return choice;
    }

    public ChoiceEntity toChoiceEntity(Choice choice){
        ChoiceEntity entity = new ChoiceEntity();
        entity.setPosition(choice.getPosition());
        entity.setText(choice.getText());
        return entity;
    }
}
