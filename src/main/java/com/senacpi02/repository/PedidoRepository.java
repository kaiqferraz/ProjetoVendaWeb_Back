package com.senacpi02.repository;

import com.senacpi02.model.Cliente;
import com.senacpi02.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer> {

    @Transactional(readOnly = true)
    Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

    @Query("select s from Pedido s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.dataVenda) = :mes")
    List<Pedido> findByNomeAndMes(@Param("nome") String nome, @Param("mes") Integer mes);

}
