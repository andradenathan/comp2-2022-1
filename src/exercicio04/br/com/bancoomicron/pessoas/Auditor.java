/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.pessoas;

import exercicio04.br.com.bancoomicron.carteiras.IAuditoria;

public class Auditor extends Pessoa {
    public Auditor(String cpf, String nome) {
        super(cpf, nome);
    }
    
    public Boolean auditar(IAuditoria auditoria) {
        return (auditoria.somaSaldo()/auditoria.quantidadeContas()) >= 1000;
    }
}
