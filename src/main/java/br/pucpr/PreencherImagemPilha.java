package br.pucpr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PreencherImagemPilha {
    private int cor;
    private int valor1;
    private int valor2;
    private JFrame frame;
    private AbaImagem panel;
    private int contador;

    BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/golem.png"));
    private int valorTotalDosPixels = img.getHeight() * img.getWidth();

    Pilha pilha = new Pilha(valorTotalDosPixels * 4);

    public PreencherImagemPilha() throws IOException {
        frame = new JFrame("Animação Pilha");
        panel = new AbaImagem(img);
        frame.add(panel);
        frame.setSize(img.getWidth() + 20, img.getHeight() + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void PegarPontoInicial(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        cor = img.getRGB(valor1, valor2);
        pilha.empilhar(valor1, valor2);
        System.out.println("Empilhando pixel inicial: (" + valor1 + "," + valor2 + ")");
    }

    public void ColorirImagem() throws IOException, InterruptedException {
        while (!pilha.isVazia()) {
            int[] ponto = pilha.desempilhar();
            int pixelX = ponto[0];
            int pixelY = ponto[1];

            System.out.println("Desempilhando: (" + pixelX + "," + pixelY + ")");

            if (pixelX >= 0 && pixelX < img.getWidth() && pixelY >= 0 && pixelY < img.getHeight()
                    && img.getRGB(pixelX, pixelY) == cor) {

                img.setRGB(pixelX, pixelY, 0xFFFFFFFF);
                System.out.println("Pintando pixel: (" + pixelX + "," + pixelY + ")");
                pilha.empilhar(pixelX + 1, pixelY);
                System.out.println("Empilhando: (" + (pixelX + 1) + "," + pixelY + ")");
                pilha.empilhar(pixelX - 1, pixelY);
                System.out.println("Empilhando: (" + (pixelX - 1) + "," + pixelY + ")");
                pilha.empilhar(pixelX, pixelY + 1);
                System.out.println("Empilhando: (" + pixelX + "," + (pixelY + 1) + ")");
                pilha.empilhar(pixelX, pixelY - 1);
                System.out.println("Empilhando: (" + pixelX + "," + (pixelY - 1) + ")");

                panel.repaint();
                Thread.sleep(5);
                contador++;
            }
        }

        ImageIO.write(img, "png", new File("pilha.png"));
    }
}
