package com.senacpi02.dtos;

import com.senacpi02.model.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(Produto obj) {
        super();
        this.id = obj.getId();
        this.nomeProduto = obj.getNomeProduto();
        this.precoProduto = obj.getPrecoProduto();
        this.quantidadeProduto = obj.getQuantidadeProduto();
        this.temperaturaProduto = obj.getTemperaturaProduto();
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
        ProdutoDTO other = (ProdutoDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }






}