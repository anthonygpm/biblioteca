package model.entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Biblioteca {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Map<String, Livro> livros = new TreeMap<>();
    private Map<String, Leitor> leitores = new TreeMap<>();
    private List<EmprestimoLivro> emprestimos = new ArrayList<EmprestimoLivro>();

    public Biblioteca() {}

    public void cadastrarLivro(Livro livro) {
        livros.put(livro.getTitulo(), livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void excluirLivro(String titulo) {
        if (livros.containsKey(titulo)) {
            livros.remove(titulo);
        }
        else {
            System.out.println("O livro não foi encontrado no catálogo.");
        }
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        }
        else {
            for (Livro livro : livros.values()) {
                System.out.println(livro);
            }
        }
    }

    public Livro buscarLivro(String titulo) {
        if (livros.containsKey(titulo)) {
            return livros.get(titulo);
        }
        else {
            System.out.println("Livro não encontrado no catálogo.");
            return null;
        }
    }

    public void editarQuantidade(String titulo, int quantidade) {
        if (livros.containsKey(titulo)) {
            System.out.println("Quantidade de livros atual: " + livros.get(titulo).getQuantidade());
            livros.get(titulo).setQuantidade(quantidade);
            System.out.println("Quantidade alterada com sucesso!");
        }
    }

    public void cadastrarLeitor(Leitor leitor) {
        leitores.put(leitor.getCpf(), leitor);
        System.out.println("Leitor cadastrado com sucesso!");
    }

    public void excluirLeitor(String cpf) {
        if (leitores.containsKey(cpf)) {
            leitores.remove(cpf);
            System.out.println("Leitor excluído com sucesso!");
        }
        else {
            System.out.println("Não foi possível encontrar o leitor.");
        }
    }

    public void emprestarLivro(String cpf, String titulo) {
        if (leitores.containsKey(cpf)) {
            if (leitores.get(cpf).getQuantidadeLivrosEmprestados() > 5) {
                System.out.println("Não é possível alugar mais de 5 livros simultaneamente!");
            }
            else if (livros.get(titulo).getQuantidade() <= 1) {
                System.out.println("Não há exemplares suficientes desse livro para emprestar.");
            }
            else {
                emprestimos.add(new EmprestimoLivro(livros.get(titulo), leitores.get(cpf), LocalDate.now()));
                for (EmprestimoLivro emprestimo : emprestimos) {
                    if (cpf.equals(emprestimo.getLeitor().getCpf()) && titulo.equals(emprestimo.getLivro().getTitulo())) {
                        emprestimo.alugarLivro();
                    }
                }
            }
        }
        else {
            System.out.println("O cliente não possui cadastro no sistema.");
        }
    }

    public void receberLivro(String cpf, String titulo, LocalDate dataDevolucao) {
        Leitor leitor = leitores.get(cpf);
        if (leitor == null) {
            System.out.println("Leitor não encontrado.");
            return;
        }
        if (leitor.naoEmprestados()) {
            System.out.println("Não há livros emprestados associados a esse leitor.");
        }
        else {
            for(EmprestimoLivro emprestimo : emprestimos) {
                if (cpf.equals(emprestimo.getLeitor().getCpf()) && titulo.equals(emprestimo.getLivro().getTitulo())) {
                    emprestimo.devolverLivro(dataDevolucao);
                    emprestimos.remove(emprestimo);
                    break;
                }
            }
        }
    }

    public void listarLeitores() {
        if (leitores.isEmpty()) {
            System.out.println("Não há leitores cadastrados.");
        }
        else {
            for (Leitor leitor : leitores.values()) {
                System.out.println(leitor);
            }
        }
    }

}
