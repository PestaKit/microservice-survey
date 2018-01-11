package io.pestakit.surveys.repositories;

import io.pestakit.surveys.entities.AnswerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ali.miladi on 07.12.2017.
 */

@Repository
public interface AnswersRepository extends CrudRepository<AnswerEntity, Long> {
//    @Query("SELECT COUNT(*) FROM AnswerEntity a WHERE a.idSurvey = :idSurvey GROUP BY a.idQuestion, a.choices")
//    Integer updateUsed(@Param("questionId") Long questionId, @Param("used") int used);
}
