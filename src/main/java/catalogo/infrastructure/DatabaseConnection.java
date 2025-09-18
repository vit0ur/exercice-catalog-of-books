package catalogo.infrastructure;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private static final String PROPERTIES_FILE = "application.properties";

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();

        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new RuntimeException("Arquivo de configuração '" + PROPERTIES_FILE + "' não encontrado.");
            }

            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);
        }
    }
}