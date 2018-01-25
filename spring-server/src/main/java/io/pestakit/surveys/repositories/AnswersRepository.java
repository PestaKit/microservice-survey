package io.pestakit.surveys.repositories;

import io.pestakit.surveys.api.util.ResultFromQuery;
import io.pestakit.surveys.entities.AnswerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ali.miladi on 07.12.2017.
 */

@Repository
public interface AnswersRepository extends CrudRepository<AnswerEntity, Long> {
    @Query("SELECT new io.pestakit.surveys.api.util.ResultFromQuery(c.text, COUNT(c), a.idQuestion) FROM  AnswerEntity a, IN (a.choices) c " +
            "WHERE a.idSurvey = :idSurvey GROUP BY  a.idUser, a.idQuestion, c.text")
    List<ResultFromQuery> getResultsForSurvey(@Param("idSurvey") Long idSurvey);
}
