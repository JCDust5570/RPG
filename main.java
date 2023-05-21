import java.util.Scanner;

interface I_Jogador{
    public String Nome();
    public void iniciar(String nome);
    public Integer AtaqueFurtivo(int defesaInimigo);
    public Integer Ataque(int defesaInimigo);
}

class main{
    public static void main(String[] args) {    
        Jogador player = new Jogador();
        String nome = player.Nome();
        player.iniciar(nome);

        boolean sair = false;
        while(player.estaVivo()){
            Slime slime = new Slime();
            slime.Iniciar();            
            while(slime.estaVivo() && player.estaVivo()){
                System.out.println("Você encontrou um slime!");
                menu(player, slime, sair);
                if(player.vida <= 0){
                    System.out.println("Você morreu!");
                    sair = true;
                }else{
                    System.out.println("Você derrotou o slime!");
                    System.out.println("Você ganhou " + slime.moedas + " moedas!");
                    player.moedas += slime.moedas;
                    System.out.println("Você tem " + player.moedas + " moedas!");
                }
            }
            System.out.println("Você morreu! ;-;");
            System.out.println("Obrigado por jogar! <3 \\(^o^)/");
        }
    }

    private static void menu(Jogador player, Slime slime, boolean sair){
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 3){
            System.out.println("1 - Atacar");
            System.out.println("2 - Status");
            System.out.println("3 - Sair");
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    player.Ataque(slime);
                    slime.ataque(player);
                    break;
                case 2:
                    System.out.println("Jogador:");
                    player.meuStatus();
                    System.out.println("");
                    System.out.println("Slime:");
                    slime.meuStatus();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}
