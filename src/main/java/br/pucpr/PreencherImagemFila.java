package br.pucpr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PreencherImagemFila {
    private int cor;
    private int valor1;
    private int valor2;
    private int contador;
    private JFrame frame;
    private AbaImagem panel;
    private int contadorDeFrames = 0;
    public PreencherImagemFila() throws IOException {

        frame = new JFrame("Animação Flood Fill");
        panel = new AbaImagem(img);
        frame.add(panel);
        frame.setSize(img.getWidth() + 20, img.getHeight() + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/golem.png"));
    private int valorTotalDosPixels = img.getHeight() * img.getWidth();
    Fila fila = new Fila(valorTotalDosPixels * 4);


    public void PegarPontoInicial(int valor1, int valor2) throws IOException {
        this.valor1 = valor1;
        this.valor2 = valor2;
        cor = img.getRGB(valor1, valor2);
        fila.enfileirar(valor1, valor2);

    }
        public void ColorirImagem() throws IOException, InterruptedException {

            while (!fila.isVazia()){
                int[] ponto = fila.desenfileirar();
                int pixelX = ponto[0];
                int pixelY = ponto[1];
                System.out.println("desenfileirando: " + pixelX + "," + pixelY);
                if (pixelX >= 0 && pixelX < img.getWidth() && pixelY >= 0 && pixelY < img.getHeight()
                        && img.getRGB(pixelX, pixelY) == cor) {
                    System.out.println("pintando o pixel: " + pixelX  + "," + pixelY);
                    img.setRGB(pixelX, pixelY, 0xFFFFFFFF);

                    fila.enfileirar(pixelX + 1, pixelY);
                    System.out.println("enfilirando: " + (pixelX + 1 ) +"," + pixelY);
                    fila.enfileirar(pixelX - 1, pixelY);
                    System.out.println("enfilirando: " + (pixelX -1 ) +"," + pixelY);
                    fila.enfileirar(pixelX, pixelY + 1);
                    System.out.println("enfilirando: " +pixelX +  "," +(pixelY +1 )  );
                    fila.enfileirar(pixelX, pixelY - 1);
                    System.out.println("enfilirando: " + pixelX + "," +(pixelY -1 )   );
                    panel.repaint();
                    Thread.sleep(5);
                    contador++;
//                    if (contador % 100 == 0) {
//                        salvarFrame();
//                    }

                }
            }
            ImageIO.write(img, "png", new File("fila.png"));
//            salvarFrame();
        }

//    private void salvarFrame() throws IOException {
//        contadorDeFrames++;
//        String nomeArquivo = String.format("frame%04d.png", contadorDeFrames);
//        ImageIO.write(img, "png", new File(nomeArquivo));
//        System.out.println("Frame salvo: " + nomeArquivo);
//    }

    }

