package com.demo.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhuangxicnheng
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object> {

    private String values;

    private String message;

    @Override
    public void initialize(NotEmpty notEmpty) {
        this.values = notEmpty.values();
        this.message = notEmpty.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return false;
        } else {
            return true;
        }
    }
}
