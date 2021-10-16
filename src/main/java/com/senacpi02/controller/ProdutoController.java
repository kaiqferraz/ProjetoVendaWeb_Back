package com.senacpi02.controller;



import com.senacpi02.dtos.ProdutoDTO;
import com.senacpi02.model.Produto;
import com.senacpi02.service.ProdutoService;
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
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;



    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> list = produtoService.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @PostMapping
    public ResponseEntity<Produto> create(@Valid @RequestBody Produto obj) {
        obj = produtoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@Valid @PathVariable Integer id, @RequestBody ProdutoDTO objDto) {
        Produto newObj = produtoService.update(id, objDto);
        return ResponseEntity.ok().body(new ProdutoDTO(newObj));
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
