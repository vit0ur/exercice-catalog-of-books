package catalogo.controller;

import catalogo.service.EmailService;
import java.io.IOException;

public class EmailController {

    private final EmailService emailService;

    public EmailController() throws IOException {
        this.emailService = new EmailService();
    }

    public void enviar(String destinatario, String assunto, String corpo) {
        emailService.enviarEmail(destinatario, assunto, corpo);
    }
}
