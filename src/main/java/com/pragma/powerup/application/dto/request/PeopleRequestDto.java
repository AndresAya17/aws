package com.pragma.powerup.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleRequestDto {

    @NotBlank(message = "The document number is required")
    @Pattern(regexp = "^[0-9]+$", message = "The document number must contain only numbers")
    @Size(min = 5, max = 15, message = "The document number must be between 5 and 15 characters")
    private String documentNumber;

    @NotBlank(message = "The name is required")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "The email is required")
    @Email(message = "The email format is invalid")
    private String email;

}