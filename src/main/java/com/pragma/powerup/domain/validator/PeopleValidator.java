package com.pragma.powerup.domain.validator;

import com.pragma.powerup.domain.model.PeopleModel;

import java.util.regex.Pattern;

public class PeopleValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String NUMERIC_REGEX = "^[0-9]+$";

    public static void validate(PeopleModel request) {
        validateDocumentNumber(request.getDocumentNumber());
        validateName(request.getName());
        validateEmail(request.getEmail());
    }

    private static void validateDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            throw new IllegalArgumentException("The document number is required");
        }
        if (!Pattern.matches(NUMERIC_REGEX, documentNumber)) {
            throw new IllegalArgumentException("The document number must contain only numbers");
        }
        if (documentNumber.length() < 5 || documentNumber.length() > 15) {
            throw new IllegalArgumentException("The document number must be between 5 and 15 characters");
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name is required");
        }
        if (name.length() < 2 || name.length() > 50) {
            throw new IllegalArgumentException("The name must be between 2 and 50 characters");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("The email is required");
        }
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("The email format is invalid");
        }
    }

}
