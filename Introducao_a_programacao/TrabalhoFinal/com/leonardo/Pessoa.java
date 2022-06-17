package com.leonardo;

public class Pessoa
{
    private int id;
    private String nome;

    public Pessoa(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
