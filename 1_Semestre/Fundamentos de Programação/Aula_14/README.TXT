ENTREGA PELO MOODLE
1)	Construir em Java o programa calculadora. Esse programa deve contemplar as seguintes operações a partir de dois valores informados:
•	Adição
•	Subtração
•	Divisão
•	Multiplicação
•	Resto da divisão
•	Divisão inteira
•	Potência (informar base e expoente)

O programa deve iniciar perguntando o nome do usuário que está utilizando o programa. Após o usuário digitar o nome deve ser dada uma mensagem de boas-vindas para ele citando o nome digitado. Por exemplo: 
Fulano de tal, seja bem-vindo ao programa Calculadora.
Em seguida o programa deve exibir um menu de opções com as operações disponíveis.
A partir da operação selecionada o programa deve pedir os valores para realizar a operação. Por exemplo: se o usuário selecionar a operação Adição então o programa deve pedir os valores a serem somados (dois valores).
Uma vez realizada a operação o programa deve finalizar exibindo o resultado e agradecendo o uso do programa. Exemplo:
	O resultado da Soma é xxx. 
	Fulano de tal, obrigado por usar o programa Calculadora. Tchau!!!

Observações:
a)	Caso o usuário selecione a operação de divisão e informar o valor zero para o divisor então o programa deve dizer que o valor é inválido e pedir para o usuário informar novamente (apenas uma vez). Se continuar errado então não realizar a operação e encerrar o programa.
b)	A operação Potência deve solicitar a base e o expoente nessa ordem.
c)	Os valores de entrada devem ser inteiros, porém os resultados podem ser de diferentes tipos (double ou int).
d)	O menu deve ser implementado com a instrução switch.
e)	O resultado da divisão deve ser impresso com apenas duas casas decimais.

2)	Construir o programa “cifrar/decifrar palavras”.
Esse programa deve perguntar ao usuário se ele quer cifrar ou decifrar uma palavra. Em seguida o programa deve ler a palavra a ser cifrada ou decifrada.
Então com base na escolha do usuário e na palavra lida o programa deve mostrar o resultado.
A regra para cifrar/decifrar está abaixo:
	- Cada letra a é substituída pela letra w e cada w é substituído por a.
	- Cada letra e é substituída pela letra y e cada y é substituído por e.
- Cada letra i é substituída pela letra h e cada h é substituído por i.
Exemplo:
	Palavra: abacate  Cifrado: wbwcwty
	Palavra: wbwcwty  Decifrado: abacate

