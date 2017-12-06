package io.pestakit.surveys.handlers;

import io.pestakit.surveys.model.ErroneousField;
import io.pestakit.surveys.model.Error;
import org.joda.time.DateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
        List<ErroneousField> erroneousFields = new ArrayList<ErroneousField>();
        ErroneousField erroneousField = new ErroneousField();
        erroneousField.setFieldName("DTO");
        erroneousField.setErrorCode("Empty");
        erroneousFields.add(erroneousField);
        return unprocessableEntity().body(newError(ex, ex.getMessage(), DateTime.now(), erroneousFields));
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Error error = newError(ex, ex.getMessage(), DateTime.now(), getErroneousFields(ex));
        return unprocessableEntity().body(error);
    }

    private List<ErroneousField> getErroneousFields(MethodArgumentNotValidException ex){
        List<ErroneousField> erroneousFields = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            ErroneousField erroneousField = new ErroneousField();
            erroneousField.setErrorCode(fieldError.getCode());
            erroneousField.setFieldName(fieldError.getField());
            erroneousFields.add(erroneousField);
        }
        return erroneousFields;
    }


    private Error newError(Exception exception, String message, DateTime timestamp, List<ErroneousField> erroneousFields) {
        Error error = new Error();
        error.setException(exception.toString());
        error.setMessage(exception.getMessage());
        error.setTimestamp(DateTime.now().toString());
        error.setFields(erroneousFields);
        return error;
    }

}
