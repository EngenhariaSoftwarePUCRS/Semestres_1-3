
// Importing the Java classes for handling Files and their Exceptions
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
// Importing the required classes of Apache POI   
import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

public class ReadPDFFile {
    public static void main(String args[]) throws Exception, IOException, SAXException, TikaException {
        BodyContentHandler bodyContentHandler = new BodyContentHandler();
        File file = new File("../Veiculos Montadora - Termo de Abertura do Projeto.pdf");
        FileInputStream fileInputStream = new FileInputStream(file);
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();
        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(fileInputStream, bodyContentHandler, metadata, parseContext);
        String textContent = bodyContentHandler.toString();
        System.out.println("Document Metadata: ");
        String[] metadatas = metadata.names();
        for (String data : metadatas)
            System.out.println(data + ":   " + metadata.get(data));
        System.out.println("Extracting the contents from the file: \n" + textContent);
    }
}
