package com.niles.crudproject.dto;

import com.niles.crudproject.entities.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientResponse(

        Long id,
        String name,
        String cpf,
        Double income,
        LocalDate birthDate,
        Integer children) {

    public ClientResponse(Client client) {
        this(client.getId(), client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildren());
    }
}
