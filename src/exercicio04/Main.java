/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 **/

package exercicio04;

import exercicio04.br.com.bancoomicron.carteiras.CarteiraContas;
import exercicio04.br.com.bancoomicron.contas.ContaCorrente;
import exercicio04.br.com.bancoomicron.pessoas.Cliente;

public class Main {
    public static void main(String[] args) {
        CarteiraContas carteira = new CarteiraContas(); 
        Cliente cliente = new Cliente("", "NATHAN ANDRADE");

        ContaCorrente corrente = new ContaCorrente(
            123, 
            cliente.getMatricula()
        );

        carteira.adicionarConta(corrente);
    }
}
