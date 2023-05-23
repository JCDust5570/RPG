

class Main extends Menu{

    public static void main(String[] args) {

        Jogador jogador = Jogador.createJogador();
        System.out.println(jogador.status.nome);
        
        while(jogador.status.vivo){
            Monstro monstro = createMonstro(jogador);
            System.out.println("Você encontrou um " + monstro.status.nome + "!");
            System.out.println("Prepare-se para a batalha!\n");
            while(monstro.status.vivo || jogador.status.vivo){
                Menu(jogador, monstro);
                if(jogador.status.vivo == false || monstro.status.vivo == false){
                    break;
                }
                monstro.statusDoMonstro(monstro);
                jogador.statusDoJogador(jogador);
                System.out.print("\n");

            }
            if(jogador.status.vivo == false){
                System.out.println("Fim de jogo!");
                break;
            }else{
                System.out.println("Parabéns você derrotou o monstro!");
                System.out.println("Você ganhou " + monstro.status.exp + " de experiência!");
                jogador.status.exp += monstro.status.exp;
                System.out.println("Você também ganhou " + monstro.status.moedas + " moedas!\n");
                jogador.status.moedas += monstro.status.moedas;
                jogador.evoluir(jogador);
            }
        }
    }
}
