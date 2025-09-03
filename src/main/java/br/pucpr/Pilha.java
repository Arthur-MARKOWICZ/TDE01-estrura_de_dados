package br.pucpr;

public class Pilha {
    private int[][] dados;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        dados = new int[capacidade][2];
        topo = -1;
    }

    public void empilhar(int valor1, int valor2) {
        if (topo == capacidade - 1) {
            throw new RuntimeException("Pilha cheia!");
        }
        topo++;
        dados[topo][0] = valor1;
        dados[topo][1] = valor2;
    }

    public int[] desempilhar() {
        if (isVazia()) {
            throw new RuntimeException("Pilha vazia!");
        }
        int[] valor = dados[topo];
        topo--;
        return valor;
    }

    public boolean isVazia() {
        return topo == -1;
    }
}
