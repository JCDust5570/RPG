import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ContaPoupanca cp = new ContaPoupanca(100);
        ContaCorrente cc = new ContaCorrente(300);

        cp.view();
        cc.view();
    }
}
