package State;
import Elevador.*;

public class SubindoState implements EstadoElevador {

    @Override
    public void executar(Elevador elevador) {
        elevador.setDirecao(Direcao.subindo);
        elevador.fecharPortas();
        System.out.println("Elevador subindo...");
        elevador.setAndarAtual(elevador.getAndarAtual() + 1);
    }
}
