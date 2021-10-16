package com.senacpi02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity // entidade de banco de dados
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME é obrigatorio")
    @Length (min = 3, max = 100, message = "O campo nome ter deve entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo sexo é obrigatorio")
    @Length (min = 3, max = 15, message = "O campo sexo ter deve entre 3 e 15 caracteres")
    private String sexo;

    @NotEmpty(message = "Campo email é obrigatorio")
    @Length (min = 3, max = 100, message = "O campo email ter deve entre 3 e 100 caracteres")
    private String email;

    @NotEmpty(message = "Campo estadoCivil é obrigatorio")
    @Length (min = 3, max = 50, message = "O campo estadoCivil ter deve entre 3 e 50 caracteres")
    private String estadoCivil;

    @NotEmpty(message = "Campo cpf é obrigatorio")
    @CPF()
    @Column(name = "cpf", nullable = false, unique = true) // tratar CPF REPETIDO
    private String cpf;

    @NotEmpty(message = "Campo dataNascimento é obrigatorio")
    @Length (min = 7, max = 8, message = "O campo dataNascimento ter deve entre 7 e 8 caracteres")
    private String dataNascimento;

    @NotEmpty(message = "Campo endereco é obrigatorio")
    @Length (min = 3, max = 100, message = "O campo endereco ter deve entre 3 e 100 caracteres")
    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy="cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String sexo, String email, String estadoCivil, String cpf, String dataNascimento, String endereco) {
        super();
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



}
