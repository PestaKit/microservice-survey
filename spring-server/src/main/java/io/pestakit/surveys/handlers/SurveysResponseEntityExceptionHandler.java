package io.pestakit.surveys.handlers;

import io.pestakit.surveys.api.exceptions.EmptyListException;
import io.pestakit.surveys.api.exceptions.IllegalChoicesSizeException;
import io.pestakit.surveys.api.exceptions.IllegalIdException;
import io.pestakit.surveys.api.exceptions.IllegalQuestionUrlException;
import io.pestakit.surveys.model.Error;
import io.pestakit.surveys.model.ErrorsList;
import io.pestakit.surveys.validators.QuestionValidator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.unprocessableEntity;

/**
 * Created by ali.miladi on 23.11.2017.
 */

@ControllerAdvice
public class SurveysResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public SurveysResponseEntityExceptionHandler() {
        super();
    }

    //
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        Error error = new Error();
//        error.setCode(400);
//        error.setException(ex.toString());
//        error.setMessage(ex.getMessage());
//        error.setName("Caution !! You posted an empty content");
//        error.setTimestamp(DateTime.now());
//        error.setPath(request.getContextPath());
//        return badRequest().body(error);

//    @ExceptionHandler(MethodArgumentNotValidException.class)


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
//        Error error = newError(422, ex, ex.getMessage(), DateTime.now());
        ErrorsList errorsList = new ErrorsList();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            int code = 422;
            errorsList.add(newError(ex, objectError.getDefaultMessage(), DateTime.now(), objectError.getObjectName()));
        }
        return unprocessableEntity().body(errorsList);
    }

//    }

    @ExceptionHandler(EmptyListException.class)
    protected ResponseEntity<Object> handleEmptyList(EmptyListException ex, WebRequest request) {
        Error error = newError(ex, ex.getMessage(),
                DateTime.now(), "questionURLs");

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
        Error error = newError(ex, ex.getMessage(), DateTime.now(), "questionURLMalformed");
        return unprocessableEntity().body(error);
    }

    @ExceptionHandler(IllegalIdException.class)
    protected ResponseEntity<Object> handleIllegalId(IllegalIdException ex, WebRequest request) {
        Error error = newError(ex, ex.getMessage(), DateTime.now(), "questionId");
        return unprocessableEntity().body(error);
    }

    private Error newError(Exception exception, String message, DateTime timestamp, String field) {
        Error error = new Error();
        error.setException(exception.toString());
        error.setMessage(exception.getMessage());
        error.setTimestamp(DateTime.now());
        error.setField(field);
        return error;
    }

}
