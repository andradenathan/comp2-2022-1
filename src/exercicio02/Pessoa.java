package exercicio02;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;

    public Pessoa(String cpf, String nome) {}

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
