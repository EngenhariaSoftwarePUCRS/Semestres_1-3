#Variáveis
    #ano_nascimento, ano_atual, idade, idade_conservadora: number
#Início
def main():
    ano_nascimento = int(input("Digite aqui seu ano de nascimento: "))
    ano_atual = int(input("Digite aqui o ano atual: "))
    idade = ano_atual - ano_nascimento
    idade_conservadora = idade - 1
    print("Você tem entre:",idade_conservadora,"e",idade,", anos de idade.")
main()    
#Fim