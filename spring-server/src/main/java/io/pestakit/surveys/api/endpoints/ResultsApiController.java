package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.ResultsApi;
import io.pestakit.surveys.model.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ResultsApiController implements ResultsApi {

    @Override
    public ResponseEntity<List<Result>> findResultsOfSurvey(
            @ApiParam(value = "ID of the survey on which we calculate the stats",required=true )
            @PathVariable("idSurvey")
                    Long idSurvey){
        return null;
    }
}
