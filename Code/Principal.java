public class Principal{
    public static void main(String[] args) {
        System.out.println("Olá mundo!");
        Login login = new Login("teste@teste.com", "");

        System.out.println(login.getEmail());
    }
}