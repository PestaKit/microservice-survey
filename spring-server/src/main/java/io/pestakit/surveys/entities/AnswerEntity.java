package io.pestakit.surveys.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali.miladi on 07.12.2017.
 */

@Entity
public class AnswerEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idSurvey;
    private long idQuestion;
    private long idUser;
    private String timestamp;

    @OneToMany(targetEntity = ChoiceEntity.class, fetch = FetchType.EAGER, cascade =CascadeType.PERSIST)
    private List<ChoiceEntity> choices = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public long getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(long idSurvey) {
        this.idSurvey = idSurvey;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setChoices(List<ChoiceEntity> choices) {
        this.choices = choices;
    }

    public List<ChoiceEntity> getChoices() {
        return choices;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
