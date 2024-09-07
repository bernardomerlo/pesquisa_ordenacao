package main;

import dados.Item;
import ordenacao.Vetor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainShellSort {

    public static void main(String[] args) {
        Vetor vetorAleatorio100 = new Vetor(100);
        Vetor vetorCrescente100 = new Vetor(100);
        Vetor vetorDecrescente100 = new Vetor(100);
        Vetor vetorAleatorio10000 = new Vetor(10000);
        Vetor vetorCrescente10000 = new Vetor(10000);
        Vetor vetorDecrescente10000 = new Vetor(10000);

        String path = "C:\\Users\\Bernardo\\Documents\\estudos\\faesa\\pesquisa_ordenacao\\";

        String pathVetorAleatorio100 = path + "num_aleatorio_100.txt";
        String pathVetorCrescente100 = path + "num_crescente_100.txt";
        String pathVetorDecrescente100 = path + "num_decrescente_100.txt";
        String pathVetorAleatorio10000 = path + "num_aleatorio_10000.txt";
        String pathVetorCrescente10000 = path + "num_crescentes_10000.txt";
        String pathVetorDecrescente10000 = path + "num_decrescente_10000.txt";

        carregarEProcessarVetor(pathVetorAleatorio100, vetorAleatorio100);
        carregarEProcessarVetor(pathVetorCrescente100, vetorCrescente100);
        carregarEProcessarVetor(pathVetorDecrescente100, vetorDecrescente100);
        carregarEProcessarVetor(pathVetorAleatorio10000, vetorAleatorio10000);
        carregarEProcessarVetor(pathVetorCrescente10000, vetorCrescente10000);
        carregarEProcessarVetor(pathVetorDecrescente10000, vetorDecrescente10000);
    }

    public static void carregarEProcessarVetor(String caminhoArquivo, Vetor vetor) {
        carregarDados(caminhoArquivo, vetor);
        exibirVetor("Vetor antes da ordenação", vetor);
        int[] resultados = ordenarVetor(vetor);
        exibirVetor("Vetor após a ordenação", vetor);
        exibirResultadosOrdenacao(resultados);
    }

    public static void carregarDados(String caminhoArquivo, Vetor vetor) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                int valor = Integer.parseInt(linha.trim());
                Item novoItem = new Item(valor);
                if (!vetor.inserirDados(novoItem)) {
                    System.out.println("Vetor cheio, não foi possível adicionar o valor: " + valor);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static int[] ordenarVetor(Vetor vetor) {
        return vetor.shellSort();
    }

    public static void exibirVetor(String mensagem, Vetor vetor) {
        System.out.println(mensagem + ":");
        System.out.println(vetor);
    }

    public static void exibirResultadosOrdenacao(int[] resultados) {
        System.out.println("Quantidade de comparações: " + resultados[0]);
        System.out.println("Quantidade de trocas: " + resultados[1]);
        System.out.println();
    }
}
