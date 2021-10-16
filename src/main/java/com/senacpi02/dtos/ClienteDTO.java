package com.senacpi02.dtos;


import com.senacpi02.model.Cliente;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NOME é obrigatorio")
    @Length(min = 3, max = 100, message = "O campo nome ter deve entre 3 e 100 caracteres")
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
    @Length (min = 3, max = 11, message = "O campo cpf ter deve entre 3 e 11 caracteres")
    private String cpf;

    @NotEmpty(message = "Campo dataNascimento é obrigatorio")
    @Length (min = 3, max = 20, message = "O campo dataNascimento ter deve entre 3 e 20 caracteres")
    private String dataNascimento;

    @NotEmpty(message = "Campo endereco é obrigatorio")
    @Length (min = 3, max = 100, message = "O campo endereco ter deve entre 3 e 100 caracteres")
    private String endereco;


    public ClienteDTO() {
        super();
    }

    public ClienteDTO(Cliente obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.sexo = obj.getSexo();
        this.email = obj.getEmail();
        this.estadoCivil = obj.getEstadoCivil();
        this.cpf = obj.getCpf();
        this.dataNascimento = obj.getDataNascimento();
        this.endereco = obj.getEndereco();
    }


    // service
    public static ClienteDTO converter(Cliente c) {
        var cliente = new ClienteDTO();
        cliente.setId(c.getId());
        cliente.setNome(c.getNome());
        cliente.setSexo(c.getSexo());
        cliente.setEmail(c.getEmail());
        cliente.setEstadoCivil(c.getEstadoCivil());
        cliente.setCpf(c.getCpf());
        cliente.setDataNascimento(c.getDataNascimento());
        cliente.setEndereco(c.getEndereco());
        return cliente;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        ClienteDTO other = (ClienteDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
