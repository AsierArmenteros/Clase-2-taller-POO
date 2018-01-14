import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Text {
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public void createTxt(Posicion[] posiciones) {
        this.createTextAsciende(posiciones);
        this.createTextDesciede(posiciones);
    }

    private void createTextDesciede(Posicion[] posiciones) {
        try {
            fileWriter = new FileWriter("Desciende.txt");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println("Equipos que descienden de categoria:\n");
            for (int i = posiciones.length - 2; i < posiciones.length; i++) {
                printWriter.println(posiciones[i].getEquipo().getNombre());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void createTextAsciende(Posicion[] posiciones) {
        try {
            fileWriter = new FileWriter("Asciende.txt");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println("Equipos que ascienden a Europa:\n");
            for (int i = 0; i < 2; i++) {
                printWriter.println(posiciones[i].getEquipo().getNombre());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
