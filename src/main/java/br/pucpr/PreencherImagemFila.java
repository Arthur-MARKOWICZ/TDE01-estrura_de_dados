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

    BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/golem.jpeg"));
    private int valorTotalDosPixels = img.getHeight() * img.getWidth();
    Fila fila = new Fila(valorTotalDosPixels);

    public void PegarPontoInicial(int valor1, int valor2) throws IOException {
        this.valor1 = valor1;
        this.valor2 = valor1;
        cor = img.getRGB(valor1, valor2);
        fila.enfileirar(valor1, valor2);
        img.setRGB(valor1, valor2, 0xFFFFFFFF);
    }
        public void ColorirImagem() throws IOException {
            for (int i = 0; i < valorTotalDosPixels; i++) {
                valor1++;

                // Verifica se está dentro dos limites da imagem
                if (valor1 >= 0 && valor1 < img.getWidth() &&
                        valor2 >= 0 && valor2 < img.getHeight()) {

                    fila.enfileirar(valor1, valor2);

                    if (img.getRGB(valor1, valor2) == cor) {
                        img.setRGB(valor1, valor2, 0xFFFFFFFF);
                    } else {
                        valor2++;

                        if (valor1 >= 0 && valor1 < img.getWidth() &&
                                valor2 >= 0 && valor2 < img.getHeight()) {

                            fila.enfileirar(valor1, valor2);

                            if (img.getRGB(valor1, valor2) == cor) {
                                img.setRGB(valor1, valor2, 0xFFFFFFFF);
                            }
                        }
                    }
                }
            }

            ImageIO.write(img, "jpeg", new File("testigiv.jpeg"));
        }


    }

