import catalogo.controller.EmailController;
import catalogo.service.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class EmailControllerTest {

    @Test
    public void testEnviarChamaEmailServiceComParametrosCorretos() throws IOException {
        // Arrange
        EmailService mockEmailService = Mockito.mock(EmailService.class);
        EmailController controller = new EmailController(mockEmailService);

        String destinatario = "teste@exemplo.com";
        String assunto = "Assunto de Teste";
        String corpo = "Corpo do e-mail";

        // Act
        controller.enviar(destinatario, assunto, corpo);

        // Assert
        Mockito.verify(mockEmailService).enviarEmail(destinatario, assunto, corpo);
    }
}