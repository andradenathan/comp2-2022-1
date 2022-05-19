/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio02;

public class Auditor extends Pessoa {
    Auditor(String cpf, String nome) {
        super(cpf, nome);
    }
    
    public Boolean auditar(IAuditoria auditoria) {
        double mediaSaldo = auditoria.somaSaldo()/auditoria.quantidadeContas();
        return mediaSaldo >= 1000 ? true : false;
    }
}
