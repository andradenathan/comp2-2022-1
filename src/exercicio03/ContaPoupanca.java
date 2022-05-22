/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio03;

public class ContaPoupanca extends ContaCorrente {
    public ContaPoupanca(int numero, int matriculaCliente) {
        super(numero, matriculaCliente);
    }

    public void render(double juros) {
        this.saldo *= juros;
    }
}
