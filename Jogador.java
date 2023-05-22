import java.util.Scanner;
import java.util.Random;

public class Jogador extends Status {

    public Status status;

    private Jogador(Status status) {
        this.status = status;
    }
    
    public static String Nome() {
        
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem: ");
        nome = input.nextLine();
        return nome;
    }

    public static Jogador createJogador() {
        String nome = Nome();
        Status jogadorStatus = Status.createStatus(nome, 10, 0, 1, 5, 0, 0, 1, 1);
        Jogador jogador = new Jogador(jogadorStatus);
        return jogador;
    }

    public static void statusDoJogador(Jogador jogador){
        System.out.println("Vida: ["+ jogador.status.vida +"/"+ jogador.status.vidaMax +"]");
        System.out.println("Mana: ["+ jogador.status.mana +"/"+ jogador.status.manaMax +"]");
        System.out.println("Moedas: "+ jogador.status.moedas);
        System.out.println("Nível: "+ jogador.status.nivel);
        System.out.println("Experiência: "+ jogador.status.exp +"/"+ jogador.status.proxnivel);
        System.out.println("Ataque: "+ jogador.status.Ndados +"d"+ jogador.status.dadoAtaque);
    }

    public void atacar(Monstro monstro) {
        Random random = new Random();
        int dano = 0;
        // Calculo o dano baseado em dado de lados iguais ao atributo dadoAtaque
        for(int i = 0; i < this.status.Ndados; i++){
            dano += random.nextInt(this.status.dadoAtaque);
        }
        if(dano > monstro.status.defesa){
            monstro.status.vida -= dano;
            System.out.println("Você atacou o monstro e causou " + dano + " de dano!");
            if(monstro.status.vida <= 0){
                System.out.println("Você matou o monstro!");
                monstro.status.vivo = false;
            }
        }else{
            System.out.println("Você atacou o monstro, mas não acertou!");
        }
        
    }
}


