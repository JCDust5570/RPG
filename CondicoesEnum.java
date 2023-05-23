public enum CondicoesEnum {
    
    NORMAL(0),
    FRAQUEZA(1),
    DORMINDO(2),
    ENVENENADO(3),
    PARALISADO(4),
    ALQUEBRADO(5);

    private int valor;

    CondicoesEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static CondicoesEnum getCondicao(int valor) {
        switch (valor) {
            case 0:
                return NORMAL;
            case 1:
                return FRAQUEZA;
            case 2:
                return DORMINDO;
            case 3:
                return ENVENENADO;
            case 4:
                return PARALISADO;
            case 5:
                return ALQUEBRADO;
            default:
                return NORMAL;
        }
    }


    public static void Efeitos(CondicoesEnum condicao, Status Criatura) {
        switch (condicao) {
            case NORMAL:
                Criatura.condicao = NORMAL;
                break;
            case FRAQUEZA:
                Criatura.condicao = FRAQUEZA;
                Criatura.defesa = Criatura.defesa / 2;
                Criatura.dadoAtaque = Criatura.dadoAtaque / 2;
                Criatura.timer += 1;
                break;
            case DORMINDO:
                Criatura.condicao = DORMINDO;
                Criatura.timer += 1;
                break;
            case ENVENENADO:
                Criatura.condicao = ENVENENADO;
                Criatura.vida -= Criatura.vidaMax / 10;
                break;
            case PARALISADO:
                Criatura.condicao = PARALISADO;
                Criatura.iniciativa -= Criatura.iniciativa / 2;
                Criatura.timer += 1;
                break;
            case ALQUEBRADO:
                Criatura.condicao = ALQUEBRADO;
                Criatura.mana -= 1;
                Criatura.timer += 1;
                break;
            default:
                Criatura.condicao = NORMAL;
                break;
            
        }

        if (Criatura.timer == 3 && Criatura.condicao != ENVENENADO && Criatura.condicao != DORMINDO) {
            Criatura.condicao = NORMAL;
            Criatura.timer = 0;
        }else if(Criatura.timer == 3 || Criatura.condicao == DORMINDO){
            if(Criatura.timer != 3){
                int random = (int) (Math.random() * 10);
                if(random > 5){
                    Criatura.condicao = NORMAL;
                    Criatura.timer = 0;
                }
            }else{
                Criatura.condicao = NORMAL;
                Criatura.timer = 0;
            }
        }
    }
}
