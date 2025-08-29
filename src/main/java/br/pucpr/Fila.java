package br.pucpr;

public class Fila {
    private int[][] dados;
    private int [] inicio;
    private int []fim;
    private int  [] tamanho;
    private int capacidade;
    public Fila(int capacidade,int Nfilas){
        this.capacidade = capacidade;
        dados = new int[Nfilas][capacidade];
        inicio = new int[Nfilas];
        fim = new int[Nfilas];
        tamanho = new int[Nfilas];
        for (int i = 0; i < Nfilas; i++) {
            inicio[i] = 0;
            fim[i] = -1;
            tamanho[i] = 0;
        }
    }
    public void enfileirar(int filaId, int valor) {
        if (tamanho[filaId] == capacidade) {
            System.out.println("Fila " + filaId + " cheia!");
            return;
        }
        fim[filaId] = (fim[filaId] + 1) % capacidade;
        dados[filaId][fim[filaId]] = valor;
        tamanho[filaId]++;
    }

    public int desenfileirar(int filaId) {
        if (tamanho[filaId] == 0) {
            throw new RuntimeException("Fila " + filaId + " vazia!");
        }
        int valor = dados[filaId][inicio[filaId]];
        inicio[filaId] = (inicio[filaId] + 1) % capacidade;
        tamanho[filaId]--;
        return valor;
    }

}
