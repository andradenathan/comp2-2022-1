/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio03;

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
