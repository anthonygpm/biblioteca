package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmprestimoLivro {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Livro livro;
    private Leitor leitor;
    private LocalDate dataDeEmprestimo;
    private LocalDate dataDeDevolucao;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public EmprestimoLivro(Livro livro, Leitor leitor, LocalDate dataDeEmprestimo) {
        this.livro = livro;
        this.leitor = leitor;
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataDeDevolucao =  dataDeEmprestimo.plusDays(14);
    }

    public void alugarLivro() {
        leitor.adicionarLivro(livro);
        livro.setQuantidade(livro.getQuantidade() - 1);
        System.out.println("Livro " + livro.getTitulo() + " alugado com sucesso!");
        System.out.println("A data limite para devolução é : " + dataDeDevolucao.format(formatter));
    }

    public void devolverLivro(LocalDate dataDeDevolucao) {
        if (dataDeDevolucao.isAfter(this.dataDeDevolucao)) {
            leitor.setAdvertencias(leitor.getAdvertencias() + 1);
            System.out.println("O leitor devolveu o livro após a data de devolução. Uma advertência foi adicionada a sua conta.");
        }

        leitor.removerLivro(livro);
        livro.setQuantidade(livro.getQuantidade() + 1);
        System.out.println("Livro " + livro.getTitulo() + " devolvido!");
    }
}
