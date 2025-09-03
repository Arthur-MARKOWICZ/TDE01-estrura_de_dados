package br.pucpr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PreencherImagemFila testFila = new PreencherImagemFila();
        PreencherImagemPilha testpilha = new PreencherImagemPilha();
        testFila.PegarPontoInicial(15,15);
        testFila.ColorirImagem();
        testpilha.PegarPontoInicial(15,15);
        testpilha.ColorirImagem();
    }
}