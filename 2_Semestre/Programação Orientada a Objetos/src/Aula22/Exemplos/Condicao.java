package Aula22.Exemplos;

@FunctionalInterface
public interface Condicao<T> {
    boolean verifica(T obj);
}