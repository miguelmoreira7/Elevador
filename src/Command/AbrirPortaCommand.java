package Command;

import Elevador.Elevador;

public class AbrirPortaCommand implements Command{
    private Elevador elevador;

    public AbrirPortaCommand(Elevador elevador){
        this.elevador = elevador;
    }

    @Override
    public void executar(){
        elevador.abrirPortas();
    }
}
