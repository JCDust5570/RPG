

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
    boolean vivo = true;
    boolean critico = false;
    String condicao = "Normal";
    
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
        this.vivo = true;
        this.critico = false;
        this.condicao = "Normal";
    }

    public boolean estaVivo(){
        if(this.vida <= 0){
            this.vivo = false;
        }
        return this.vivo;
    }
        

    public void meuStatus(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: [" + this.vida + "/" + this.vidaMax + "]");
        System.out.println("Mana: [" + this.mana + "/" + this.manaMax + "]");
        System.out.println("Ataque: " + this.ataque + "d" + this.dadoAtaque);
        System.out.println("Força: " + this.forca);
        System.out.println("Defesa: " + this.defesa);
        System.out.println("Moedas: " + this.moedas);
    }
        

}    

