package State;
import Elevador.Elevador;

public class SubindoState implements EstadoElevador {
    private Elevador elevador;

    public SubindoState(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void executar() {
        System.out.println("Elevador subindo...");
        int destino = elevador.getFilaRequisicoes().get(0);
        elevador.moverParaAndar(destino);
    }
}
