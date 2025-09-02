package br.pucpr;

public class Pilha {
    private int [] dados;
    private int topo;

    public Pilha (int capacidade){
        dados = new int [capacidade];
        topo = -1;
    }

    public void push (int valor){
        if (topo == dados.length - 1) throw new RuntimeException("Imagem preenchida");
        dados[++topo] = valor;
    }

    public int pop(){
        if (topo == -1) throw new RuntimeException("Pilha isVazia");
        return dados[topo-1];
    }
}
