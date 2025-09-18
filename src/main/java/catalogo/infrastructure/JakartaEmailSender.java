package catalogo.infrastructure;

import jakarta.mail.*;
import catalogo.domain.Email;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import jakarta.mail.Authenticator;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class JakartaEmailSender {
    private final String username;
    private final String password;
    private final String host;
    private final String port;
    private final boolean starttls;
    private final boolean auth;

    public JakartaEmailSender() throws IOException {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo application.properties não encontrado.");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar application.properties", e);
        }

        this.username = props.getProperty("mail.smtp.username");
        this.password = props.getProperty("mail.smtp.password");
        this.host = props.getProperty("mail.smtp.host");
        this.port = props.getProperty("mail.smtp.port");
        this.starttls = Boolean.parseBoolean(props.getProperty("mail.smtp.starttls"));
        this.auth = Boolean.parseBoolean(props.getProperty("mail.smtp.auth"));

    }

    public void send(Email email) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", String.valueOf(auth));
        props.put("mail.smtp.starttls.enable", String.valueOf(starttls));
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email.getTo())
            );
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}