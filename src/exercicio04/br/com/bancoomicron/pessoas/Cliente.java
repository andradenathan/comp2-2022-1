/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.pessoas;

import exercicio04.br.com.bancoomicron.carteiras.CarteiraContas;
import exercicio04.br.com.bancoomicron.contas.Conta;

public class Cliente extends Pessoa {
    
    private CarteiraContas contas;
    private int matricula;
    private static int geradorMatricula = 1;

    Cliente(
        String cpf, 
        String nome
    ) 
    {
        super(cpf, nome);
    }
    
    Cliente(
        String cpf, 
        String nome,
        Conta conta
    ) 
    {
        super(cpf, nome);
        this.contas = new CarteiraContas();
        this.contas.adicionarConta(conta);
        this.matricula = Cliente.geraMatricula();
    }

    public static int geraMatricula() {
        int matricula = Cliente.geradorMatricula;
        Cliente.geradorMatricula += 1;
        return matricula;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public double somaSaldo() {
        return this.contas.somaSaldo();
    }

    public int numContas() {
        return this.contas.quantidadeContas();  
    }

    public void adicionarConta(Conta c) {
        this.contas.adicionarConta(c);
    }

    public void removerConta(int numeroConta) {
        this.contas.removerConta(numeroConta);
    }
}
