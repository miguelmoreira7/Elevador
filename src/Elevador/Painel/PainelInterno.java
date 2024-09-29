package Elevador.Painel;

import Command.*;
import Elevador.*;



public class PainelInterno extends Painel {

    public PainelInterno(Elevador elevador) {
        super(elevador, null);
    }

    @Override
    protected void initializeCommands() {
        for (int andar = 0; andar <= elevador.getNumPavimentos(); andar++) {
            comandos.put(andar, new RequisitarAndarCommand(elevador, andar));
        }
    }
}
