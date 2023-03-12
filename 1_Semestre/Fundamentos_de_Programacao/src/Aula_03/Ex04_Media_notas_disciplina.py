# Escrever um programa que leia as notas e exiba a média final com base na fórmula de cálculo definida na disciplina

# Variáveis
# g1, p1, p2, e, tf: number

# Início
def main():
    p1 = int(input("Digite aqui a nota da P1: "))
    p2 = int(input("Digite aqui a nota da P2: "))
    e = int(input("Digite aqui a média das notas dos 3 trabalhos individuais: "))
    tf = int(input("Digite aqui a nota da prova final em grupo: "))
    g1 = (p1 + 2*p2 + e + 2*tf)/6
    if (g1 >= 7):
        print("A média final da disciplina é:", g1, "e você está aprovado.")
    elif (g1 < 7 and g1 >= 4):
        print("A média final da disciplina é:", g1,
              ". Infelizmente, você está de recuperação.")
    elif (g1 < 4):
        print("Já era.")
    else:
        print("Erro, revise o código")


main()
