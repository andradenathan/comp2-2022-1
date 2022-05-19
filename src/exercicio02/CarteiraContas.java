package exercicio02;

import java.util.ArrayList;

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
            saldo += conta.saldo;
        }
        return saldo;
    }

    public void adicionarConta(Conta c) {
        this.contas.add(c); 
    }

    public Boolean removerConta(int numero) {
        for(int i = 0; i < this.contas.size(); i++) {
            Conta conta = this.contas.get(i);
            if(conta.numero == numero) {
                this.contas.remove(conta);
                return true;
            }
            continue;
        }
        return false;
    } 
}
