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
        Status jogadorStatus = Status.createStatus(nome, 15, 20, 1, 10, 0, 0, 1, 1);
        Jogador jogador = new Jogador(jogadorStatus);
        jogador.status.regeneraracaoMana = 1;
        jogador.status.regeneraracaoVida = 5;
        jogador.status.iniciativa = 5;
        jogador.status.player = true;
        return jogador;
    }

    public static void statusDoJogador(Jogador jogador){
        System.out.println("\n============"+ jogador.status.nome +"============");
        System.out.println("Vida: ["+ jogador.status.vida +"/"+ jogador.status.vidaMax +"]");
        System.out.println("Mana: ["+ jogador.status.mana +"/"+ jogador.status.manaMax +"]");
        System.out.println("Moedas: "+ jogador.status.moedas);
        System.out.println("Nível: "+ jogador.status.nivel);
        System.out.println("Experiência: "+ jogador.status.exp +"/"+ jogador.status.proxnivel);
        System.out.println("Ataque: "+ jogador.status.Ndados +"d"+ jogador.status.dadoAtaque);
        System.out.println("Defesa: "+ jogador.status.defesa);
        System.out.println("Condicao: "+ jogador.status.condicao);
        System.out.println("Inicioativa: "+ jogador.status.iniciativa);
        System.out.println("====================================\n");
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

        regenerarMana(this);
        
    }

    public void evoluir(Jogador jogador){
        if(jogador.status.exp >= jogador.status.proxnivel){
            jogador.status.nivel += 1;
            jogador.status.proxnivel += 10;
            jogador.status.vidaMax += 5;
            jogador.status.vida += 5;
            jogador.status.manaMax += 5;
            jogador.status.mana += 5;
            jogador.status.dadoAtaque += 4;
            jogador.status.defesa += 2;
            jogador.status.exp = 0;
            if (jogador.status.nivel % 2 != 0){
                jogador.status.Ndados += 1;
                jogador.status.iniciativa += 2;
                jogador.status.regeneraracaoMana += 2;
                jogador.status.regeneraracaoVida += 2;
            }
            System.out.println("Você evoluiu para o nível " + jogador.status.nivel + "!");
            System.out.println("Seus status aumentaram!");
            statusDoJogador(jogador);
        }
    }

    public static void curar(Jogador jogador){
        if(jogador.status.mana > 3){
            jogador.status.mana -= 4;
            jogador.status.vida += 5;
            if(jogador.status.vida > jogador.status.vidaMax){
                jogador.status.vida = jogador.status.vidaMax;
            }
            System.out.println("Você gatou 4 de mana e curou em 5 pontos da sua vida!");
        }else{
            System.out.println("Você não tem mana suficiente!");
        }
       
    }

    public void regenerarMana(Jogador jogador){
        jogador.status.mana += jogador.status.regeneraracaoMana;
        if(jogador.status.mana > jogador.status.manaMax){
            jogador.status.mana = jogador.status.manaMax;
        }
    }

    public void regenerarVida(Jogador jogador){
        jogador.status.vida += jogador.status.regeneraracaoVida;
        if(jogador.status.vida > jogador.status.vidaMax){
            jogador.status.vida = jogador.status.vidaMax;
        }
    }
}


