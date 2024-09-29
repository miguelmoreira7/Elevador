package Elevador.Painel;

import Command.*;
import Elevador.*;

public class PainelExterno extends Painel {
    private static int SUBIR = 1000;
    private static int DESCER = 1001;

    public PainelExterno(Elevador elevador, int andar) {
        super(elevador, andar);
    }

    @Override
    protected void initializeCommands() {
        comandos.put(SUBIR, new RequisitarSubirCommand(elevador, andar));
        comandos.put(DESCER, new RequisitarDescerCommand(elevador, andar));
    }

}
