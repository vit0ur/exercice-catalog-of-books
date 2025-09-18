package catalogo.repositories;

import catalogo.domain.Livro;
import java.sql.SQLException;
import java.util.List;

public interface LivroRepository {
    public void salvar(Livro livro) throws SQLException ;
    public Livro buscarPorId(int id) throws SQLException;
    public List<Livro> listarTodos() throws SQLException;
    public int MaxId() throws SQLException;
    public void criarTabela() throws SQLException;
}
