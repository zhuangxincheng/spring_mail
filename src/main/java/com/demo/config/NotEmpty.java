package com.demo.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = NotEmptyValidator.class)
public @interface NotEmpty {
    String values() default "500";
    String message() default "参数认证失败";

    Class<?>[] groups() default {};
    Class<? extends Payload>[]  payload() default {};

}
