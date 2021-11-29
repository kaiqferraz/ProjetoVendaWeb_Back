package com.senacpi02.service;

import com.senacpi02.dtos.ClienteDTO;
import com.senacpi02.model.Cliente;
import com.senacpi02.repository.ClienteRepository;
import com.senacpi02.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! ID: " + id + ", TIPO: " + Cliente.class.getName()));

    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();

    }

    public Cliente create(Cliente obj) {
        obj.setId(null);
        return clienteRepository.save(obj);
    }

    public Cliente update(Integer id, ClienteDTO objDto) {
        Cliente obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setSexo(objDto.getSexo());
        obj.setEmail(objDto.getEmail());
        obj.setEstadoCivil(objDto.getEstadoCivil());
        obj.setCpf(objDto.getCpf());
        obj.setDataNascimento(objDto.getDataNascimento());
        obj.setEndereco(objDto.getEndereco());
        return clienteRepository.save(obj);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        clienteRepository.delete(obj);
    }
}
