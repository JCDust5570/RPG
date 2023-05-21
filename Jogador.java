import java.util.Scanner;
import java.util.Random;

public class Jogador extends Status {

    public String Nome() {
        
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem: ");
        nome = input.nextLine();
        return nome;
    }

    public void iniciar(String nome){
        Initialize(nome, 20, 10, 1, 10, 5, 10, 0);
        System.out.println("\t\tJogador criado com sucesso!\n\n");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: [" + vida + "/" + vidaMax + "]");
        System.out.println("Mana: [" + mana + "/" + manaMax + "]");
        System.out.println("Ataque: " + ataque + "d" + dadoAtaque);
        System.out.println("Força: " + forca);
        System.out.println("Defesa: " + defesa);
        System.out.println("Moedas: " + moedas);
    }

    public void Ataque(Slime slime){
        Random rand = new Random();
        int dano = 0;
        for(int i = 0; i < this.ataque; i++){
            dano += rand.nextInt(this.dadoAtaque);
        }
        if(dano > slime.defesa){
            dano += this.forca;
            slime.vida -= dano - slime.defesa;
            System.out.println("Você causou " + (dano - slime.defesa) + " de dano!");
            if(slime.estaVivo()){
                System.out.println("O slime tem " + slime.vida + " de vida!");
            }else{
                System.out.println("O slime morreu!");
                slime.vivo = false;
            }
        }else{
            System.out.println("Você não causou dano!");
        }
    }
    
}


