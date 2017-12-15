import java.util.ArrayList;
import java.util.List;

/**
 * Created by bn0176 on 15/12/2017.
 */
public class Plantilla {

    Entrenador entrenador;
    List<Jugador> jugdores= new ArrayList<Jugador>();


    public Plantilla(Entrenador entrenador, List<Jugador> jugdores) {
        this.entrenador = entrenador;
        this.jugdores = jugdores;
    }

    public Plantilla(int i) {
        this.jugdores.add(new Portero(Utils.nombrePorteros[i]));
        this.jugdores.add(new Defensa(Utils.nombresDefesas[i]));
        this.jugdores.add(new Delantero(Utils.nombresDelanteros[i]));
        this.jugdores.add(new Medio(Utils.nombresMedios[i]));
        this.entrenador=new Entrenador(Utils.nombresEntrenador[i]);



    }

    public void actualizaJugadores(int golesEnContra, int golesAFavor) {

        int i=1;

        while(i<=jugdores.size()){

            int randomJugador=(int) Math.floor(Math.random()*jugdores.size());

            if(jugdores.get(randomJugador).pichichi()) {
                jugdores.get(randomJugador).sumaUnGol();
                i++;
            }

        }
        i=1;
        while(i<=jugdores.size()){

            int randomJugador=(int) Math.floor(Math.random()*jugdores.size());

            if(jugdores.get(randomJugador).zamora()) {
                jugdores.get(randomJugador).encajaUnGol();
                i++;
            }

        }




    }
}
