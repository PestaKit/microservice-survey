package io.pestakit.surveys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ali.miladi on 08.11.2017.
 */
@Entity
public class ChoiceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
