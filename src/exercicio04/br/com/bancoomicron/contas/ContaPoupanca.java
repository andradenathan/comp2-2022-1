/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.contas;

public class ContaPoupanca extends ContaCorrente {
    public ContaPoupanca(int numero, int matriculaCliente) {
        super(numero, matriculaCliente);
    }

    public void render(double juros) {
        this.saldo *= juros;
    }
}
