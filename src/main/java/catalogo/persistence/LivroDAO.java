package catalogo.persistence;

import catalogo.domain.Livro;
import catalogo.infrastructure.DatabaseConnection;
import catalogo.repositories.LivroRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements LivroRepository {

    private final Connection conn;

    public LivroDAO() throws Exception {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void criarTabela() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS livro (
                id SERIAL PRIMARY KEY,
                titulo VARCHAR(255) NOT NULL,
                autor VARCHAR(255) NOT NULL,
                ano_publicacao INT NOT NULL
            )
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    @Override
    public void salvar(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getAnoPublicacao());
            ps.executeUpdate();
        }
    }

    @Override
    public Livro buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao")
                );
            }
        }
        return null;
    }

    @Override
    public List<Livro> listarTodos() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livros.add(new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao")
                ));
            }
        }
        return livros;
    }

    @Override
    public int MaxId() throws SQLException {
        String sql = "SELECT MAX(id) + 1 as id FROM livro;";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return 1;
    }
}