package io.pestakit.surveys.api.exceptions;

/**
 * Created by ali.miladi on 26.11.2017.
 */

/**
 * An exception to handle bad URLs in a survey's body
 */
public class IllegalQuestionUrlException extends RuntimeException {
    public IllegalQuestionUrlException(String message){
        super(message);
    }
}
