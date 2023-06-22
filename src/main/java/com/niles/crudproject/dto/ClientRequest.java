package com.niles.crudproject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientRequest(
        @NotEmpty
        String name,
        String cpf,
        Double income,
        @PastOrPresent
        LocalDate birthDate,
        Integer children
) {
}
