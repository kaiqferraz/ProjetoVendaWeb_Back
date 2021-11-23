package com.senacpi02.repository;

import com.senacpi02.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

 @Query(value = "select c from Cliente c where c.nome like %?1%")
 List<Cliente> findByNomeContrains(String nome);

 @Transactional(readOnly = true)
 Cliente findByEmail(String email);








}
