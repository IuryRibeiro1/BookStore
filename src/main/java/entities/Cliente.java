package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;
    private String dataDeCadastro;

//    @OneToMany
//    private List<Pedido> pedido = new ArrayList<>();

    public Cliente() {}

    public Cliente(String cpf, String nome, String email, String telefone, String dataNascimento, String dataDeCadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getCpf(String cpf) {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }


    public void comprasCliente(){

    }

    @Override
    public String toString() {
        return
                " cpf: " + cpf +
                ", nome: " + nome;
    }
}



