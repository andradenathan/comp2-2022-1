/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.pessoas;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;

    public Pessoa(String cpf, String nome) {}

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }
}
