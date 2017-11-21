/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.pestakit.surveys.api;

import io.pestakit.surveys.model.Error;
import io.pestakit.surveys.model.Survey;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-21T16:11:33.349+01:00")

@Api(value = "surveys", description = "the surveys API")
public interface SurveysApi {

    @ApiOperation(value = "", notes = "Create a survey", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Void.class),
        @ApiResponse(code = 422, message = "Unprocessable Entity", response = Void.class) })
    
    @RequestMapping(value = "/surveys",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createSurvey(@ApiParam(value = "The survey to be created" ,required=true )  @Valid @RequestBody Survey idSurvey);


    @ApiOperation(value = "", notes = "Returns the identified survey", response = Survey.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Survey.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    
    @RequestMapping(value = "/surveys/{id_survey}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Survey> findSurveyById(@ApiParam(value = "ID of survey to fetch",required=true ) @PathVariable("id_survey") Long idSurvey);


    @ApiOperation(value = "", notes = "Returns the identified survey", response = Survey.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Survey.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    
    @RequestMapping(value = "/surveys",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Survey> getAllSurveys();

}