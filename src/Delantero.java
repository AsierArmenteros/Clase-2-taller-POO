public class Delantero extends Jugador{



    public Delantero(String nombre, int numeroGoles, int golesEncajados) {
        super(nombre, numeroGoles, golesEncajados);

    }

    public Delantero(String nombre){
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
