

public class Status {
    
    String nome;
    int vida;
    int vidaMax;
    int mana;
    int manaMax;
    int Ndados;
    int dadoAtaque;
    int defesa;
    int moedas;
    int nivel = 0;
    int exp = 0;
    int proxnivel = 10;
    boolean vivo = true;
    boolean critico = false;
    
    public static Status createStatus(String nome, int vida, int mana, int Ndado, int dadoAtaque, int defesa, int moedas, int nivel, int xp) {
        Status status = new Status();
        status.nome = nome;
        status.vida = vida;
        status.vidaMax = vida;
        status.mana = mana;
        status.manaMax = mana;
        status.Ndados = Ndado;
        status.dadoAtaque = dadoAtaque;
        status.defesa = defesa;
        status.moedas = moedas;
        status.nivel = nivel;
        status.exp = xp;
        status.vivo = true;
        status.critico = false;
        return status;
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }
        
        

}    

