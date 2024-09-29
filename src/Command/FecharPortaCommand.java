package Command;
import Elevador.Elevador;
public class FecharPortaCommand implements Command{
    private Elevador elevador;

    public FecharPortaCommand(Elevador elevador) {
        this.elevador = elevador;
    }
    @Override
    public void executar() {elevador.fecharPortas();}
}
