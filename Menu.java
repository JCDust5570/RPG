import java.util.Random;
import java.util.Scanner;

public class Menu {
    
    public static void Menu(Jogador jogador, Monstro monstro){
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Atacar");
        System.out.println("2 - Curar");
        System.out.println("3 - Status");
        Scanner input = new Scanner(System.in);
        int escolha = input.nextInt();
        switch(escolha){
            case 1:
                combate(jogador, monstro);
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


        CondicoesEnum.Efeitos(jogador.status.condicao, jogador.status);
        CondicoesEnum.Efeitos(monstro.status.condicao, monstro.status);
    }

    public static Monstro createMonstro(Jogador jogador){
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

    public static void combate(Jogador jogador, Monstro monstro) {

        if(jogador.status.iniciativa > monstro.status.iniciativa){
            jogador.atacar(monstro);
            if(monstro.status.vivo == false){
                return;
            }
            monstro.atacar(jogador, monstro);
        }else{
            monstro.atacar(jogador, monstro);
            if(jogador.status.vivo == false){
                return;
            }
            jogador.atacar(monstro);
        }

    }

}
