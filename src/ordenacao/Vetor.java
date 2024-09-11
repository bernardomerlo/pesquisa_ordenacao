package ordenacao;

import dados.Item;

public class Vetor {

    public Item[] vetor;
    private int nElem;

    public Vetor(int tamanho) {
        this.vetor = new Item[tamanho];
        this.nElem = 0;
    }

    public int getnElem() {
        return nElem;
    }

    public void setnElem(int nElem) {
        this.nElem = nElem;
    }

    public boolean inserirDados(Item novo) {
        if (this.nElem == this.vetor.length) {
            return false;
        } else {
            this.vetor[this.nElem] = novo;
            this.nElem++;
            return true;
        }
    }

    /**
     * Método de ordenação utilizando o algoritmo de Seleção Direta (Selection
     * Sort).
     *
     * @return int[] Um array onde: [0] comparacoes: O número total de
     * comparações feitas entre os elementos do vetor. [1] trocas: O número
     * total de trocas de posição realizadas.
     */
    public int[] selecaoDireta() {
        int i, j, minimo;
        int comparacoes = 0;
        int trocas = 0;
        Item temp;
        for (i = 0; i < this.nElem - 1; i++) {
            trocas++;
            minimo = i;
            for (j = i + 1; j < this.nElem; j++) {
                comparacoes++;
                if (this.vetor[j].getChave() < this.vetor[minimo].getChave()) {
                    minimo = j;
                }
            }
            temp = this.vetor[minimo];
            this.vetor[minimo] = this.vetor[i];
            this.vetor[i] = temp;
        }
        return new int[]{comparacoes, trocas};
    }

    public static int[] bubblesort(int[] vet) {
        int aux;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                comparacoes++;

                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;

                    trocas++;
                }
            }
        }

        return new int[]{comparacoes, trocas};
    }


    public int[] heapSort() {
        int dir = nElem - 1;
        int esq = (dir - 1) / 2;
        int[] vet = {0, 0};
        Item temp;

        while (esq >= 0) {
            int[] result = refazHeap(esq--, dir);
            vet[0] += result[0];
            vet[1] += result[1];
        }


        while (dir > 0) {
            temp = this.vetor[0];
            this.vetor[0] = this.vetor[dir];
            this.vetor[dir--] = temp;
            vet[1] += 2;

            int[] result = refazHeap(0, dir);
            vet[0] += result[0];
            vet[1] += result[1];
        }

        return vet;
    }


    private int[] refazHeap(int esq, int dir) {
        int i = esq;
        int MaiorFolha = 2 * i + 1;
        Item raiz = this.vetor[i];
        boolean heap = false;
        int comparacoes = 0;
        int trocas = 0;

        while (MaiorFolha <= dir && !heap) {
            comparacoes++;
            if (MaiorFolha < dir) {
                comparacoes++;
                if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave()) {
                    MaiorFolha++;
                }
            }
            comparacoes++;
            if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
                this.vetor[i] = this.vetor[MaiorFolha];
                trocas++;
                i = MaiorFolha;
                MaiorFolha = 2 * i + 1;
            } else {
                heap = true;
            }
        }
        this.vetor[i] = raiz;
        trocas++;

        return new int[]{comparacoes, trocas};
    }


    public int[] inserçãoDireta() {
        int i, j;
        Item temp;
        int comparacoes = 0;
        int trocas = 0;

        for (i = 1; i < this.nElem; i++) {
            temp = this.vetor[i];
            j = i - 1;

            while (j >= 0) {
                comparacoes++;
                if (this.vetor[j].getChave() > temp.getChave()) {
                    this.vetor[j + 1] = this.vetor[j];
                    j--;
                    trocas++;
                } else {
                    break;
                }
            }
            this.vetor[j + 1] = temp;
            if (j + 1 != i) {
                trocas++;
            }
        }

        return new int[]{comparacoes, trocas};
    }


    public int[] shellSort() {
        int n = this.nElem;
        int comparacoes = 0;
        int trocas = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Item key = this.vetor[i];
                int j = i;
                while (j >= gap) {
                    comparacoes++;
                    if (this.vetor[j - gap].getChave() > key.getChave()) {
                        this.vetor[j] = this.vetor[j - gap];
                        j -= gap;
                        trocas++;
                    } else {
                        break;
                    }
                }
                this.vetor[j] = key;
                if (j != i) {
                    trocas++;
                }
            }
        }
        return new int[]{comparacoes, trocas};

    }

    public int[] bubblesort() {
        int n, i, j;
        Item temp;
        n = this.nElem - 1;
        int comparacoes = 0;
        int trocas = 0;
        do {
            i = 0;
            for (j = 0; j < n; j++) {
                comparacoes++;
                if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
                    temp = this.vetor[j];
                    this.vetor[j] = this.vetor[j + 1];
                    this.vetor[j + 1] = temp;
                    i = j;
                    trocas += 2;
                }
            }
            n = i;
        } while (n >= 1);
        return new int[]{comparacoes, trocas};
    }

    public int[] quicksort() {
        int[] result = ordena(0, this.nElem - 1);
        return result;
    }

    private int[] ordena(int esq, int dir) {
        int pivo, i = esq, j = dir;
        Item temp;
        int[] result = {0, 0};


        pivo = this.vetor[(i + j) / 2].getChave();

        do {

            result[0]++;
            while (this.vetor[i].getChave() < pivo) {
                i++;
                result[0]++;
            }


            result[0]++;
            while (this.vetor[j].getChave() > pivo) {
                j--;
                result[0]++;
            }

            if (i <= j) {

                temp = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = temp;
                result[1] += 2;

                i++;
                j--;
            }
        } while (i <= j);


        if (esq < j) {
            int[] resultLeft = ordena(esq, j);
            result[0] += resultLeft[0];
            result[1] += resultLeft[1];
        }
        if (dir > i) {
            int[] resultRight = ordena(i, dir);
            result[0] += resultRight[0];
            result[1] += resultRight[1];
        }

        return result;
    }


    public int[] shakersort() {
        int esq, dir, i, j;
        Item temp;
        int comparacoes = 0;
        int trocas = 0;

        esq = 1;
        dir = this.nElem - 1;
        j = dir;

        do {

            for (i = dir; i >= esq; i--) {
                comparacoes++;
                if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {

                    temp = this.vetor[i];
                    this.vetor[i] = this.vetor[i - 1];
                    this.vetor[i - 1] = temp;
                    trocas++;
                    j = i;
                }
            }
            esq = j + 1;


            for (i = esq; i <= dir; i++) {
                comparacoes++;
                if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {

                    temp = this.vetor[i];
                    this.vetor[i] = this.vetor[i - 1];
                    this.vetor[i - 1] = temp;
                    trocas++;
                    j = i;
                }
            }
            dir = j - 1;

        } while (esq <= dir);

        return new int[]{comparacoes, trocas};
    }


    @Override
    public String toString() {
        String msg = "";
        for (int i = 0; i < this.nElem; i++) {
            msg += this.vetor[i].getChave() + " ";
        }
        return msg;
    }

}
