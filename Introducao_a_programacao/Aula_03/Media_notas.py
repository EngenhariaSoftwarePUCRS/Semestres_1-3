#Variáveis
    #nota_prova_1, nota_prova_2, nota_prova_3, media_final: number
#Início
def main():
    nota_prova_1 = int(input("Digite aqui a nota da primeira prova: "))
    nota_prova_2 = int(input("Digite aqui a nota da segunda prova: "))
    nota_prova_3 = int(input("Digite aqui a nota da terceira prova: "))
    media_final = (nota_prova_1+nota_prova_2+nota_prova_3)/3
    print("A média final das três provas é:",media_final)
main()
#Fim