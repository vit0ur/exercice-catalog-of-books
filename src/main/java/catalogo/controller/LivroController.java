package catalogo.controller;

import catalogo.domain.Livro;
import catalogo.service.LivroService;
import java.sql.SQLException;
import java.util.Scanner;

public class LivroController {

    private final LivroService service;
    Scanner scanner = new Scanner(System.in);

    public LivroController() throws Exception {
        this.service = new LivroService();
        service.criarTabela();
    }

    public void cadastrarLivro() throws SQLException {
        String continuar;

        do {
            System.out.print("Digite o nome do livro que deseja cadastrar:");
            String nome = scanner.nextLine();

            System.out.print("Digite o autor do livro:");
            String autor = scanner.nextLine();

            System.out.print("Digite o ano de lançamento do livro:");
            int ano = scanner.nextInt();

            scanner.nextLine();

            service.cadastrarLivro(new Livro(service.MaxId(), nome, autor, ano));

            System.out.print("Deseja cadastrar outro livro? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();

            System.out.print("================== ========================");
        } while (continuar.equals("s"));
    }

    public Livro buscarPorId() {
        System.out.println("Digite o id do livro que deseja encontrar: ");

        int id = scanner.nextInt();

        return service.buscarPorId(id);
    }

    public void listarTodos() {
        service.listarTodos().forEach(l ->
                System.out.println("Livro: " + l.getTitulo() +
                        " | Autor: " + l.getAutor() +
                        " | Publicado: " + l.getAnoPublicacao()));
    }

}