import com.itextpdf.text.DocumentException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Liga {


    private List<Equipo> equipos = new ArrayList<>();
    private Clasificacion clasificacion;



    public Liga() {
        this.crearEquipos();    //Crea y añade a la lista de los equipos cada equipo con los nombre que pertenecen a la clase Utils.

    }

    public void start() throws IOException, DocumentException {


        this.generarPartidos();     //Por cada equipo en la lista genera los partidos de ida y de vuelta con cada uno de los otros equipos.

        this.actualizarEquipos();   //Por cada equipo actualiza sus puntos y sus goles.

        this.clasificacion=new Clasificacion(equipos);   //Crea la clasificacion con todos los equipos.

        this.visualizar();      //Por cada equipo en la lista muestra por pantalla su nombre, los partidos totales, los ganados, los perdidos y los empatados.


    }

    private void actualizarEquipos() {
        for (Equipo equipo: this.equipos) {
            equipo.sumaPuntos();
            equipo.sumaGoles();

        }
    }


// generar todos los posibles partidos //CrearPartidos();
// realizando todas las posibles combinaciones
// de los equipos, incluyendo ida y vuelta
// asignando un resultado al azar

    private void generarPartidos() {


        for(Equipo equipoLocal : equipos ){
            for(Equipo equipoVisitante : equipos){
                if(!equipoLocal.getNombre().equalsIgnoreCase(equipoVisitante.getNombre())){
                   new Partido(equipoLocal, equipoVisitante);


                }
            }


        }


    }

    private void crearEquipos() {

        for(String nombre : Utils.nombres){
            this.equipos.add(new Equipo(nombre));
        }









    }


    public void visualizar() throws IOException, DocumentException {

        for (Equipo equipo : equipos) {
            this.visualizarNombre(equipo);// visualizar nombre el equipo
            this.visualizarTotales(equipo);// visualizar todos los partidos del equipo
            this.visualizarGanados(equipo);// visualizar partidos ganados
            this.visualizarPerdidos(equipo);// visualizar partidos perdidos
            this.visualizarEmpatados(equipo);// visualizar partidos empatados


        }
        this.visualizarClasificacion();
        this.clasificacion.asciende();
        this.clasificacion.desciende();

        this.clasificacion.pdf();
        this.clasificacion.html();
    }







    public  void visualizarNombre(Equipo equipo){
        System.out.println(equipo.getNombre());

    }

    public  void visualizarTotales(Equipo equipo) {
        System.out.println("Totales");
        for(Partido partido : equipo.getPartidosTotales()){
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());
        }
        System.out.print("\n");
    }

    public  void visualizarGanados(Equipo equipo){
        System.out.println("Ganados");

        for  (Partido partido : equipo.partidosGanados() ) {
            System.out.println(partido.getLocal().getNombre() + " " +  partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());

        }
        System.out.print("\n");


    }

    public  void visualizarEmpatados(Equipo equipo) {
        System.out.println("Empatados");

        for(Partido partido : equipo.partidosEmpatados()){
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());
        }
        System.out.print("\n");
    }

    public  void visualizarPerdidos(Equipo equipo) {
        System.out.println("Perdidos");
        for(Partido partido : equipo.partidosPerdidos()){
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());
        }
        System.out.print("\n");
    }


    public  void visualizarClasificacion(){

        clasificacion.visualizar();
    }




    }
