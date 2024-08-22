import dados.Item;
import ordenacao.Vetor;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Digite o tamanho do vetor: ");
        int tamanho = sc.nextInt();
        Vetor vetor = new Vetor(tamanho);

        for (int i=0; i< tamanho; i++) {
            vetor.inserirDados(new Item(random.nextInt(999))) ;
        }
        System.out.println("Vetor antes\n"+vetor.toString());

        vetor.selecaoDireta();
        System.out.println("Vetor ordenado\n"+vetor.toString());

    }
}