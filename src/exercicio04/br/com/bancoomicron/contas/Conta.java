/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.contas;

public abstract class Conta implements IConta {
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

    public int getMatriculaCliente() {
        return this.matriculaCliente;
    }
}
