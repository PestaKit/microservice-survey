package io.pestakit.surveys.handlers;

import io.pestakit.surveys.api.exceptions.EmptyListException;
import io.pestakit.surveys.api.exceptions.IllegalIdException;
import io.pestakit.surveys.api.exceptions.IllegalQuestionUrlException;
import io.pestakit.surveys.model.Error;
import org.joda.time.DateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.unprocessableEntity;

/**
 * Created by ali.miladi on 23.11.2017.
 */

@ControllerAdvice
public class SurveysResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public SurveysResponseEntityExceptionHandler() {
        super();
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        return unprocessableEntity().body(newError(ex, ex.getMessage(), DateTime.now(), new ArrayList<String>()));
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<String> fields = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fields.add(fieldError.getField());
        }
        Error error = newError(ex, ex.getMessage(), DateTime.now(), fields);
        return unprocessableEntity().body(error);
    }


    @ExceptionHandler(EmptyListException.class)
    protected ResponseEntity<Object> handleEmptyList(EmptyListException ex, WebRequest request) {
        Error error = newError(ex, ex.getMessage(),
                DateTime.now(), new ArrayList<String>());

        return unprocessableEntity().body(error);
    }

//    @ExceptionHandler(IllegalChoicesSizeException.class)
//    protected ResponseEntity<Object> handleIllegalChoicesSize(IllegalChoicesSizeException ex, WebRequest request) {
//        Error error = newError(422, ex,
//                ex.getMessage(), "A question should have minimum two choices",
//                DateTime.now(), request.getContextPath());
//        return unprocessableEntity().body(error);
//    }

    @ExceptionHandler(IllegalQuestionUrlException.class)
    protected ResponseEntity<Object> handleIllegalQuestionUrl(IllegalQuestionUrlException ex, WebRequest request) {
        Error error = newError(ex, ex.getMessage(), DateTime.now(), new ArrayList<String>());
        return unprocessableEntity().body(error);
    }

    @ExceptionHandler(IllegalIdException.class)
    protected ResponseEntity<Object> handleIllegalId(IllegalIdException ex, WebRequest request) {
        Error error = newError(ex, ex.getMessage(), DateTime.now(), new ArrayList<String>());
        return unprocessableEntity().body(error);
    }

    private Error newError(Exception exception, String message, DateTime timestamp, List<String> fields) {
        Error error = new Error();
        error.setException(exception.toString());
        error.setMessage(exception.getMessage());
        error.setTimestamp(DateTime.now());
        error.setFields(fields);
        return error;
    }

}
