/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.carteiras;

import java.util.ArrayList;

import exercicio04.br.com.bancoomicron.contas.Conta;
import exercicio04.br.com.bancoomicron.pessoas.Cliente;

public class CarteiraContas implements IAuditoria {
    private ArrayList<Conta> contas;

    public CarteiraContas() {
        this.contas = new ArrayList<Conta>();
    }

    public int tamanho() {
        return this.contas.size();
    }

    public int quantidadeContas() {
        return this.contas.size();
    }

    public double somaSaldo() {
        double saldo = 0;
        for(int i = 0; i < this.contas.size(); i++) {
            Conta conta = this.contas.get(i);
            saldo += conta.getSaldo();
        }
        return saldo;
    }

    public void adicionarConta(Conta c) {
        this.contas.add(c); 
    }

    public CarteiraContas getContasByCliente(Cliente c) {
        CarteiraContas contasCliente = new CarteiraContas();
        for (Conta conta : contas) {
            if(c.getMatricula() == conta.getMatriculaCliente()) {
                contasCliente.adicionarConta(conta);
            } else {
                continue;
            }
        }
        return contasCliente;
    }

    public Boolean removerConta(int numero) {
        for(int i = 0; i < this.contas.size(); i++) {
            Conta conta = this.contas.get(i);
            if(conta.getNumero() == numero) {
                this.contas.remove(conta);
                return true;
            }
            continue;
        }
        return false;
    } 
}
