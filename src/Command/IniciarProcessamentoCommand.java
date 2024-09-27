package Command;
import Elevador.Elevador;

public class IniciarProcessamentoCommand implements Command {
    private Elevador elevador;

    public IniciarProcessamentoCommand(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void executar() {
        elevador.iniciarProcessamento();
    }
}
