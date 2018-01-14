public class Defensa extends Jugador {


    public Defensa(String nombre, int numeroGoles, int golesEncajados) {
        super(nombre, numeroGoles, golesEncajados);

    }


    public Defensa(String nombre){
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
