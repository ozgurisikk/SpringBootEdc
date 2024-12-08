package com.luv2code.springdemo.mvc.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String > {
    private String coursePrefix;
    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if (theCode != null){
            String regex = "^" + coursePrefix + "\\d{3}$";
            result = theCode.matches(regex);
        }else {
            result = true;
        }
        return result;

    }
}
