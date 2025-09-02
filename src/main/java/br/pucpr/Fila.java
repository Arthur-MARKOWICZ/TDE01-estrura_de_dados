package br.pucpr;

public class Fila {
    private int[][] dados;
    private int  inicio;
    private int fim;
    private int  tamanho;
    private int capacidade;
    public Fila(int capacidade){
        this.capacidade = capacidade;
        dados = new int[capacidade][2];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }
    public void enfileirar(int valor1, int valor2) {
        if (tamanho == capacidade) {
            throw new RuntimeException("Fila cheia!");
        }
        fim = (fim + 1) % capacidade;
        dados[fim][0] = valor1;
        dados[fim][1] = valor2;
        tamanho++;
    }

    public int[] desenfileirar() {
        if (tamanho == 0) {
            throw new RuntimeException("Fila isVazia!");
        }
        int[] valor = dados[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return valor;
    }
    public boolean isVazia() {
        return tamanho == 0;
    }



}
