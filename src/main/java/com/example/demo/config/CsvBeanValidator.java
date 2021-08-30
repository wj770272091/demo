package com.example.demo.config;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @NAME: CsvBeanValidator
 * @USER: 77027
 * @DATE: 2021/1/5
 * @TIME: 9:33
 */
public class CsvBeanValidator<Person> implements Validator<Person>, InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public void validate(Object o) throws ValidationException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(o);
        if (constraintViolations.size()>0){
            StringBuilder message= new StringBuilder();
            for (ConstraintViolation constraintViolation : constraintViolations){
              message.append(constraintViolation.getMessage()+"\n");
            }
            throw new ValidationException(message.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        validator=validatorFactory.usingContext().getValidator();
    }
}
