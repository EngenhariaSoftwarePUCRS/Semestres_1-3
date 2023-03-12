# Criar um programa que calcule o total gasto em uma viagem. O programa deve ler o valor do litro da gasolina, a distância percorrida e o consumo médio do veículo

# Variáveis
# total_gasto, valor_litro, distancia_percorrida, consumo_medio: number

# Início
def main():
    valor_litro = int(input("Digite o valor do litro da gasolina: "))
    distancia_percorrida = int(input("Digite a distância percorrida: "))
    consumo_medio = int(input("Digite o consumo médio do veículo: "))
    total_gasto = (distancia_percorrida / consumo_medio) * valor_litro
    print("O total gasto na viagem foi de: ", total_gasto)


main()
# Fim
