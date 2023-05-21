import java.util.Scanner;
import java.util.Random;

public class Jogador extends Status {

    public Status status;

    private Jogador(Status status) {
        this.status = status;
    }
    
    public String Nome() {
        
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem: ");
        nome = input.nextLine();
        return nome;
    }


    
}


