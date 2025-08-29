package br.pucpr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class PreencherImagemFila {
    public PreencherImagemFila() throws IOException {
    }
    BufferedImage img = ImageIO.read(new File("golem.png"));
    Fila fila = new Fila(img.getWidth(),img.getHeight());
    public void PegarPontoInicial(int valor1, int valor2){
        int cor = img.getRGB(valor1,valor2);
    }




}
