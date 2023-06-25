package com.niles.crudproject.services;

import com.niles.crudproject.dto.ClientRequest;
import com.niles.crudproject.entities.Client;
import com.niles.crudproject.repository.ClientRepository;
import com.niles.crudproject.services.exceptions.DatabaseException;
import com.niles.crudproject.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientRequest> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientRequest(x));
    }

    @Transactional(readOnly = true)
    public ClientRequest findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Id não encontrado"));
        return new ClientRequest(client);
    }

    @Transactional
    public ClientRequest save(ClientRequest request) {
        Client client = new Client(request);
        var entity = repository.save(client);
        return new ClientRequest(entity);
    }

    public ClientRequest update(Long id, ClientRequest request) {
        Client client = repository.getReferenceById(id);
        copyRequestToEntity(request, client);
        Client result = repository.save(client);
        return new ClientRequest(result);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("recurso não encotrado");
        }
        try {
            repository.deleteById(id);
        } catch (DatabaseException e) {
            throw new DatabaseException("Falha de integridade referencial!");
        }

    }

    public void copyRequestToEntity(ClientRequest request, Client entity) {
        entity.setName(request.name());
        entity.setCpf(request.cpf());
        entity.setIncome(request.income());
        entity.setBirthDate(request.birthDate());
        entity.setChildren(request.children());
    }
}
