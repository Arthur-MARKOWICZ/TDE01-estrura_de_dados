package br.pucpr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PreencherImagemFila test = new PreencherImagemFila();
        test.PegarPontoInicial(15,15);
        test.ColorirImagem();
    }
}