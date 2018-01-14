public class Lateral extends Jugador {



    public Lateral(String nombre, int numeroGoles, int golesEncajados) {
        super( nombre,   numeroGoles, golesEncajados);

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
