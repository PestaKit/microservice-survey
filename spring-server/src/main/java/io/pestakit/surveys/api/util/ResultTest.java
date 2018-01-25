package io.pestakit.surveys.api.util;

public class ResultTest {

    private Long count;
    private Long idQuestion;
    private String text;

    public ResultTest(String text, Long count, Long idQuestion) {
        this.count = count;
        this.idQuestion = idQuestion;
        this.text = text;
    }

    public Long getCount() {
        return count;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public String getText() {
        return text;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setText(String text) {
        this.text = text;
    }
}

