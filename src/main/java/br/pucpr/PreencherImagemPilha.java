package br.pucpr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PreencherImagemPilha {
    private int cor;
    private int valor1;
    private int valor2;

    BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/testImageNoWhite.png"));
    private int valorTotalDosPixels = img.getHeight() * img.getWidth();

    Pilha pilha = new Pilha(valorTotalDosPixels * 4);

    private int contadorFrame = 0;

    public PreencherImagemPilha() throws IOException {
    }

    public void PegarPontoInicial(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        cor = img.getRGB(valor1, valor2);
        System.out.println("Pixel inicial (" + valor1 + ", " + valor2 + ") cor=" + cor);
        pilha.empilhar(valor1, valor2);
    }

    public void ColorirImagem() throws IOException {
        while (!pilha.isVazia()) {
            int[] ponto = pilha.desempilhar();
            int pixelX = ponto[0];
            int pixelY = ponto[1];

            System.out.println("Desempilhando (" + pixelX + ", " + pixelY + ")");

            if (pixelX >= 0 && pixelX < img.getWidth() && pixelY >= 0 && pixelY < img.getHeight()
                    && img.getRGB(pixelX, pixelY) == cor) {

                img.setRGB(pixelX, pixelY, 0xFFFFFFFF);
                System.out.println("   Pintando pixel (" + pixelX + ", " + pixelY + ")");
                pilha.empilhar(pixelX + 1, pixelY);
                pilha.empilhar(pixelX - 1, pixelY);
                pilha.empilhar(pixelX, pixelY + 1);
                pilha.empilhar(pixelX, pixelY - 1);

                System.out.println("   Empilhando vizinhos de (" + pixelX + ", " + pixelY + ")");
                contadorFrame++;
                if (contadorFrame % 500 == 0) {
                    ImageIO.write(img, "png", new File("frame_" + contadorFrame + ".png"));
                    System.out.println("   >> Frame salvo: frame_" + contadorFrame + ".png");
                }
            }
        }

        ImageIO.write(img, "png", new File("imagem_alterada.png"));
        System.out.println("Resultado salvo em imagem_alterada.png");
    }
}
