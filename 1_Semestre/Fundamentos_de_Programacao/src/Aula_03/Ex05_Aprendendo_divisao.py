# Criar um programa que leia dois números (N1 e N2) e mostre o valor da divisão inteira e o resto da divisão inteira

# Variáveis
# n1, n2, divisao_inteira, resto: number

# Início
def main():
    n1 = int(input("Digite aqui um número: "))
    n2 = int(input("Digite aqui um número: "))
    divisao_inteira = n1//n2
    resto = n1 % n2
    print(n1, "dividido por", n2, "é",
          divisao_inteira, ", e possui resto:", resto)


main()
# Fim
