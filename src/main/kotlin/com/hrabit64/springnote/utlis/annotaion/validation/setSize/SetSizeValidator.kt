package com.hrabit64.springnote.utlis.annotaion.validation.setSize

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class SetSizeValidator: ConstraintValidator<CheckSetSize, Set<*>> {

    var max: Int = 0

    override fun initialize(constraintAnnotation: CheckSetSize?) {

        this.max = constraintAnnotation?.max!!

    }

    override fun isValid(value: Set<*>?, context: ConstraintValidatorContext?): Boolean {

        if(value == null) return true

        return value.size <= this.max
    }
}