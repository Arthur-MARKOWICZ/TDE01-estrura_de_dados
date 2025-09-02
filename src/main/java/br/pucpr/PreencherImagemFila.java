package br.pucpr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class PreencherImagemFila {
    private int cor;
    private int valor1;
    private int valor2;

    public PreencherImagemFila() throws IOException {
    }

    BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/testImageNoWhite.png"));
    private int valorTotalDosPixels = img.getHeight() * img.getWidth();
    Fila fila = new Fila(valorTotalDosPixels * 4);

    public void PegarPontoInicial(int valor1, int valor2) throws IOException {
        this.valor1 = valor1;
        this.valor2 = valor2;
        cor = img.getRGB(valor1, valor2);
        fila.enfileirar(valor1, valor2);

    }
        public void ColorirImagem() throws IOException {

            while (!fila.isVazia()){
                int[] ponto = fila.desenfileirar();
                int pixelX = ponto[0];
                int pixelY = ponto[1];
                System.out.println("desenfileirando");
                if (pixelX >= 0 && pixelX < img.getWidth() && pixelY >= 0 && pixelY < img.getHeight()
                        && img.getRGB(pixelX, pixelY) == cor) {
                    System.out.println("pintando o pixel: " + pixelX  + "" + pixelY);
                    img.setRGB(pixelX, pixelY, 0xFFFFFFFF);

                    fila.enfileirar(pixelX + 1, pixelY);
                    fila.enfileirar(pixelX - 1, pixelY);
                    fila.enfileirar(pixelX, pixelY + 1);
                    fila.enfileirar(pixelX, pixelY - 1);
                    System.out.println("enfilirando");
                }
            }
            ImageIO.write(img, "png", new File("test1.png"));
        }


    }

