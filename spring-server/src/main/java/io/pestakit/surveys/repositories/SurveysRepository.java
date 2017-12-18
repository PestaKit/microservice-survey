package io.pestakit.surveys.repositories;

import io.pestakit.surveys.entities.SurveyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ali.miladi on 21.11.2017.
 */
@Repository
public interface SurveysRepository extends CrudRepository<SurveyEntity, Long>{
}
