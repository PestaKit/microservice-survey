package io.pestakit.surveys.api.exceptions;

/**
 * Created by ali.miladi on 24.11.2017.
 */
/**
 * Thrown when an empty list gets posted on an endpoint
 */

public class EmptyListException extends RuntimeException{
    private String message;

    public EmptyListException(String message){
        super(message);
        this.message = message;
    }

}
