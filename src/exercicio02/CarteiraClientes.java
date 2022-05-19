package exercicio02;

import java.util.ArrayList;

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
        //TODO: Verificar e validar como será feito a implementação do método.
        double saldoTotal = 0;
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            saldoTotal += cliente.somaSaldo();
        }
        return saldoTotal;
    }

    public void adicionaCliente(Cliente c) {
        this.clientes.add(c);
    }

    public int getIndicePorCpf(String cpf) {
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if(cliente.cpf == cpf) {
                return this.clientes.indexOf(cliente);
            }
            continue;
        }
        return -1;
    }

    public Boolean removerCliente(String cpf) {
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if(cliente.cpf == cpf) {
                this.clientes.remove(cliente);
                return true;
            }
            continue;
        }
        return false;
    }

    public Boolean removerCliente(String[] cpfs) {
        //TODO: Refazer a busca por O(n).
        for(int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);

            for(int j = 0; j < i; j++) {
                if(cliente.cpf == cpfs[j]) {
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
}
