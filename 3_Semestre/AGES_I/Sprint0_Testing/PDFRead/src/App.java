import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.Rectangle;
import org.apache.pdfbox.pdmodel.PDPage;

public class App {
    public static void main(String[] args) {
        try {
            PDDocument document = PDDocument
                    .load(new File("../Veiculos Montadora - Termo de Abertura do Projeto.pdf"));

            if (document.isEncrypted())
                throw new Exception("File is encrypted");

            PDFTextStripper stripper = new PDFTextStripper();
            PDFTextStripperByArea areaStripper = new PDFTextStripperByArea();
            areaStripper.setSortByPosition(true);
            String text = stripper.getText(document);
            System.out.println("PDF Content: " + text);

            // PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            // stripper.setSortByPosition(true);
            // Rectangle rect = new Rectangle(10, 280, 275, 60);
            // stripper.addRegion("class1", rect);
            // PDPage firstPage = document.getPage(0);
            // stripper.extractRegions(firstPage);
            // System.out.println("Text in the area:" + rect);
            // System.out.println(stripper.getTextForRegion("class1"));

            document.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
