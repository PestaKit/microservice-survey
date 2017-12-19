package io.pestakit.surveys.entities;

//import io.pestakit.surveys.model.Choice;

import springfox.documentation.spring.web.json.Json;
//import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali.miladi on 08.11.2017.
 */
@Entity
public class QuestionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private int used;
    private int enabled;
    private int multipleChoice;

    // Fetch type for cascade requests. Here it makes sense to have it eager since we have at most a dozen of choices
    // per question
    @OneToMany(targetEntity = ChoiceEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ChoiceEntity> choices = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getUsed() {
        return used;
    }

    public int getEnabled() {
        return enabled;
    }

    public List<ChoiceEntity> getChoices() {
        return choices;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public void setChoices(List<ChoiceEntity> choices) {
        this.choices = choices;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public void setMultipleChoice(int multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public int getMultipleChoice() {
        return multipleChoice;
    }
}
