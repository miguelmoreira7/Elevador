package State;
import Elevador.*;

public class ParadoState implements EstadoElevador {

    @Override
    public void executar(Elevador elevador) {
        elevador.setDirecao(Direcao.parado);
        elevador.abrirPortas();
        System.out.println("Elevador está parado no andar " + elevador.getAndarAtual());
    }
}