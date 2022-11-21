package Aula15;

public interface Aluno extends Comparable {
	boolean setNota(int nro, float nota);
	float getNota(int nro);
	float mediaFinal();
	boolean aprovado();
	int compareTo(Aluno outro);
}