package State;
import Elevador.*;

public class DescendoState implements EstadoElevador {

    @Override
    public void executar(Elevador elevador) {
        elevador.setDirecao(Direcao.descendo);
        elevador.fecharPortas();
        System.out.println("Elevador descendo...");
        elevador.setAndarAtual(elevador.getAndarAtual() - 1);
    }
}