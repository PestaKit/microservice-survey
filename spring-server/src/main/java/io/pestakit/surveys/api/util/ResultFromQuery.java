package io.pestakit.surveys.api.util;

public class ResultFromQuery {

    private Long count;
    private Long idQuestion;
    private String choiceText; // Here choiceText is just the text of the choiceText object

    public ResultFromQuery(String choiceText, Long count, Long idQuestion) {
        this.count = count;
        this.idQuestion = idQuestion;
        this.choiceText = choiceText;
    }

    public Long getCount() {
        return count;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }
}

