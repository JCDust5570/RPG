import java.util.Scanner;

public class Terminal{
    public static void limparTerminal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione qualquer tecla para limpar o terminal...");
        scanner.nextLine(); // Aguarda o usuário pressionar uma tecla
        
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
