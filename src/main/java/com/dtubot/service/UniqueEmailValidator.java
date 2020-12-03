package com.dtubot.service;

import com.dtubot.entity.DAO.Intents;
import com.dtubot.repository.IntentsRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private IntentsRepository userRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String tag, ConstraintValidatorContext constraintValidatorContext) {
//        Intents user1 = userRepository.findByEmailAndEnabledIsTrue(tag);
//        if(user1!=null) {
//            return false;
//        }
        return true;
    }
}
