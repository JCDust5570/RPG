import java.util.Scanner;

class Main{
    public static void main(String[] args) {

        Jogador jogador = Jogador.createJogador();
        System.out.println(jogador.status.nome);
        
        while(jogador.status.vivo){
            Monstro monstro = Monstro.createSlime();
            System.out.println(monstro.status.nome);
            while(monstro.status.vivo){
                Menu(jogador, monstro);
            }
            if(jogador.status.vivo == false){
                break;
            }else{
                System.out.println("Parabéns você derrotou o monstro!");
                System.out.println("Você ganhou " + monstro.status.exp + " de experiência!");
                jogador.status.exp += monstro.status.exp;
                System.out.println("Você também ganhou " + monstro.status.moedas + " moedas!");
                jogador.status.moedas += monstro.status.moedas;
            }

        }
    }

    private static void Menu(Jogador jogador, Monstro monstro){
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Atacar");
        System.out.println("2 - Fugir");
        System.out.println("3 - Status");
        Scanner input = new Scanner(System.in);
        int escolha = input.nextInt();
        switch(escolha){
            case 1:
                jogador.atacar(monstro);
                if(monstro.status.vivo){
                    monstro.atacar(jogador);
                }
                break;
            case 2:
                System.out.println("Você fugiu do monstro!");
                monstro.status.vivo = false;
                break;
            case 3:
                Jogador.statusDoJogador(jogador);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }


}
