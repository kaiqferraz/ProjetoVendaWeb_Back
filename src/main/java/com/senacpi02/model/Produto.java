package com.senacpi02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo nomeProduto é obrigatorio")
    @Length(min = 3, max = 100, message = "O campo nomeProduto ter deve entre 3 e 100 caracteres")
    private String nomeProduto;

    @NotNull
    @Min(1)
    @Max(1000)
    private Double precoProduto;

    @NotNull
    @Min(1)
    @Max(1000)
    private int quantidadeProduto;

    @NotEmpty(message = "Campo temperaturaProduto é obrigatorio")
    @Length(min = 1, max = 50, message = "O campo temperaturaProduto ter deve entre 1 e 50 caracteres")
    private String temperaturaProduto;


    @JsonIgnore
    @OneToMany(mappedBy="id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for(ItemPedido x : itens) {
            lista.add(x.getPedido());
        }

        return lista;
    }



    public Produto() {
    }

    public Produto(Integer id, String nomeProduto, Double precoProduto, int quantidadeProduto, String temperaturaProduto) {
        super();
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.temperaturaProduto = temperaturaProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getTemperaturaProduto() {
        return temperaturaProduto;
    }

    public void setTemperaturaProduto(String temperaturaProduto) {
        this.temperaturaProduto = temperaturaProduto;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }






}
