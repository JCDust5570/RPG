public class Conta {

    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }
    
    public void view() {
        System.out.println("Saldo: " + this.saldo);
    }

}
