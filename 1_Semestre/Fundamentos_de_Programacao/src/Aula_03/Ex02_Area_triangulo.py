# Escrever um programa que leia a base e altura de um triângulo e escreva o valor da área

# Variáveis
# base: number
# altura: number
# area: number

# Início
def main():
    base = int(input("Digite aqui a base do triângulo: "))
    altura = int(input("Digite aqui a altura do triângulo: "))
    area = base*altura/2
    print("A área do triângulo de base", base, "e altura", altura, "é:", area)


main()
# Fim
