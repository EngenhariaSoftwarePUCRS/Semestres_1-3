package Aula14;

import java.util.Arrays;
import java.util.ArrayList;

public class AlunoAtleta implements Aluno, Atleta {
    private String nome;
    private int matricula;
    private Modalidade modAtleta;
    private ArrayList<Float> notas;

    public AlunoAtleta(int matricula, String nome, Modalidade modAtleta) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.modAtleta = modAtleta;
        notas = new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f));
    }

    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Modalidade getModalidade() {
        return modAtleta;
    }

    @Override
    public boolean setNota(int nro, float nota) {
        nro--;
        if (nro >= 0 && nro <= 2) {
            notas.set(nro, nota);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getNota(int nro) {
        nro--;
        if (nro >= 0 && nro <= 2) {
            return notas.get(nro);
        } else {
            return -1;
        }
    }

    @Override
    public float mediaFinal() {
        return (notas.get(0) + notas.get(1) + notas.get(2)) / 3;
    }

    @Override
    public boolean aprovado() {
        return mediaFinal() >= 7.0;
    }

    @Override
    public String toString() {
        return "AlunoAtleta [matricula=" + getMatricula() + ", modAtleta=" + getModalidade() + ", nome=" + getNome()
                + ", media=" + mediaFinal() + ", notas="
                + notas + "]";
    }

    @Override
    public int compareTo(Aluno outro) {
        // TODO Auto-generated method stub
        return 0;
    }
}