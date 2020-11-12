package frontOfficeP1.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;


public class PdfGenerator {
    private String chemin="rapport_file/";;
    private String rapport;

    public PdfGenerator(String ch, String ra) throws DocumentException, IOException {
        this.chemin += ch+".pdf";
        this.rapport = ra;
        ecrire();
    }

    private void ecrire() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(this.chemin));
            document.open();
            document.add(new Paragraph(this.rapport));
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        document.close();
    }
}
