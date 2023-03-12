# Criar um programa que leia a temperatura em graus Celsius e mostre a mesma em Fahrenheit. Fórmula para conversão: F = (C * 9 / 5) + 32

# Variáveis
# temp_fahrenheit, temp_celsius: number

# Início
def main():
    print("Vem dos Estados Unidos mas tem medo de não entender a temperatura?")
    print("Não se preocupe, para saber a temperatura basta digitar abaixo o valor em Celsius que será devolvido seu equivalente em Fahrenheit!")
    temp_celsius = int(input("Temperatura em ºC: "))
    temp_fahrenheit = ((temp_celsius * 9/5) + 32)
    print("O equivalente em Fahrenheit é: ", temp_fahrenheit, "ºF")


main()
# Fim
