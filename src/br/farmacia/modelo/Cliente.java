package br.farmacia.modelo;

public class Cliente {
    private String nome;
    private int cpf;
    private int telefone;
    private String email;
    private String sexo;
    private int celular;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getCelular() {
        return celular;
    }
    public void setCelular(int celular) {
        this.celular = celular;
    }
}
