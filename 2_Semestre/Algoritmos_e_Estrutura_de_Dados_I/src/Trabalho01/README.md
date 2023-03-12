## Relatório da Implementação

Para executar o programa, foram criadas 3 classes principais:
- Sistema - cuida de interações com o usuário e leitura de arquivo.
  - O sistema itera por todas as linhas do arquivo, avalia a operação lida e, caso válida, ou
    - Empilha o valor; ou
    - Remove os valores necessários para realizar a operação, envia para a calculadora e esta devolve o valor por ser empilhado.
<hr>

- CalculadoraComplexo - apenas calcula e devolve novos números como resultado.
  - Recebe um ou dois números complexos, dependendo da operação, e devolve um novo que equivale ao resultado desta.
  - Por ventura, retorna uma exceção matemática, para o caso de tentar dividir por zero.
<hr>

- NumeroComplexo - define o que é um número complexo, permite manipulá-los e imprimi-los.
  - Um número complexo é composto por dois números reais, com ponto flutuante, e ao segundo é adicionada a letra i para dizer que representa a parte imaginária.
<hr>

Além destas, existe a classe de Teste, que permite criar um novo arquivo ou testar todos já existentes em uma única pilha.