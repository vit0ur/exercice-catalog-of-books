package catalogo.service;

import catalogo.domain.Email;
import catalogo.infrastructure.JakartaEmailSender;
import java.io.IOException;

public class EmailService {
    private final JakartaEmailSender emailSender;

    public EmailService() throws IOException {
        this.emailSender = new JakartaEmailSender();
    }

    public void enviarEmail(String to, String subject, String body) {
        Email email = new Email(to, subject, body);
        emailSender.send(email);
    }
}