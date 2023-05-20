import java.util.Scanner;
import java.util.Random;

public class Jogador extends Status {

    public String Nome() {
        
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem: ");
        nome = input.nextLine();
        return nome;
    }

    public void iniciar(String nome){
        Initialize(nome, 20, 10, 1, 10, 5, 10, 0);
        System.out.println("\t\tJogador criado com sucesso!\n\n");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: [" + vida + "/" + vidaMax + "]");
        System.out.println("Mana: [" + mana + "/" + manaMax + "]");
        System.out.println("Ataque: " + ataque + "d" + dadoAtaque);
        System.out.println("Força: " + forca);
        System.out.println("Defesa: " + defesa);
        System.out.println("Moedas: " + moedas);
    }

    public Integer AtaqueFurtivo(int defesaInimigo){
        // Ataque Furtivo tem chance de crítico
        int ataqueFurtivo = 0;
        this.mana -= 2;
        ataqueFurtivo = this.forca;
        Random random = new Random();
        int golpe = random.nextInt(this.dadoAtaque);
        // Chance de Acerto (+ dano)
        if(golpe <= defesaInimigo){
            ataqueFurtivo = 0;
        }else{
            ataqueFurtivo += golpe;
        }
        // Chance de Crítico
        int critico = random.nextInt(10);
        if(critico >= 2){
            this.critico = true;
            ataqueFurtivo *= 2;
        }

        return ataqueFurtivo;
    }

    public Integer Ataque(int defesaInimigo){
        // Ataque normal (n gasta mana)
        int golpe = 0;
        Random random = new Random();
        golpe = random.nextInt(this.dadoAtaque);
        if(golpe <= defesaInimigo){
            golpe = 0;
        }else{
            golpe += this.forca;
        }
        return golpe;
    }

    public Integer AtaquePoderoso(int defesaInimigo){
        // Ataque Poderoso diminui a defesa do inimigo
        int ataquePoderoso = 0;
        this.mana -= 5;
        ataquePoderoso = this.forca;
        Random random = new Random();
        int golpe = random.nextInt(this.dadoAtaque);
        // Chance de Acerto (+ dano)
        if(golpe < defesaInimigo){
            ataquePoderoso = 0;
        }else{
            ataquePoderoso += golpe;
            defesaInimigo -= 2;
        }
        return ataquePoderoso;
    }

    
}


