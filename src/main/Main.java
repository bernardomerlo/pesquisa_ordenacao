package main;

import dados.Item;
import ordenacao.Vetor;

public class Main {
    public static void main(String[] args) {
        int[] chaves = {34, 7, 23, 32, 5, 62};  // Exemplo de chaves a serem ordenadas

        // Criar um vetor com base no número de chaves
        Vetor vetor = new Vetor(chaves.length);

        // Inserir os itens no vetor
        for (int chave : chaves) {
            vetor.inserirDados(new Item(chave));
        }

        // Imprimir o vetor original
        System.out.println("Vetor original:");
        System.out.println(vetor.toString());

        // Testar a ordenação por Seleção Direta
        Vetor vetorSelecao = new Vetor(chaves.length);
        for (int chave : chaves) {
            vetorSelecao.inserirDados(new Item(chave));
        }
        vetorSelecao.selecaoDireta();
        System.out.println("Vetor ordenado por Seleção Direta:");
        System.out.println(vetorSelecao.toString());

        // Testar a ordenação por Inserção Direta
        Vetor vetorInsercao = new Vetor(chaves.length);
        for (int chave : chaves) {
            vetorInsercao.inserirDados(new Item(chave));
        }
        vetorInsercao.inserçãoDireta();
        System.out.println("Vetor ordenado por Inserção Direta:");
        System.out.println(vetorInsercao.toString());

        // Testar a ordenação por ShellSort
        Vetor vetorShell = new Vetor(chaves.length);
        for (int chave : chaves) {
            vetorShell.inserirDados(new Item(chave));
        }
        vetorShell.shellSort();
        System.out.println("Vetor ordenado por ShellSort:");
        System.out.println(vetorShell.toString());

        // Testar a ordenação por BubbleSort
        Vetor vetorBubble = new Vetor(chaves.length);
        for (int chave : chaves) {
            vetorBubble.inserirDados(new Item(chave));
        }
        vetorBubble.bubblesort();
        System.out.println("Vetor ordenado por BubbleSort:");
        System.out.println(vetorBubble.toString());

        // Testar a ordenação por HeapSort
        Vetor vetorHeap = new Vetor(chaves.length);
        for (int chave : chaves) {
            vetorHeap.inserirDados(new Item(chave));
        }
        vetorHeap.heapSort();
        System.out.println("Vetor ordenado por HeapSort:");
        System.out.println(vetorHeap.toString());
    }
}
