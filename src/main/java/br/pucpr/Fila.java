package br.pucpr;

public class Fila {
    private int[] dados;
    private  int inicio;
    private int fim;
    private  int   tamamanho;
    public Fila(int capacidade){
        dados = new int[capacidade];
        inicio = 0;
        fim = 0;
        tamamanho = 0;
    }
    public void  adicionar(int valor){
        if(fim == dados.length){
            throw  new RuntimeException("fila completa");
        }
        dados[fim++] = valor;
        tamamanho++;
    }
    public  int remover(){
        if(tamamanho==0){
            throw new RuntimeException("fila vazia");
        }
        int valor = dados[inicio++];
        tamamanho--;
        return valor;
    }

}
