import java.io.IOException;
import java.util.Scanner;
import catalogo.controller.EmailController;
import catalogo.controller.LivroController;
import catalogo.domain.Livro;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            LivroController controller = new LivroController();

            controller.cadastrarLivro();
            Livro livro = controller.buscarPorId();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor, informe seu e-mail para confirmar o cadastro.");
            String destinatario = scanner.nextLine();

            System.out.println("Livro buscado por ID: " + livro.getTitulo());
            System.out.println("========================================");
            System.out.println("Todos os livros:");
            controller.listarTodos();

            EmailController emailController = new EmailController();

            emailController.enviar(
                    destinatario,
                    "Seu livro foi adicionado à sua biblioteca",
                    "Olá,\n" +
                            "Confirmamos que o livro foi cadastrado com sucesso em nosso sistema.\n" +
                            "Agradecemos por utilizar nossa plataforma!\n" +
                            "Atenciosamente,"
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}