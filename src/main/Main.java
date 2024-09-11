package main;

import ordenacao.Vetor;
import dados.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Caminho dos arquivos
        String path = "C:\\Users\\Bernardo\\Documents\\estudos\\faesa\\pesquisa_ordenacao\\";

        String pathVetorAleatorio100 = path + "num_aleatorio_100.txt";
        String pathVetorCrescente100 = path + "num_crescente_100.txt";
        String pathVetorDecrescente100 = path + "num_decrescente_100.txt";
        String pathVetorAleatorio10000 = path + "num_aleatorio_10000.txt";
        String pathVetorCrescente10000 = path + "num_crescentes_10000.txt";
        String pathVetorDecrescente10000 = path + "num_decrescente_10000.txt";

        // Criação dos vetores
        Vetor vetorAleatorio100 = criarVetorDoArquivo(pathVetorAleatorio100, 100);
        Vetor vetorCrescente100 = criarVetorDoArquivo(pathVetorCrescente100, 100);
        Vetor vetorDecrescente100 = criarVetorDoArquivo(pathVetorDecrescente100, 100);
        Vetor vetorAleatorio10000 = criarVetorDoArquivo(pathVetorAleatorio10000, 10000);
        Vetor vetorCrescente10000 = criarVetorDoArquivo(pathVetorCrescente10000, 10000);
        Vetor vetorDecrescente10000 = criarVetorDoArquivo(pathVetorDecrescente10000, 10000);

        // Testar e mostrar resultados
        testarOrdenacoes("Aleatorio 100", vetorAleatorio100);
        testarOrdenacoes("Crescente 100", vetorCrescente100);
        testarOrdenacoes("Decrescente 100", vetorDecrescente100);
        testarOrdenacoes("Aleatorio 10000", vetorAleatorio10000);
        testarOrdenacoes("Crescente 10000", vetorCrescente10000);
        testarOrdenacoes("Decrescente 10000", vetorDecrescente10000);
    }

    private static Vetor criarVetorDoArquivo(String caminhoArquivo, int tamanho) {
        Vetor vetor = new Vetor(tamanho);
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.trim().split("\\s+");
                for (String valor : valores) {
                    vetor.inserirDados(new Item(Integer.parseInt(valor)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vetor;
    }

    private static void testarOrdenacoes(String nomeArquivo, Vetor vetor) {
        System.out.println("Resultados para o arquivo: " + nomeArquivo);

        // Testa e mostra o resultado da ordenação Seleção Direta
        Vetor vetorSelecaoDireta = clonarVetor(vetor);
        int[] resultadoSelecaoDireta = vetorSelecaoDireta.selecaoDireta();
        System.out.println("Seleção Direta - Comparações: " + resultadoSelecaoDireta[0] + ", Trocas: " + resultadoSelecaoDireta[1]);

        // Testa e mostra o resultado da ordenação Bubble Sort (com Item)
        Vetor vetorBubbleSort = clonarVetor(vetor);
        int[] resultadoBubbleSort = vetorBubbleSort.bubblesort();
        System.out.println("Bubble Sort - Comparações: " + resultadoBubbleSort[0] + ", Trocas: " + resultadoBubbleSort[1]);

        // Testa e mostra o resultado da ordenação Heap Sort
        Vetor vetorHeapSort = clonarVetor(vetor);
        int[] resultadoHeapSort = vetorHeapSort.heapSort();
        System.out.println("Heap Sort - Comparações: " + resultadoHeapSort[0] + ", Trocas: " + resultadoHeapSort[1]);

        // Testa e mostra o resultado da ordenação Inserção Direta
        Vetor vetorInsercaoDireta = clonarVetor(vetor);
        int[] resultadoInsercaoDireta = vetorInsercaoDireta.inserçãoDireta();
        System.out.println("Inserção Direta - Comparações: " + resultadoInsercaoDireta[0] + ", Trocas: " + resultadoInsercaoDireta[1]);

        // Testa e mostra o resultado da ordenação Shell Sort
        Vetor vetorShellSort = clonarVetor(vetor);
        int[] resultadoShellSort = vetorShellSort.shellSort();
        System.out.println("Shell Sort - Comparações: " + resultadoShellSort[0] + ", Trocas: " + resultadoShellSort[1]);

        // Testa e mostra o resultado da ordenação Shaker Sort
        Vetor vetorShakerSort = clonarVetor(vetor);
        int[] resultadoShakerSort = vetorShakerSort.shakersort();
        System.out.println("Shaker Sort - Comparações: " + resultadoShakerSort[0] + ", Trocas: " + resultadoShakerSort[1]);

        // Testa e mostra o resultado da ordenação Quick Sort
        Vetor vetorQuickSort = clonarVetor(vetor);
        int[] resultadoQuickSort = vetorQuickSort.quicksort();
        System.out.println("Quick Sort - Comparações: " + resultadoQuickSort[0] + ", Trocas: " + resultadoQuickSort[1]);

        System.out.println(); // Linha em branco para separar os resultados
    }

    // Método auxiliar para clonar o vetor
    private static Vetor clonarVetor(Vetor vetor) {
        Vetor clone = new Vetor(vetor.getnElem());
        for (int i = 0; i < vetor.getnElem(); i++) {
            clone.inserirDados(new Item(vetor.vetor[i].getChave()));
        }
        return clone;
    }
}
