
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

import java.io.*;


public class Pdf {




    public void createPdf(String dest, Posicion[] posiciones) throws DocumentException, IOException {

        Document document = new Document();
        PdfWriter.getInstance(
                document, new FileOutputStream(dest));
        document.open();
        for (Posicion posicion:posiciones) {

            document.add(new Paragraph(posicion.getPosicion() + " " + posicion.getEquipo().getNombre() + " " + posicion.getEquipo().getPuntosTotales() + " " +
            posicion.getEquipo().getGolesAFavor() + " " + posicion.getEquipo().getGolesEnContra()));

        }

        document.close();

    }



}
