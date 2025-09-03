package br.pucpr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PreencherImagemFila test = new PreencherImagemFila();
        test.PegarPontoInicial(10,10);
        test.ColorirImagem();
    }
}