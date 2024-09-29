package Observer.DisplayPanel;

import Elevador.Elevador;
import Observer.DisplayPanel.DisplayPanel;

public class InternalDisplayPanel extends DisplayPanel {
    public InternalDisplayPanel(Elevador elevador){
        super(elevador);
    }

    @Override
    public void atualizar(){
        System.out.println("Painel de Display Interno:");
        System.out.println("+-----------------+");
        System.out.println("| Andar Atual: " + getElevador().getAndarAtual());
        System.out.println("| Direção: " + getElevador().getDirecao());
        System.out.println("| Próximas Paradas: " + getElevador().getFilaSubida() + " " + getElevador().getFilaDescida());
        System.out.println("+-----------------+");
    }
}
