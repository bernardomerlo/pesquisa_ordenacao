package ordenacao;

import dados.Item;

public class Vetor {
    private Item[] vetor;
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
        if (this.nElem == this.vetor.length) {  // verifica se est� cheio
            return false;
        } else {
            this.vetor[this.nElem] = novo;
            this.nElem++;
            return true;
        }
    }

    /**
     * Método de ordenação utilizando o algoritmo de Seleção Direta (Selection Sort).
     *
     * @return int[] Um array onde:
     *          [0] comparacoes: O número total de comparações feitas entre os elementos do vetor.
     *          [1] trocas: O número total de trocas de posição realizadas.
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

    static void bubblesort(int[] vet) {
        int aux;
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }

    }

    public void heapSort() {
        int dir = nElem - 1;
        int esq = (dir - 1) / 2;
        Item temp;
        while (esq >= 0)
            refazHeap(esq--, this.nElem - 1);
        while (dir > 0) {
            temp = this.vetor[0];
            this.vetor[0] = this.vetor[dir];
            this.vetor[dir--] = temp;
            refazHeap(0, dir);
        }
    }

    private void refazHeap(int esq, int dir) {
        int i = esq;
        int MaiorFolha = 2 * i + 1;
        Item raiz = this.vetor[i];
        boolean heap = false;
        while ((MaiorFolha <= dir) && (!heap)) {
            if (MaiorFolha < dir)
                if (this.vetor[MaiorFolha].getChave() <
                        this.vetor[MaiorFolha + 1].getChave())
                    MaiorFolha++;
            if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
                this.vetor[i] = this.vetor[MaiorFolha];
                i = MaiorFolha;
                MaiorFolha = 2 * i + 1;
            } else
                heap = true;
        }
        this.vetor[i] = raiz;
    }

    public void inserçãoDireta() {
        int i, j;
        Item temp;
        for (i = 1; i < this.nElem; i++) {
            temp = this.vetor[i];
            j = i - 1;
            while ((j >= 0) && this.vetor[j].getChave() > temp.getChave()) {
                this.vetor[j + 1] = this.vetor[j--];
            }
            this.vetor[j + 1] = temp;
        }
    }

    public void shellSort() {
        int i, j, h;
        Item temp;
        h = 1;
        do {
            h = 3 * h + 1;
        } while (h < this.nElem);
        do {
            h = h / 3;
            for (i = h; i < this.nElem; i++) {
                temp = this.vetor[i];
                j = i;
                while (this.vetor[j - h].getChave() > temp.getChave()) {
                    this.vetor[j] = this.vetor[j - h];
                    j -= h;
                    if (j < h)
                        break;
                }
                this.vetor[j] = temp;
            }
        } while (h != 1);
    }

    public void bubblesort() {
        int n, i, j;
        Item temp;
        n = this.nElem - 1;
        do {
            i = 0;
            for (j = 0; j < n; j++)
                if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
                    temp = this.vetor[j];
                    this.vetor[j] = this.vetor[j + 1];
                    this.vetor[j + 1] = temp;
                    i = j;
                }
            n = i;
        } while (n >= 1);
    }


    public void quicksort() {
        ordena(0, this.nElem - 1);
    }

    private void ordena(int esq, int dir) {
        int pivo, i = esq, j = dir;
        Item temp;
        pivo = this.vetor[(i + j) / 2].getChave();
        do {
            while (this.vetor[i].getChave() < pivo) i++;
            while (this.vetor[j].getChave() > pivo) j--;
            if (i <= j) {
                temp = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (esq < j) {
            ordena(esq, j);
        }
        if (dir > i) {
            ordena(i, dir);
        }
    }

    public String toString() {
        String msg = "";
        for (int i = 0; i < this.nElem; i++) {
            msg += this.vetor[i].getChave() + " ";
        }
        return msg;
    }

}
