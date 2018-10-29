package br.edu.ifpb.domain;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/10/2018, 09:42:39
 */
public class Cliente {

    private int id;
    private String nome;
    private String cpf;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this(-1, nome, cpf);
    }

    public Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

}
