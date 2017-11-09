package io.pestakit.surveys.api.exceptions;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-09T07:37:17.519+01:00")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
