package exercicio02;

public class ContaEspecial extends ContaCorrente {
    private double chequeEspecial;
    private final double taxaIof = 100;

    public ContaEspecial(int numero, int matriculaCliente) {
        super(numero, matriculaCliente);
    }
    
    public boolean sacar(double valor) {
        double limiteCheque = this.chequeEspecial + (0.03 * taxaIof);
        
        if(valor <= this.saldo) {
            super.sacar(valor);
            return true;
        }

        if(valor <= limiteCheque) {
            this.saldo -= valor - this.saldo;
            if(this.saldo < 0) {
                this.saldo += limiteCheque;
                return false;
            }
            return true;
        }
        
        return false;
    }
}
