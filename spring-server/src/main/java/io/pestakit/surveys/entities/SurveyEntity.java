package io.pestakit.surveys.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali.miladi on 21.11.2017.
 */
@Entity
public class SurveyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String idUser;

    // This annotation is used to tell the spring server to consider this field as a collection of instances of a basic
    // or embedded type (in our case String --> embedded class).
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> questions = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }
}
