package com.senacpi02.controller;


import com.senacpi02.model.Pedido;

import com.senacpi02.repository.ClienteRepository;
import com.senacpi02.repository.PedidoRepository;
import com.senacpi02.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@CrossOrigin("*") // desbloqueia a política CORS
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private PedidoRepository pedidoRepository;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id) {
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
        obj = service.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping
    public List<Pedido> pesquisar(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                           @RequestParam(value = "mes", required = false) Integer mes) {
        nome = "%" + nome + "%";
        return pedidoRepository.findByNomeAndMes(nome, mes);
    }




}
