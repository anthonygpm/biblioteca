package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private int advertencias;
    private List<Livro> livrosEmprestados = new ArrayList<Livro>();

    public Leitor(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.advertencias = 0;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getEndereco() {return endereco;}

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public int getAdvertencias() {return advertencias;}

    public void setAdvertencias(int advertencias) {this.advertencias = advertencias;}

    public int getQuantidadeLivrosEmprestados() {
        return livrosEmprestados.size();
    }

    public boolean naoEmprestados() {
        return livrosEmprestados.isEmpty();
    }

    public void adicionarLivro(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void removerLivro(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    @Override
    public String toString() {
        return "Leitor [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone= " + telefone + ", número de advertências= " + advertencias + "]";
    }
}
