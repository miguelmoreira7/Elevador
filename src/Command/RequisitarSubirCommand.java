package Command;

import Elevador.Elevador;
import Elevador.Direcao;

public class RequisitarSubirCommand implements Command {
    private Elevador elevador;
    private int andar;

    public RequisitarSubirCommand(Elevador elevador, int andar) {
        this.elevador = elevador;
        this.andar = andar;
    }

    @Override
    public void executar() {
        if (andar < elevador.getNumPavimentos()) {
            elevador.addRequisicaoExterna(andar, Direcao.subindo);
        } else {
            System.out.println("Você já está no último andar.");
        }
    }

}