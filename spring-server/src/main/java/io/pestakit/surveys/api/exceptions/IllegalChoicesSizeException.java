package io.pestakit.surveys.api.exceptions;

/**
 * Created by ali.miladi on 25.11.2017.
 */

/**
 * An exception to announce a malformed list of choices in the body of a question
 */
public class IllegalChoicesSizeException extends RuntimeException{
    public IllegalChoicesSizeException(String message){
        super(message);
    }
}
