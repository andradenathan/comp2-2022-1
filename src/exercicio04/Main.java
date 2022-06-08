/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 **/

package exercicio04;

import exercicio04.br.com.bancoomicron.carteiras.CarteiraContas;
import exercicio04.br.com.bancoomicron.contas.ContaCorrente;
import exercicio04.br.com.bancoomicron.pessoas.Auditor;
import exercicio04.br.com.bancoomicron.pessoas.Cliente;

public class Main {
    public static void main(String[] args) {
        CarteiraContas carteira = new CarteiraContas(); 
        Cliente cliente = new Cliente("123.456.789-01", "NATHAN ANDRADE");

        ContaCorrente contaCorrente = new ContaCorrente(
            123, 
            cliente.getMatricula()
        );

        carteira.adicionarConta(contaCorrente);

        Auditor auditor = new Auditor("987.654.321-01", "JOAO PEDRO");
        
        System.out.println(auditor.auditar(carteira));

        contaCorrente.depositar(23000);

    }
}