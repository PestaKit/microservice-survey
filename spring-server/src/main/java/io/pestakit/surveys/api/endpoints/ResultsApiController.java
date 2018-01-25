package io.pestakit.surveys.api.endpoints;

import io.pestakit.surveys.api.ResultsApi;
import io.pestakit.surveys.api.util.ResultFromQuery;
import io.pestakit.surveys.model.Result;
import io.pestakit.surveys.repositories.AnswersRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class ResultsApiController implements ResultsApi {

    @Autowired
    AnswersRepository answersRepository;

    @Override
    public ResponseEntity<List<Result>> findResultsOfSurvey(
            @ApiParam(value = "ID of the survey on which we calculate the stats", required = true)
            @PathVariable("idSurvey")
                    Long idSurvey) {
        List<Result> results = new ArrayList<>();
        List<ResultFromQuery> resultFromQueries = answersRepository.getResultsForSurvey(idSurvey);
        for (ResultFromQuery resultFromQuery : resultFromQueries){
            results.add(toResult(resultFromQuery));
        }
        return ok(results);
    }

    private Result toResult(ResultFromQuery resultFromQuery){
        Result result = new Result();
        result.setChoiceText(resultFromQuery.getChoiceText());
        result.setCount(resultFromQuery.getCount());
        result.setIdQuestion(resultFromQuery.getIdQuestion());
        return result;
    }
}
