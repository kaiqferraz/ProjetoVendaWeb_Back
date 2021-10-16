package com.senacpi02.controller;


import com.senacpi02.dtos.ClienteDTO;
import com.senacpi02.model.Cliente;
import com.senacpi02.repository.ClienteRepository;
import com.senacpi02.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin("*") // desbloqueia a política CORS
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;


    // http://localhost:8080/clientes/1  Buscar cliente por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // http://localhost:8080/clientes Buscar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    // http://localhost:8080/clientes/filter?nome=ka  Buscar por nome
    @GetMapping("/filter")
    public List<ClienteDTO> findClienteByName(@RequestParam("nome") String nome){
        return this.clienteRepository.findByNomeContrains(nome)
                .stream()
                .map(ClienteDTO::converter)
                .collect(Collectors.toList());

    }



    // http://localhost:8080/clientes cria um cliente
    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente obj) {
        obj = clienteService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    // http://localhost:8080/clientes/1 altera um cliente
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@Valid @PathVariable Integer id, @RequestBody ClienteDTO objDto) {
        Cliente newObj = clienteService.update(id, objDto);
        return ResponseEntity.ok().body(new ClienteDTO(newObj));
    }


    // http://localhost:8080/clientes/1  Deleta um cliente.
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
