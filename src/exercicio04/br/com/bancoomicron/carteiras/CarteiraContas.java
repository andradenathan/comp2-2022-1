/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.carteiras;

import java.util.ArrayList;

import exercicio04.br.com.bancoomicron.contas.IConta;
import exercicio04.br.com.bancoomicron.pessoas.Cliente;

public class CarteiraContas implements IAuditoria {
    private ArrayList<IConta> contas;

    public CarteiraContas() {
        this.contas = new ArrayList<IConta>();
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
            IConta conta = this.contas.get(i);
            saldo += conta.getSaldo();
        }
        return saldo;
    }

    public void adicionarConta(IConta c) {
        this.contas.add(c); 
    }

    public CarteiraContas getContasByCliente(Cliente c) {
        CarteiraContas contasCliente = new CarteiraContas();
        for (IConta conta : contas) {
            if(c.getMatricula() != conta.getMatriculaCliente()) continue;
            contasCliente.adicionarConta(conta);
        }
        return contasCliente;
    }

    public Boolean removerConta(int numero) {
        for(int i = 0; i < this.contas.size(); i++) {
            IConta conta = this.contas.get(i);
            if(conta.getNumero() == numero) {
                this.contas.remove(conta);
                return true;
            }
            continue;
        }
        return false;
    } 
}