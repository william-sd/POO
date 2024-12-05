import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioView implements  CRUD {
    public UsuarioModel usuario;

    @Override
    public void cadastrar(Scanner scanner, UsuarioModel usuario) {
        System.out.print("Nome: ");
        usuario.setNome(scanner.nextLine());
        System.out.print("Email: ");
        usuario.setEmail(scanner.nextLine());
    }

    @Override
    public void editar(Scanner scanner, UsuarioModel usuario) {
        System.out.print("ID do usuário a ser editado: ");
        usuario.setId(scanner.nextInt());
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Novo Nome: ");
        usuario.setNome(scanner.nextLine());
        System.out.print("Novo Email: ");
        usuario.setEmail(scanner.nextLine());
    }

    @Override
    public void listar(ResultSet rs ) throws SQLException {
        System.out.println("\n--- Lista de Usuários ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("--------------------------");
        }
    }

    @Override
    public void remover(Scanner scanner, UsuarioModel usuario) {
        System.out.print("ID do usuário a ser removido: ");
        usuario.setId(scanner.nextInt());
    }
    
}
