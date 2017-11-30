package io.pestakit.surveys.validators;

import io.pestakit.surveys.model.Choice;
import io.pestakit.surveys.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Collection;
import java.util.List;

/**
 * Created by ali.miladi on 30.11.2017.
 */
@Component
public class QuestionValidator implements Validator {

    // from https://stackoverflow.com/questions/34011892/spring-validation-for-requestbody-parameters-bound-to-collections-in-controller/36790509#answer-36790509
    private final Validator validator;

    public QuestionValidator(LocalValidatorFactoryBean validatorFactory) {
        this.validator = validatorFactory;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Question.class.isAssignableFrom(clazz);
    }

    /**
     * Validate each element inside the supplied {@link Collection}.
     * <p>
     * The supplied errors instance is used to report the validation errors.
     *
     * @param target the collection that is to be validated
     * @param errors contextual state about the validation process
     */
    @Override
    @SuppressWarnings("rawtypes")
    public void validate(Object target, Errors errors) {
        Question question = (Question) target;
        Collection<Choice> collection = question.getChoices();
        if (collection.size() == 0) {
            errors.reject("Empty list", "Empty choices list");
        } else if (collection.size() < 2){
            errors.reject("Tiny list", "Too small choices list(minimum 2");
        }
            for (Object object : collection) {
                ValidationUtils.invokeValidator(validator, object, errors);
            }
    }
}
