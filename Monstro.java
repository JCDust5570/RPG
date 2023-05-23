import java.util.Random;

public class Monstro {
    public Status status;

    private Monstro(Status status) {
        this.status = status;
    }



    public static Monstro createSlime() {
        int moedas = new Random().nextInt(6);
        Status slimeStatus = Status.createStatus("Slime", 6, 0, 1, 5, 0, moedas, 1, 1);
        slimeStatus.regeneraracaoVida = 1;
        Monstro slimeMonstro = new Monstro(slimeStatus);
        return slimeMonstro;
    }

    public static Monstro createGoblin(){
        int moedas = new Random().nextInt(6);
        Status goblinStatus = Status.createStatus("Goblin", 15, 0, 1, 6, 5, moedas, 2, 4);
        Monstro goblinMonstro = new Monstro(goblinStatus);
        return goblinMonstro;
    }

    public static Monstro createOsteon(){
        int moedas = new Random().nextInt(2);
        Status osteonStatus = Status.createStatus("Osteon", 22, 15, 1, 7, 4, moedas, 3, 6);
        osteonStatus.regeneraracaoVida = 2;
        osteonStatus.regeneraracaoMana = 1;
        Monstro osteonMonstro = new Monstro(osteonStatus);
        return osteonMonstro;
    }

    public void atacar(Jogador jogador, Monstro monstro){
        Random random = new Random();
        int dano = 0;
        // Calculo o dano baseado em dado de lados iguais ao atributo dadoAtaque
        for(int i = 0; i < monstro.status.Ndados; i++){
            dano += random.nextInt(monstro.status.dadoAtaque);
        }
        if(dano > jogador.status.defesa){
            jogador.status.vida -= dano;
            System.out.println("O monstro te atacou e causou " + dano + " de dano!");
            if(jogador.status.vida <= 0){
                System.out.println("Você morreu!");
                jogador.status.vivo = false;
            }
        }else{
            System.out.println("O "+ monstro.status.nome +"te atacou, mas não acertou!");
        }
        
        if(monstro.status.regeneraracaoVida > 0){
            monstro.regenerarVida(monstro);
        }
        
        if(monstro.status.regeneraracaoMana > 0){
            monstro.regenerarMana(monstro);
        }

    }

    public static void statusDoMonstro(Monstro monstro){
        System.out.println("\n============"+ monstro.status.nome +"============");
        System.out.println("Vida: ["+ monstro.status.vida +"/"+ monstro.status.vidaMax +"]");
        System.out.println("Ataque: "+ monstro.status.Ndados +"d"+ monstro.status.dadoAtaque);
        System.out.println("Defesa: "+ monstro.status.defesa);
        System.out.println("====================================\n");
    }

    public void regenerarVida(Monstro monstro){
        monstro.status.vida += monstro.status.regeneraracaoVida;
        if(monstro.status.vida > monstro.status.vidaMax){
            monstro.status.vida = monstro.status.vidaMax;
        }

    }
    
    public void regenerarMana(Monstro monstro){
        monstro.status.mana += monstro.status.regeneraracaoMana;
        if(monstro.status.mana > monstro.status.manaMax){
            monstro.status.mana = monstro.status.manaMax;
        }
    }


    public void raioSombrio(Jogador jogador, Monstro monstro){
        Random random = new Random(10);
        monstro.status.mana -= 5;
        jogador.status.vida -= 4;

        if(random.nextInt(10) > 7){
            jogador.status.condicao = CondicoesEnum.FRAQUEZA;
            System.out.println("O Raio Sombrio te deixou fraco!");
            System.out.println("Sua defesa e seu ataque foram reduzidos pela metade!");
        }
    }
    
    public void toqueVampirico(Jogador jogador, Monstro monstro) {
        monstro.status.mana -= 5;
        Random random = new Random();
        int dano = 0;
        // Calculo o dano baseado em dado de lados iguais ao atributo dadoAtaque
        for(int i = 0; i < monstro.status.Ndados; i++){
            dano += random.nextInt(monstro.status.dadoAtaque);
        }
        if(dano > jogador.status.defesa){
            jogador.status.vida -= dano;
            monstro.status.vida += dano + monstro.status.regeneraracaoVida;
            System.out.println("O monstro te atacou e causou " + dano + " de dano!");
            System.out.println("O monstro se curou em " + (dano + monstro.status.regeneraracaoVida) + " de vida!");
            if(jogador.status.vida <= 0){
                System.out.println("Você morreu!");
                jogador.status.vivo = false;
            }
        }else{
            System.out.println("O "+ monstro.status.nome +"te atacou, mas não acertou!");
        }    
    }

    public void osteonAtaque(Monstro monstro, Jogador jogador){
        if(monstro.status.mana > 5){
            if(monstro.status.vida > 15){
                raioSombrio(jogador, monstro);
            }
            else{
                toqueVampirico(jogador, monstro);
            }
        }else{
            atacar(jogador, monstro);
        }


    }
}

