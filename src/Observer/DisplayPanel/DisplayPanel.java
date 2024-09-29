package Observer.DisplayPanel;

import Elevador.Elevador;
import Observer.Observer;

public abstract class DisplayPanel implements Observer {
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
