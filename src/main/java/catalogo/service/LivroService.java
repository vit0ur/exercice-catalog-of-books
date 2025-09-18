package catalogo.service;

import catalogo.domain.Livro;
import catalogo.persistence.LivroDAO;
import catalogo.repositories.LivroRepository;

import java.sql.SQLException;
import java.util.List;

public class LivroService {
    private final LivroRepository repository;

    public LivroService() throws Exception {
        this.repository = new LivroDAO();
    }

    public void criarTabela() throws SQLException {
        try {
            repository.criarTabela();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarLivro(Livro livro) {
        try {
            repository.salvar(livro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro buscarPorId(int id) {
        try {
            return repository.buscarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listarTodos() {
        try {
            return repository.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int MaxId() throws SQLException  {
        try {
            return repository.MaxId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}