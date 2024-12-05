import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface CRUD {
    public void cadastrar(Scanner scanner);
    public void editar(Scanner scanner);
    public void listar(ResultSet rs) throws SQLException;
    public void remover(Scanner scanner);
}
