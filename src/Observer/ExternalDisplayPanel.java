package Observer;

import Elevador.Elevador;

public class ExternalDisplayPanel extends DisplayPanel{
    private int andar;

    public ExternalDisplayPanel(Elevador elevador, int andar){
        super(elevador);
        this.andar = andar;
    }
    @Override
    public void atualizar() {
        System.out.println("Painel Externo no Andar " + andar + ":");
        System.out.println("+-----------------+");
        System.out.println("| Elevador no Andar: " + getElevador().getAndarAtual());
        System.out.println("| Direção do Elevador: " + getElevador().getDirecao());
        System.out.println("+-----------------+");
    }
}
