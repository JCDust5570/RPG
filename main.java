import java.util.Random;
import java.util.Scanner;

class Main{
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

    private static void Menu(Jogador jogador, Monstro monstro){
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Atacar");
        System.out.println("2 - Curar");
        System.out.println("3 - Status");
        Scanner input = new Scanner(System.in);
        int escolha = input.nextInt();
        switch(escolha){
            case 1:
                break;
            case 2:
                if(jogador.status.mana > 3){
                    jogador.curar(jogador);
                }else{
                    System.out.println("Você não tem mana suficiente!");
                }
                break;
            case 3:
                Jogador.statusDoJogador(jogador);
                System.out.print("\n");
                Monstro.statusDoMonstro(monstro);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static Monstro createMonstro(Jogador jogador){
        //Criar monstros de forma aleatoria baseado no nível do jogador
        Random random = new Random();
        int nivel = jogador.status.nivel;
        int monstroAleatorio = random.nextInt(5);
        while (nivel == 0 || monstroAleatorio > nivel){
            monstroAleatorio = random.nextInt(5);
        }

        switch(monstroAleatorio){
            case 1:
                Monstro monstro1 = Monstro.createSlime();
                return monstro1;
            case 2:
                Monstro monstro2 = Monstro.createGoblin();
                return monstro2;
            case 3:
                Monstro monstro4 = Monstro.createOsteon();
                return monstro4;
            default:
                Monstro monstro3 = Monstro.createSlime();
                return monstro3;
        }
    }


}
