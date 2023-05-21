import java.util.Random;

public class Slime extends Status {
    
    public void Iniciar(){
        String nome = "Slime";
        int vida = 10;
        int mana = 0;
        int ataque = 1;
        int dadoAtaque = 4;
        int forca = 1;
        int defesa = 1;
        int moedas = 1;
        Initialize(nome, vida, mana, ataque, dadoAtaque, forca, defesa, moedas);
    }

    public void ataque(Jogador player){
        Random rand = new Random();
        int dano = 0;
        for(int i = 0; i < this.ataque; i++){
            dano += rand.nextInt(this.dadoAtaque);
        }
        if(dano > player.defesa){
            dano += this.forca;
            player.vida -= dano - player.defesa;
            System.out.println("Você recebeu " + (dano - player.defesa) + " de dano!");
            if(player.estaVivo()){
                System.out.println("Você tem " + player.vida + " de vida!");
            }else{
                System.out.println("Você morreu!");
                player.vivo = false;
            }
        }else{
            System.out.println("Você não recebeu dano!");
        }
    }
    
}
