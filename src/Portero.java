public class Portero extends Jugador{



    private int golesEncajados;

    public Portero(String nombre, int numeroGoles, int golesEncajados){

        super(nombre, numeroGoles, golesEncajados);
        this.golesEncajados=golesEncajados;

    }
    public Portero(String nombre){
        super(nombre, 0, 0);


    }

    @Override
    public boolean pichichi() {
        return false;
    }

    @Override
    public boolean zamora() {
        return true;
    }
}
