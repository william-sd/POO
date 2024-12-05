import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioView view = new UsuarioView();

    public void cadastrar(Scanner scanner) {
        view.cadastrar(scanner);

        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";

        try (Connection conn = Conector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, view.usuario.getNome());
            stmt.setString(2, view.usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    public void listar(){
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                view.listar(rs);
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    public void editar(Scanner scanner){
        view.editar(scanner);

        String sql = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, view.usuario.getNome());
            stmt.setString(2, view.usuario.getEmail());
            stmt.setInt(3, view.usuario.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar usuário: " + e.getMessage());
        }
    }

    public void remover(Scanner scanner){
        view.remover(scanner);

        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = Conector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, view.usuario.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
    }

}
