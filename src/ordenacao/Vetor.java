package ordenacao;

import dados.Item;

public class Vetor {
	private Item [] vetor;
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
	public void inserirDados(Item novo) {
		if (this.nElem == this.vetor.length) {  // verifica se est� cheio
		}else {
			this.vetor[this.nElem]= novo;
			this.nElem++;
		}
	}
	
	public void selecaoDireta(){
		int i, j, minimo;
		Item temp;
		for (i=0; i<this.nElem-1;i++){
			minimo = i;
			for (j = i+1; j < this.nElem; j++)
				if (this.vetor[j].getChave() < this.vetor[minimo].getChave())
					minimo = j;
			temp = this.vetor[minimo];
			this.vetor[minimo] = this.vetor[i];
			this.vetor[i] = temp;
		}
	}

	@Override
	public String toString() {
		String msg = "";
		for (int i=0; i < this.nElem; i++) {
			msg += this.vetor[i].getChave()+" ";
		}
		return msg;
	}
	
}
