package Aula15_SimuladoP1;

public class Questao08 {
    int[] hashTable;

    public Questao08() {
        hashTable = new int[7];
        for (int i = 0; i < hashTable.length; i++)
            hashTable[i] = -1;
    }

    public void inserir(int chave) throws Exception {
        if (!isValid(chave))
            return;
        int hashIndex = chave % 7;
        int valueInIndex = hashTable[hashIndex];
        boolean free = valueInIndex == -1;
        if (free) {
            hashTable[hashIndex] = chave;
            System.out.printf("Chave %s inserida com sucesso na posição %d%n", chave, hashIndex);
            return;
        }
        if (valueInIndex == chave) {
            System.out.println("Chave já existe");
            return;
        }
        for (int i = 0; i < hashTable.length; i++)
            if (hashTable[i] == -1) {
                hashTable[i] = chave;
                return;
            }
        throw new Exception("Não há mais espaço disponível");
    }

    public boolean isValid(int value) {
        return (value >= 0 && value <= 1000);
    }

    public static void main(String[] args) {
        Questao08 q = new Questao08();
        try {
            for (int i = 0; i < 1000; i++)
                q.inserir((int) Math.floor(Math.random() * 1000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}