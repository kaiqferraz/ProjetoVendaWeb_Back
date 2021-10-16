package com.senacpi02.service;


import com.senacpi02.dtos.ProdutoDTO;
import com.senacpi02.model.Produto;
import com.senacpi02.repository.ProdutoRepository;
import com.senacpi02.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Produto não encontrado! ID: " + id + ", TIPO: " + Produto.class.getName()));

    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();

    }


    public Produto create(Produto obj) {
        obj.setId(null);
        return produtoRepository.save(obj);
    }


    public Produto update(Integer id, ProdutoDTO objDto) {
        Produto obj = findById(id);
        obj.setNomeProduto(objDto.getNomeProduto());
        obj.setPrecoProduto(objDto.getPrecoProduto());
        obj.setQuantidadeProduto(objDto.getQuantidadeProduto());
        obj.setTemperaturaProduto(objDto.getTemperaturaProduto());

        return produtoRepository.save(obj);
    }


    public void delete(Integer id) {
        Produto obj = findById(id);
        produtoRepository.delete(obj);
    }


}
