import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ClasseGeradoraSticker {

    public void funcaoCriarSticker(InputStream bytesDados, String nomeArquivo) throws Exception {
        //Ler a imagem
        //BufferedImage imgOriginal = ImageIO.read(new File("Img/img.jpg")); //Linha de codigo comentado
        BufferedImage imgOriginal = ImageIO.read(bytesDados);
        
        //Criar nova imagem na memória com transparência (png(alphachannel)) e com resolução menor
        int imgWidth = imgOriginal.getWidth();
        int imgHeight = imgOriginal.getHeight();
        int imgnewHeight = imgHeight + (imgHeight/4);
        System.out.println(imgWidth + "x" + imgnewHeight);

        BufferedImage novaImg = new BufferedImage(imgWidth, imgnewHeight, BufferedImage.TRANSLUCENT);

        //Copiar imagem original pra nova imagem em memoria
        Graphics2D novaImg2D = (Graphics2D) novaImg.getGraphics();
        novaImg2D.drawImage(imgOriginal, 0, 0, null);
        //escrever frase na nova imagem
        int tamanhoFonte = imgWidth/10;
        Font novaFonte = new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFonte);
        novaImg2D.setFont(novaFonte);
        novaImg2D.setColor(Color.CYAN);

        novaImg2D.drawString("O que acha desse", 0, ((imgnewHeight - imgHeight)/2)+imgHeight);
        novaImg2D.drawString("filme?", (imgWidth)/3, (((imgnewHeight - imgHeight)/2)+imgHeight)+tamanhoFonte);

        //Escrever a imagem nova em um arquivo
        ImageIO.write(novaImg, "png", new File(nomeArquivo));
    }     
}