import java.util.ArrayList;
import java.util.List;



public class Equipo {

    private String nombre;

    private Plantilla plantilla;


    private int puntosTotales=0;
    private int golesAFavor=0;
    private int golesEnContra=0;




    private List<Partido> partidosTotales= new ArrayList<>();

    public List<Partido> getPartidosTotales() {
        return partidosTotales;
    }


    public Equipo(String nombre, Plantilla plantilla) {
        this.nombre=nombre;
        this.plantilla=plantilla;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }







    public void sumaGoles(){

        for (Partido partido: this.partidosTotales) {


            if (partido.getLocal() == this) {
                this.golesAFavor += partido.getGolesLocal();
                this.golesEnContra += partido.getGolesVisitante();
            } else {
                this.golesAFavor += partido.getGolesVisitante();
                this.golesEnContra += partido.getGolesLocal();
            }
        }
    }

    public ArrayList<Partido> partidosGanados(){

        ArrayList <Partido> ganados = new ArrayList<>();

        for(Partido partido : this.partidosTotales) {
            if (partido.ganador() == this) {
                ganados.add(partido);

            }
        }

        return ganados;
    }



    public ArrayList<Partido> partidosPerdidos(){
        ArrayList <Partido> perdidos = new ArrayList<>();

        for(Partido partido : this.partidosTotales) {
            if (partido.ganador() != this && partido.ganador()!=null) {
                perdidos.add(partido);

            }
        }

        return perdidos;


    }




    public ArrayList<Partido> partidosEmpatados() {

        ArrayList<Partido> empatados = new ArrayList<>();

        for (Partido partido : this.partidosTotales) {
            if (partido.ganador() == null) {
                empatados.add(partido);

            }
        }

        return empatados;
    }


    public void addPartido(Partido partido) {
        this.partidosTotales.add(partido);
    }



    public void sumaPuntos(){

        for (Partido partido: this.partidosTotales) {
            if (partido.ganador()==this){
                this.puntosTotales+=3;
            }
            else if(partido.ganador()==null){
                this.puntosTotales+=1;

            }

        }

    }
    public void actualizaJugadores(){
        this.plantilla.actualizaJugadores(this.golesEnContra, this.golesAFavor);

    }
}





