#Variáveis
    #temp_fahrenheit, temp_celsius: number
#Início
def main():
    print("Vem dos Estados Unidos mas tem medo de não entender a temperatura?")
    print("Não se preocupe, para saber a temperatura basta digitar abaixo o valor em Celsius que será devolvido seu equivalente em Fahrenheit!")
    temp_fahrenheit = int(input("Temperatura em ºF: "))
    temp_celsius = ( (temp_fahrenheit - 160) * 5/9 )
    print ("O equivalente em Celsius é: ",temp_celsius,"ºC")
main()
#Fim