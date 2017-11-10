package io.pestakit.surveys.repositories;

import io.pestakit.surveys.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ali.miladi on 09.11.2017.
 */
    @Repository
public interface QuestionsRepository extends CrudRepository<QuestionEntity, Long> {
}
