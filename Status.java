
package RPG;

public class Status {
    
    String nome;
    int vida;
    int vidaMax;
    int mana;
    int manaMax;
    int forca;
    int defesa;
    int moedas;
    
    public void Initialize(String nome, int vida, int mana,int forca, int defesa, int moedas) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vida;
        this.mana = mana;
        this.manaMax = manaMax;
        this.forca = forca;
        this.defesa = defesa;
        this.moedas = moedas;
    }
        
        

}    

