/*
 Aponte e corrija os erros do programa a seguir.
*/

/* Programa Original */

#include <stdio.h>

// Esta função deve receber duas variáveis
// por referência e caso a primeira seja
// maior que a segunda, trocá-las entre si.

void trocaMaiorWrong(int x, int y)
{
	if (x < y)
	{
		int temp = x;
		int x = y;
		int y = temp;
	}
}

int mainWrong()
{
	int a = 12;
	int b = 8;
	printf("Antes: A=%d, B=%d\n", a, b);
	printf("Endereco de A: %p\n", a);
	printf("Endereco de B: %p\n", b);
	trocaMaiorWrong(a, b);
	printf("Após troca: A=%d, B=%d\n", a, b);
	return 0;
}

/* Programa corrigido */

#include <stdio.h>

// Esta função deve receber duas variáveis
// por referência e caso a primeira seja
// maior que a segunda, trocá-las entre si.

void trocaMaior(int *x, int *y);

int main()
{
	printf("\n\n\t===== ENUNCIADO =====\n\n");
	mainWrong();
	printf("\n\n\t===== SOLUÇÃO =====\n\n");

	int a = 12;
	int b = 8;
	printf("Antes: A=%d, B=%d\n", a, b);
	printf("Endereco de A: %p\n", &a);
	printf("Endereco de B: %p\n", &b);
	trocaMaior(&a, &b);
	printf("Após troca: A=%d, B=%d\n", a, b);
	return 0;
}

void trocaMaior(int *x, int *y)
{
	if (*x < *y)
	{
		int temp = *x;
		*x = *y;
		*y = temp;
	}
}
