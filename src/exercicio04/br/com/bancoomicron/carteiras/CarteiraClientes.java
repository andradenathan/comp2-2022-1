/**
 * Autor: Nathan Andrade dos Santos Lobo
 * DRE: 120082390
 */

package exercicio04.br.com.bancoomicron.carteiras;

import java.util.ArrayList;

import exercicio04.br.com.bancoomicron.pessoas.Cliente;

public class CarteiraClientes implements IAuditoria {
    private ArrayList<Cliente> clientes;

    public CarteiraClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public int quantidadeContas() {
        int totalContas = 0;
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            totalContas += cliente.numContas();
        }
        return totalContas;
    }

    public double somaSaldo() {
        double saldoTotal = 0;
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            saldoTotal += cliente.somaSaldo();
        }
        return saldoTotal;
    }

    public void adicionaCliente(Cliente c) {
        if(this.getIndicePorCpf(c.getCpf()) != -1) {
            throw new IllegalArgumentException("Cliente já existente");
        }

        this.clientes.add(c);
    }

    public int getIndicePorCpf(String cpf) {
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if(cliente.getCpf() == cpf) {
                return this.clientes.indexOf(cliente);
            }
            continue;
        }
        return -1;
    }

    public Boolean removerCliente(String cpf) {
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if(cliente.getCpf() == cpf) {
                this.clientes.remove(cliente);
                return true;
            }
            continue;
        }
        return false;
    }

    public Boolean removerCliente(String[] cpfs) {
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);

            for(int j = 0; j < i; j++) {
                if(cliente.getCpf() == cpfs[j]) {
                    this.clientes.remove(cliente);
                    return true;
                }
                continue;
            }
            continue;
        }
        return false;
    }

    public Cliente buscarCpf(String cpf) {
        int index = this.getIndicePorCpf(cpf);
        if(index == -1) return null;
         
        return this.clientes.get(index);
    }

    public CarteiraContas geraCarteiraContas() {
        CarteiraContas carteira = new CarteiraContas();
        
        for(Cliente cliente : clientes) {
            carteira.getContasByCliente(cliente);
        }

        return carteira;
    }
}