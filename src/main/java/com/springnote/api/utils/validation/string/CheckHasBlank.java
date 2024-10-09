package com.springnote.api.utils.validation.string;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckHasBlankValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckHasBlank {

    String message() default "공백이 포함 되어있습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
