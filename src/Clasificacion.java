import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

public class Clasificacion {


    private Posicion[]  posiciones;





    public Clasificacion(List<Equipo> equipos) {
        posiciones=new Posicion[equipos.size()];
        posicionar(equipos);


    }





    public void posicionar(List<Equipo> equipos){

        Equipo[] equiposAOrdenar = new Equipo[equipos.size()];  //Array auxiliar con los equipos
        equiposAOrdenar=equipos.toArray(equiposAOrdenar);

        //Algoritmo de Inserccion


        Equipo aux;

        for (int i = 0; i <equiposAOrdenar.length ; i++) {
                int k=i;
            for (int j = i+1; j <equiposAOrdenar.length ; j++) {

                if(equiposAOrdenar[j].getPuntosTotales()>equiposAOrdenar[k].getPuntosTotales()){
                    k=j;

                }

            }
            aux=equiposAOrdenar[i];
            equiposAOrdenar[i]=equiposAOrdenar[k];
            equiposAOrdenar[k]=aux;
            posiciones[i] = new Posicion(equiposAOrdenar[i], i+1);
        }




    }


    public void visualizar(){

        for (int i = 0; i <posiciones.length ; i++) {
            System.out.println(posiciones[i].getPosicion() + " " + posiciones[i].getEquipo().getNombre() + " " + posiciones[i].getEquipo().getPuntosTotales() + " " );

        }

    }



    public void asciende(){
        System.out.println("\n Ascienden:");
        for (int i = 0; i <3 ; i++) {
            System.out.println(posiciones[i].getEquipo().getNombre());
        }


    }


    public void desciende(){
        System.out.println("\nDescienden:");
        for (int i = posiciones.length-3; i <posiciones.length; i++) {
            System.out.println(posiciones[i].getEquipo().getNombre());
        }


    }



    public void pdf() throws IOException, DocumentException {
        Pdf archivo = new Pdf();
        archivo.createPdf("Prueba.pdf", posiciones);



    }
    public void html() throws IOException {
        Html html=new Html();
        html.makehtml(posiciones);
    }
}























