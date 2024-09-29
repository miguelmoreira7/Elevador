package Command;

import Elevador.Elevador;
import Elevador.Direcao;

public class RequisitarDescerCommand implements Command {
    private Elevador elevador;
    private int andar;

    public RequisitarDescerCommand(Elevador elevador, int andar) {
        this.elevador = elevador;
        this.andar = andar;
    }

    @Override
    public void executar() {
        if (andar > 0) {
            elevador.addRequisicaoExterna(andar, Direcao.descendo);
        } else {
            System.out.println("Você já está no térreo.");
        }
    }
}
