/**
 * Created by bn0176 on 15/12/2017.
 */
public abstract class Jugador {

    String nombre;
    int numeroGoles;
    int golesEncajados;

    public Jugador(String nombre, int numeroGoles, int golesEncajados) {
        this.nombre = nombre;
        this.numeroGoles = numeroGoles;
        this.golesEncajados=golesEncajados;
    }

    public abstract boolean pichichi();
    public abstract boolean zamora();

    public void sumaUnGol(){
        this.numeroGoles++;

    }
    public void encajaUnGol(){
        this.golesEncajados++;
    }






}
