/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio03;

public class Cliente extends Pessoa {
    
    private CarteiraContas contas;
    private int matricula;
    private static int geradorMatricula = 0;

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
    }

    public int geraMatricula() {
        return ++geradorMatricula;
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
