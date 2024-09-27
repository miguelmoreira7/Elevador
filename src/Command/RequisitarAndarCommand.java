package Command;
import Elevador.Elevador;

public class RequisitarAndarCommand implements Command {
    private Elevador elevador;
    private int andar;

    public RequisitarAndarCommand(Elevador elevador, int andar) {
        this.elevador = elevador;
        this.andar = andar;
    }

    @Override
    public void executar() {
        elevador.requisitarAndar(andar);
    }
}
