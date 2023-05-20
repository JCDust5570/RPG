

public class Status {
    
    String nome;
    int vida;
    int vidaMax;
    int mana;
    int manaMax;
    int ataque;
    int dadoAtaque;
    int forca;
    int defesa;
    int moedas;
    
    public void Initialize(String nome, int vida, int mana, int ataque, int dadoAtaque, int forca, int defesa, int moedas) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vida;
        this.mana = mana;
        this.manaMax = mana;
        this.ataque = ataque;
        this.dadoAtaque = dadoAtaque;
        this.forca = forca;
        this.defesa = defesa;
        this.moedas = moedas;
    }
        
        

}    

