

import java.io.IOException;
import java.io.PrintWriter;

public class Html{
    public void makehtml(Posicion[] posiciones) throws IOException {
        PrintWriter writer = new PrintWriter("Clasificacion.html", "UTF-8");
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Clasificacion</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Clasificacion</h1>");
        for (Posicion posicion:posiciones) {
            writer.print("<p>");
            writer.println(posicion.getPosicion() + " " + posicion.getEquipo().getNombre() + " " + posicion.getEquipo().getPuntosTotales() + " " +
                    posicion.getEquipo().getGolesAFavor() + " " + posicion.getEquipo().getGolesEnContra());
            writer.println("</p>");
        }
        writer.println("</body>");
        writer.println("</html>");
        writer.close();




    }
}
