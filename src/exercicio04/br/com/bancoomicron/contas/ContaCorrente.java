/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.contas;

public class ContaCorrente implements IConta {
    protected int matriculaCliente;
    protected int numero;
    protected int saldo;

    ContaCorrente(int numero, int matriculaCliente) {
        this.matriculaCliente = matriculaCliente;
        this.numero = numero;
        this.saldo = 0;
    }

    public boolean sacar(double valor) {
        if(valor >= this.saldo) return false;
         
        this.saldo -= valor;
        return true;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }
    
    @Override
    public int getNumero() {
        return this.numero;
    }
    
    @Override
    public double getSaldo() {
        return this.saldo;
    }
}
