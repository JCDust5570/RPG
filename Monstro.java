import java.util.Random;

public class Monstro {
    public Status status;

    private Monstro(Status status) {
        this.status = status;
    }



    public static Monstro createSlime() {
        int moedas = new Random().nextInt(6);
        Status slimeStatus = Status.createStatus("Slime", 6, 0, 1, 5, 0, moedas, 1, 1);
        Monstro slimeMonstro = new Monstro(slimeStatus);
        return slimeMonstro;
    }

    public static Monstro createGoblin(){
        int moedas = new Random().nextInt(6);
        Status goblinStatus = Status.createStatus("Goblin", 15, 0, 1, 7, 4, moedas, 2, 4);
        Monstro goblinMonstro = new Monstro(goblinStatus);
        return goblinMonstro;
    }

    public void atacar(Jogador jogador){
        Random random = new Random();
        int dano = 0;
        // Calculo o dano baseado em dado de lados iguais ao atributo dadoAtaque
        for(int i = 0; i < this.status.Ndados; i++){
            dano += random.nextInt(this.status.dadoAtaque);
        }
        if(dano > jogador.status.defesa){
            jogador.status.vida -= dano;
            System.out.println("O monstro te atacou e causou " + dano + " de dano!");
            if(jogador.status.vida <= 0){
                System.out.println("Você morreu!");
                jogador.status.vivo = false;
            }
        }else{
            System.out.println("O "+ this.status.nome +"te atacou, mas não acertou!");
        }
    }

    public void statusDoMonstro(Monstro monstro){
        System.out.println("\n============"+ monstro.status.nome +"============");
        System.out.println("Vida: ["+ monstro.status.vida +"/"+ monstro.status.vidaMax +"]");
        System.out.println("Ataque: "+ monstro.status.Ndados +"d"+ monstro.status.dadoAtaque);
        System.out.println("Defesa: "+ monstro.status.defesa);
        System.out.println("====================================\n");
    }

    

}

