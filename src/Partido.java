

public class Partido {

    private int golesLocal;
    private int golesVisitante;
    private Equipo local;
    private Equipo visitante;

    public Equipo getLocal() {
        return local;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public Equipo getVisitante() {
        return visitante;

    }

    public Partido(Equipo local, Equipo visitante) {
        this.local=local;
        this.visitante=visitante;


        golesLocal=(int) Math.floor(Math.random() * 5);
        golesVisitante=(int) Math.floor(Math.random()*5);

        this.local.addPartido(this);
        this.visitante.addPartido(this);



    }


    public Equipo ganador(){
        if(golesLocal>golesVisitante){
            return local;
        }
        else if(golesLocal<golesVisitante){
            return visitante;
        }
        else return null;

    }



}
