package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.QuestionsApi;
import io.pestakit.surveys.entities.ChoiceEntity;
import io.pestakit.surveys.entities.QuestionEntity;
import io.pestakit.surveys.model.Choice;
import io.pestakit.surveys.model.Question;

import io.pestakit.surveys.repositories.QuestionsRepository;
import io.pestakit.surveys.validators.QuestionValidator;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.*;


@Controller
public class QuestionsApiController implements QuestionsApi {

    @Autowired
    QuestionsRepository questionsRepository;


    @Override
    public ResponseEntity<Void> createQuestion(@ApiParam(value = "The question to be created", required = true)
                                               @Valid
                                               @RequestBody Question question){
        QuestionEntity entity = toQuestionEntity(question);
        entity.setUsed(0);
        questionsRepository.save(entity);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return created(location).build();
    }

    @Override
    public ResponseEntity<Question> findQuestionById(@ApiParam(value = "ID of question to fetch", required = true)
                                                     @PathVariable("id_question")
                                                             Long idQuestion) {
        QuestionEntity entity = questionsRepository.findOne(idQuestion);
        if (entity != null) {
            Question question = toQuestion(entity);
            return ok(question);
        }
        return notFound().build();

    }

    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        for (QuestionEntity entity : questionsRepository.findAll()) {
            questions.add(toQuestion(entity));
        }
        return ok(questions);
    }

    private QuestionEntity toQuestionEntity(Question question) {
        QuestionEntity entity = new QuestionEntity();
        entity.setTitle(question.getTitle());
        entity.setEnabled(question.getEnabled());
        List<ChoiceEntity> choiceEntities = entity.getChoices();
        for (Choice choice : question.getChoices()) {
            choiceEntities.add(toChoiceEntity(choice));
        }
        entity.setChoices(choiceEntities);
        return entity;
    }

    private Question toQuestion(QuestionEntity entity) {
        Question question = new Question();
        question.setTitle(entity.getTitle());
        question.setUsed(entity.getUsed());
        List<Choice> choices = new ArrayList<>();
        question.setEnabled(entity.getEnabled());
        for (ChoiceEntity choiceEntity : entity.getChoices()) {
            choices.add(toChoice(choiceEntity));
        }
        question.setChoices(choices);
        return question;
    }

    protected static Choice toChoice(ChoiceEntity entity) {
        Choice choice = new Choice();
        choice.setPosition(entity.getPosition());
        choice.setText(entity.getText());
        return choice;
    }

    protected static ChoiceEntity toChoiceEntity(Choice choice) {
        ChoiceEntity entity = new ChoiceEntity();
        entity.setPosition(choice.getPosition());
        entity.setText(choice.getText());
        return entity;
    }


    @Autowired
    QuestionValidator questionValidator;

    @InitBinder("question")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(questionValidator);
    }
}
