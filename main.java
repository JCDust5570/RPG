import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("Digite seu nome: ");
        Scanner nome_s = new Scanner(System.in);
        String nome = nome_s.nextLine();
        
        System.out.println("Digite sua idade: ");
        Scanner idade_s = new Scanner(System.in);
        Integer idade = idade_s.nextInt();
        
        System.out.println("Digite sua altura: ");
        Scanner altura_s = new Scanner(System.in);
        Double altura = altura_s.nextDouble();
        
        System.out.println("Digite seu peso: ");
        Scanner peso_s = new Scanner(System.in);
        Float peso = peso_s.nextFloat();

        System.out.println("Digite seu sexo: ");
        Scanner sexo_s = new Scanner(System.in);
        char sexo = sexo_s.next().charAt(0);

        System.out.println("Cliente: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Sexo: " + sexo);



    }
}
