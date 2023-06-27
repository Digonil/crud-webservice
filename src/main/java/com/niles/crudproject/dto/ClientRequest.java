package com.niles.crudproject.dto;

import com.niles.crudproject.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientRequest(
        @NotBlank(message = "Name can`t be blank")
        String name,
        String cpf,
        Double income,
        @PastOrPresent(message = "Date can´t be in the future")
        LocalDate birthDate,
        Integer children
) {
    public ClientRequest(Client client) {
        this(client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildren());
    }
}
