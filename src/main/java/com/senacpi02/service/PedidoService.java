package com.senacpi02.service;


import com.senacpi02.model.ItemPedido;
import com.senacpi02.model.Pedido;

import com.senacpi02.repository.ItemPedidoRepository;
import com.senacpi02.repository.PedidoRepository;
import com.senacpi02.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteService clienteService;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id
                + ", Tipo: " + Pedido.class.getName()));
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();

    }

    @Transactional
    public Pedido inserir(Pedido obj) {
        obj.setId(null);
        obj.setDataVenda(new Date());
        obj.setCliente(clienteService.findById(obj.getCliente().getId()));

        obj = pedidoRepository.save(obj);
        for (ItemPedido ip : obj.getItens()) {
            ip.setProduto(produtoService.findById(ip.getProduto().getId()));
            ip.setPreco(produtoService.findById(ip.getProduto().getId()).getPrecoProduto());
            ip.setPreco(ip.getProduto().getPrecoProduto());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        return obj;
    }


}
