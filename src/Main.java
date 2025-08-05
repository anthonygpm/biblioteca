package main;

import model.entities.Biblioteca;
import model.entities.Leitor;
import model.entities.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Biblioteca b = new Biblioteca();

        System.out.println("Bem vindo ao sistema da Biblioteca Ninolândia!");

        try {
            while (true) {
                System.out.println("""
                    ---------------------------------------
                    O que deseja fazer?
                    [1] Cadastrar novo livro
                    [2] Excluir livro
                    [3] Listar livros
                    [4] Modificar quantidade de um livro
                    [5] Buscar livro
                    [6] Cadastrar novo leitor
                    [7] Excluir leitor
                    [8] Listar leitores
                    [9] Emprestar livro para leitor
                    [10] Receber livro de leitor
                    [11] Sair do programa
                    ---------------------------------------""");

                int escolha = sc.nextInt();
                sc.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o id do livro: ");
                        int id =  sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o titulo: ");
                        String titulo = sc.nextLine();
                        System.out.print("Digite o nome do autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Digite a data de publicação (dd/MM/yyyy): ");
                        LocalDate dataPublicacao = LocalDate.parse(sc.nextLine(), formatter);
                        System.out.print("Digite o quantidade de livros: ");
                        int quantidade = sc.nextInt();
                        Livro livro = new Livro(id, titulo, autor, dataPublicacao, quantidade);

                        b.cadastrarLivro(livro);
                        break;
                    case 2:
                        System.out.print("Digite o título do livro: ");
                        String tituloRemove = sc.nextLine();

                        b.excluirLivro(tituloRemove);
                        break;
                    case 3:
                        b.listarLivros();
                        break;
                    case 4:
                        System.out.print("Digite o título do livro que você deseja alterar a quantidade: ");
                        String tituloAlterar = sc.nextLine();
                        System.out.print("Nova quantidade de livros: ");
                        int quantidadeAlterar = sc.nextInt();
                        sc.nextLine();

                        b.editarQuantidade(tituloAlterar, quantidadeAlterar);
                        break;
                    case 5:
                        System.out.print("Digite o nome do livro que você deseja buscar: ");
                        String tituloBuscar = sc.nextLine();
                        System.out.println(b.buscarLivro(tituloBuscar));
                        break;
                    case 6:
                        System.out.print("Digite o nome do leitor: ");
                        String nome = sc.nextLine();
                        System.out.print("Digite o cpf do leitor: ");
                        String cpf = sc.nextLine();
                        System.out.print("Digite o endereço do leitor: ");
                        String endereco = sc.nextLine();
                        System.out.print("Digite o telefone do leitor: ");
                        String telefone = sc.nextLine();
                        Leitor leitor = new Leitor(nome, cpf, endereco, telefone);

                        b.cadastrarLeitor(leitor);
                        break;
                    case 7:
                        System.out.print("Digite o cpf do leitor: ");
                        String cpfRemove = sc.nextLine();

                        b.excluirLeitor(cpfRemove);
                        break;
                    case 8:
                        b.listarLeitores();
                        break;
                    case 9:
                        System.out.print("Digite o cpf do leitor: ");
                        String cpfListar = sc.nextLine();
                        System.out.print("Digite o título do livro: ");
                        String tituloListar = sc.nextLine();

                        b.emprestarLivro(cpfListar, tituloListar);
                        break;
                    case 10:
                        System.out.print("Digite o cpf do leitor: ");
                        String cpfRecebe = sc.nextLine();
                        System.out.print("Digite o título do livro: ");
                        String tituloRecebe = sc.nextLine();
                        System.out.print("Digite a data de devolução (dd/MM/yyyy): ");
                        LocalDate data = LocalDate.parse(sc.nextLine(), formatter);

                        b.receberLivro(cpfRecebe, tituloRecebe, data);
                        break;
                    case 11:
                        System.out.println("Obrigado por usar o sistema!");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                        break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
