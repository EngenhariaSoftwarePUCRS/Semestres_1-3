package Aula22.Exemplos;

@FunctionalInterface
public interface Operacao<T> {
    Double calcula(T obj);
}