import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface CRUD {
    public void cadastrar(Scanner scanner, UsuarioModel usuario);
    public void editar(Scanner scanner, UsuarioModel usuario);
    public void listar(ResultSet rs) throws SQLException;
    public void remover(Scanner scanner, UsuarioModel usuario);
}
