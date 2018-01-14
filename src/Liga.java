import com.itextpdf.text.DocumentException;

import java.util.ArrayList;
import java.util.List;


public class Liga {


    private List<Equipo> equipos = new ArrayList<>();
    private Clasificacion clasificacion;


    public Liga() {
        this.crearEquipos();    //Crea y añade a la lista de los equipos cada equipo con los nombre que pertenecen a la clase Utils.

    }

    public void start() throws DocumentException {


        this.generarPartidos();     //Por cada equipo en la lista genera los partidos de ida y de vuelta con cada uno de los otros equipos.

        this.actualizarEquipos();   //Por cada equipo actualiza sus puntos y sus goles.

        this.clasificacion = new Clasificacion(equipos);   //Crea la clasificacion con todos los equipos.

        this.visualizar();      //Por cada equipo en la lista muestra por pantalla su nombre, los partidos totales, los ganados, los perdidos y los empatados.


    }

    private void actualizarEquipos() {
        for (Equipo equipo : this.equipos) {
            try {
                equipo.sumaPuntos();
                if (equipo.getPuntosTotales() > 6 * (equipos.size() - 1)) {
                    throw new MaxPuntosException("Se ha excedido el número maximo de puntos que un equipo puede consegir.");
                }
            } catch (MaxPuntosException e) {
                equipo.setPuntosTotales(0);
                equipo.sumaPuntos();
                e.printStackTrace();
            }
            equipo.sumaGoles();

        }
    }


// generar todos los posibles partidos //CrearPartidos();
// realizando todas las posibles combinaciones
// de los equipos, incluyendo ida y vuelta
// asignando un resultado al azar

    private void generarPartidos() {


        for (Equipo equipoLocal : equipos) {
            for (Equipo equipoVisitante : equipos) {
                if (!equipoLocal.getNombre().equalsIgnoreCase(equipoVisitante.getNombre())) {
                    new Partido(equipoLocal, equipoVisitante);


                }
            }


        }


    }

    private void crearEquipos() {
        try {
            int i = 0;
            for (String nombre : Utils.nombres) {
                if (i > 4) {
                    throw new MaxEquiposException("Has superado el número máximo de equipos, solo se tendrán en cuenta lo cinco primeros suministrados.");
                }
                this.equipos.add(new Equipo(nombre, new Plantilla(i)));
                i++;

            }

        } catch (MaxEquiposException e) {
            e.printStackTrace();

        }


    }


    public void visualizar() {

        for (Equipo equipo : equipos) {
            this.visualizarNombre(equipo);// visualizar nombre el equipo
            this.visualizarTotales(equipo);// visualizar todos los partidos del equipo
            this.visualizarGanados(equipo);// visualizar partidos ganados
            this.visualizarPerdidos(equipo);// visualizar partidos perdidos
            this.visualizarEmpatados(equipo);// visualizar partidos empatados


        }
        System.out.println("==============================\n");
        this.visualizarClasificacion();
        this.clasificacion.asciende();
        this.clasificacion.desciende();

        this.clasificacion.pdf();
        this.clasificacion.html();
        this.clasificacion.text();
        this.clasificacion.posicionarPorDiferencia(equipos);
        this.clasificacion.visualizarPorDiferencia();
    }


    public void visualizarNombre(Equipo equipo) {
        System.out.println("******************************");
        System.out.println("\033[34m"+equipo.getNombre()+"\033[38m");
        System.out.println("******************************\n");

    }

    public void visualizarTotales(Equipo equipo) {
        System.out.println("Totales\n");
        for (Partido partido : equipo.getPartidosTotales()) {
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());
        }
        System.out.print("\n");
    }

    public void visualizarGanados(Equipo equipo) {
        System.out.println("Ganados\n");

        for (Partido partido : equipo.partidosGanados()) {
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());

        }
        System.out.print("\n");


    }

    public void visualizarEmpatados(Equipo equipo) {
        System.out.println("Empatados\n");

        for (Partido partido : equipo.partidosEmpatados()) {
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());
        }
        System.out.print("\n");
    }

    public void visualizarPerdidos(Equipo equipo) {
        System.out.println("Perdidos\n");
        for (Partido partido : equipo.partidosPerdidos()) {
            System.out.println(partido.getLocal().getNombre() + " " + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " + partido.getVisitante().getNombre());
        }
        System.out.print("\n");
    }


    public void visualizarClasificacion() {

        clasificacion.visualizar();
    }


}
