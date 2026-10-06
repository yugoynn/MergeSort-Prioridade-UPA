package br.upa;

public class Paciente {

    private String nome;
    private int idade;
    private String cor;

    // construtor vazio usado pelo Spring para ler o JSON do front
    public Paciente() {
    }

    public Paciente(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
