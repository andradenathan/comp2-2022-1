/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.contas;

public class ContaEspecial implements IConta {
    protected int matriculaCliente;
    protected int numero;
    private int saldo;

    private double chequeEspecial;
    private final double taxaIof = 100;

    public ContaEspecial(int numero, int matriculaCliente) {
        
    }
    
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        double limiteCheque = this.chequeEspecial + (0.03 * taxaIof);
        
        if(valor <= this.saldo) {
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
    
    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
