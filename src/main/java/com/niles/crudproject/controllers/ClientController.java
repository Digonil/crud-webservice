package com.niles.crudproject.controllers;

import com.niles.crudproject.dto.ClientRequest;
import com.niles.crudproject.dto.ClientResponse;
import com.niles.crudproject.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<Page> findAll(Pageable pageable) {
        Page<ClientResponse> responses = service.findAll(pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<ClientResponse> findById(@PathVariable Long id) {
        ClientResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ClientResponse> save(@Valid @RequestBody ClientRequest request) {
        ClientResponse response = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/id")
    public ResponseEntity<ClientResponse> update(@PathVariable Long id, @RequestBody ClientRequest request) {
        var updatedResponse = service.update(id, request);
        return ResponseEntity.ok(updatedResponse);
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
