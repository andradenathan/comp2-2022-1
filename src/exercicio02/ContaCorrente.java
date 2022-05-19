package exercicio02;

public class ContaCorrente extends Conta {
    ContaCorrente(int numero, int matriculaCliente) {
        super(numero, matriculaCliente);
    }

    public boolean sacar(double valor) {
        if(valor >= this.saldo) return false;
         
        this.saldo -= valor;
        return true;
    }
}
