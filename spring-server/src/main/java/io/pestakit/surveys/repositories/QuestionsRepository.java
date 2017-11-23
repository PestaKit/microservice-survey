package io.pestakit.surveys.repositories;

import io.pestakit.surveys.entities.QuestionEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ali.miladi on 09.11.2017.
 */
@Repository
public interface QuestionsRepository extends CrudRepository<QuestionEntity, Long> {
    @Modifying
    @Query("UPDATE QuestionEntity q SET q.used = :used WHERE q.id = :questionId")
    Integer updateUsed(@Param("questionId") Long questionId, @Param("used") int used);
}
