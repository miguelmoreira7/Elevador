package Observer;

import Elevador.Elevador;

public class DisplayPanel implements Observer{
    private Elevador elevador;

    public DisplayPanel(Elevador elevador){
        this.elevador = elevador;
        elevador.attatchObeserver(this);
    }

    public void atualizar(){
        System.out.println("+-----------------+");
        System.out.println("| Fila: " + elevador.getFilaRequisicoes());
        System.out.println("+-----------------+");
        System.out.println("| " + elevador.getDirecao() + " [ " + elevador.getAndarAtual() + " ]");
        System.out.println("+-----------------+");
    }
}
