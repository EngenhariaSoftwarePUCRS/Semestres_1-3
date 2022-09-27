package Aula15;

import java.util.Arrays;
import java.util.ArrayList;

public class App {
        public static void main(String[] args) {
			 	Aluno alunos[] = new Aluno[3];
				alunos[0] = new AlunoAtrib(10, "Huguinho");
				alunos[1] = new AlunoAtleta(20, "Zezinho", Modalidade.BASQUETE);
				alunos[2] = new AlunoArranjo(30, "Luizinho");

				for (int i = 0; i < alunos.length; i++) {
					alunos[i].setNota(1,5+i);
					alunos[i].setNota(2,6);
					alunos[i].setNota(3,7);
				}

				Arrays.sort(alunos);

				for (int i = 0; i < alunos.length; i++) {
					System.out.println(alunos[i]);
				}

                Funcionario funcionarios[] = new Funcionario[3];
                funcionarios[0] = new Funcionario(100, "Ze", 5000, Modalidade.CORRIDA);
                funcionarios[1] = new Funcionario(200, "Ze Maria", 8000, Modalidade.FUTEBOL);
                funcionarios[2] = new Funcionario(300, "Ze Miguel", 7000, Modalidade.NONE);
				
				Arrays.sort(funcionarios);

				ArrayList<Atleta> atletas = new ArrayList<Atleta>();
                atletas.add(funcionarios[0]);
                atletas.add((Atleta) alunos[1]);
                atletas.add(funcionarios[1]);
                atletas.add(funcionarios[2]);
                atletas.add(new AlunoAtleta(1012, "Fulano", Modalidade.NATACAO));

				for (Atleta a : atletas) {
                        System.out.println(a.getModalidade());
                }
        }
}