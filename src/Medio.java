public class Medio extends Jugador {


    public Medio(String nombre, int numeroGoles, int golesEncajados) {
        super(nombre, numeroGoles, golesEncajados);

    }


    public Medio(String nombre){
        super(nombre, 0, 0);


    }
    @Override
    public boolean pichichi() {
        return true;
    }


    @Override
    public boolean zamora() {
        return false;
    }

}
