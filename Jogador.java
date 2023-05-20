import java.util.Scanner;

public class Jogador extends Status {

    public String Nome() {
        
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem: ");
        nome = input.nextLine();
        return nome;
    }

    public void iniciar(String nome){
        Initialize(nome, 20, 10, 10, 10, 0);
        System.out.println("\t\tJogador criado com sucesso!\n\n");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: [" + vida + "/" + vidaMax + "]");
        System.out.println("Mana: [" + mana + "/" + manaMax + "]");
        System.out.println("Força: " + forca);
        System.out.println("Defesa: " + defesa);
        System.out.println("Moedas: " + moedas);
    }

    

    
}
