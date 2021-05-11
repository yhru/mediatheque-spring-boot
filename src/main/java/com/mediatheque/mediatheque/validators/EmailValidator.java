package com.mediatheque.mediatheque.validators;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate <String> {

    @Override
    public boolean test(String email){
        // REGEX to validate email TODO
        return true;
    }
}