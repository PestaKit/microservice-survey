package io.pestakit.surveys.repositories;

import io.pestakit.surveys.entities.AnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ali.miladi on 07.12.2017.
 */

@Repository
public interface AnswersRepository extends CrudRepository<AnswerEntity, Long> {
}
