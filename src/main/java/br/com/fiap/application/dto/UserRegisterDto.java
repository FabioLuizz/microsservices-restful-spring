package br.com.fiap.application.dto;

import br.com.fiap.application.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDto(
        Long userId,

        @NotBlank(message = "username is required")
        String name,

        @NotBlank(message = "User email is mandatory")
        @Email(message = "the user's email is not valid")
        String email,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 6, max = 20, message = "The password must contain between 6 and 20 characters")
        String password,
        UserRole role
) {
}
