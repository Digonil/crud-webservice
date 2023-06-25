package com.niles.crudproject.dto;

import com.niles.crudproject.entities.Client;
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
    public ClientRequest(Client client) {
        this(client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildren());
    }
}
