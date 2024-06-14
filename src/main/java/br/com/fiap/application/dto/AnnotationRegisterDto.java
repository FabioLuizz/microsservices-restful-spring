package br.com.fiap.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AnnotationRegisterDto(
        Long id,

        @NotBlank(message = "The city field is mandatory")
        String city,

        @NotBlank(message = "The address field is mandatory")
        String address,

        @NotNull(message = "The collection Date field is mandatory")
        LocalDate collectionDate,

        @NotBlank(message = "The trash type field is mandatory")
        String trashType,

        @NotBlank(message = "The status type field is mandatory")
        String status
) {
}
