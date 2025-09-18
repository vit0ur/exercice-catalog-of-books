import catalogo.controller.LivroController;
import catalogo.domain.Livro;
import catalogo.service.LivroService;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class LivroControllerTest {

    @Test
    public void testCadastrarLivro() throws Exception {
        // Arrange
        LivroService mockService = mock(LivroService.class);
        Scanner mockScanner = mock(Scanner.class);

        // Simula entrada do usuário
        when(mockScanner.nextLine())
                .thenReturn("O Senhor dos Anéis") // título
                .thenReturn("J.R.R. Tolkien")     // autor
                .thenReturn("n");                 // continuar

        when(mockScanner.nextInt()).thenReturn(1954);
        when(mockService.MaxId()).thenReturn(1);

        LivroController controller = new LivroController(mockService, mockScanner);

        // Act
        controller.cadastrarLivro();

        // Assert
        verify(mockService).cadastrarLivro(
                argThat(livro ->
                        livro.getTitulo().equals("O Senhor dos Anéis") &&
                                livro.getAutor().equals("J.R.R. Tolkien") &&
                                livro.getAnoPublicacao() == 1954
                )
        );
    }

    @Test
    public void testBuscarPorId() throws Exception {
        // Arrange
        LivroService mockService = mock(LivroService.class);
        Scanner mockScanner = mock(Scanner.class);

        Livro livro = new Livro(1, "1984", "George Orwell", 1949);
        when(mockScanner.nextInt()).thenReturn(1);
        when(mockService.buscarPorId(1)).thenReturn(livro);

        LivroController controller = new LivroController(mockService, mockScanner);

        // Act
        Livro resultado = controller.buscarPorId();

        // Assert
        verify(mockService).buscarPorId(1);
        assert resultado.getTitulo().equals("1984");
    }
}