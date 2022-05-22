/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio03;

public abstract class Conta {
    protected double saldo;
    protected int numero;
    protected int matriculaCliente;

    public Conta(int numero, int matriculaCliente) {
        this.numero = numero;
        this.matriculaCliente = matriculaCliente;
        this.saldo = 0;
    }
    
    abstract public boolean sacar(double valor);

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo;
    }
    
    public int getNumero() {
        return this.numero;
    }
}
