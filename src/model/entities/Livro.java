package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livro {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int id;
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private int quantidade;

    public Livro() {}

    public Livro(int id, String titulo, String autor, LocalDate dataPublicacao, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.quantidade = quantidade;
    }

    public int getId() {return id;}

    public void setIsbn(int id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

    public LocalDate getDataPublicacao() {return dataPublicacao;}

    public void setDataPublicacao(LocalDate dataPublicacao) {this.dataPublicacao = dataPublicacao;}

    public int getQuantidade() {return quantidade;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Data de publicação: " + dataPublicacao.format(formatter) + ", Quantidade: " + quantidade;
    }

}
