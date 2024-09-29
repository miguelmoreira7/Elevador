package Observer;

import Elevador.Elevador;

public abstract class DisplayPanel implements Observer{
    private Elevador elevador;

    public Elevador getElevador(){
        return elevador;
    }

    public DisplayPanel(Elevador elevador){
        this.elevador = elevador;
        elevador.attatchObeserver(this);
    }

    public abstract void atualizar();
}
