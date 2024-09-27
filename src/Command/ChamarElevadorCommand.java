package Command;
import Elevador.Elevador;

public class ChamarElevadorCommand implements Command {
    private Elevador elevador;
    private int andar;
    private boolean subir;

    public ChamarElevadorCommand(Elevador elevador, int andar, boolean subir) {
        this.elevador = elevador;
        this.andar = andar;
        this.subir = subir;
    }

    @Override
    public void executar() {
        elevador.chamarElevador(andar, subir);
    }
}
