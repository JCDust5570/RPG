import java.util.Scanner;

public class caixa{
    public static void main(String[] args){
        System.out.println("Digite seu nome: ");
        Scanner nome_s = new Scanner(System.in);
        String nome = nome_s.nextLine();

        System.out.println("Digite valor de deposito: ");
        Scanner deposito_s = new Scanner(System.in);
        Double deposito = deposito_s.nextDouble();

        System.out.println("Digite valor de saque: ");
        Scanner saque_s = new Scanner(System.in);
        Double saque = saque_s.nextDouble();

        if (saque > deposito) {
            System.out.println("Valor de saque maior que o valor de deposito");
        } else {
            deposito -= saque;
            System.out.println("Saque de R$"+ saque +" realizado com sucesso");
        }

        System.out.println("Valor disponivel para saque: " + deposito);
    }

    Module saque = new Module(){
        public void saque(Double saque, Double deposito){
            if (saque > deposito) {
                System.out.println("Valor de saque maior que o valor de deposito");
            } else {
                deposito -= saque;
                System.out.println("Saque de R$"+ saque +" realizado com sucesso");
            }
        }
    }

    Module deposito = new Module(){
        public void deposito(Double deposito, Double saque){
            deposito += saque;
            System.out.println("Deposito de R$"+ deposito +" realizado com sucesso");
        }
    }
}