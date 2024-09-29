
import Elevador.*;
import Factory.*;
import Observer.DisplayPanel;

public class Main {
    public static void main(String[] args) {
        int numPavimentos = 4;
        Elevador elevador = Elevador.getInstancia(numPavimentos);

        Painel painel = new Painel(elevador);

        DisplayPainelFactory DisplayPainelFactory = new DisplayPainelFactoryConcreta();
        DisplayPanel internalDisplayPanel = DisplayPainelFactory.createInternalDisplayPanel(elevador);

//        DisplayPanel[] externalDisplayPanels = new DisplayPanel[numPavimentos + 1];
//        for (int i = 0; i <= numPavimentos; i++) {
//            externalDisplayPanels[i] = DisplayPainelFactory.createExternalDisplayPanel(elevador, i);
//        }
//
//        PainelExterno[] paineisExternos = new PainelExterno[numPavimentos + 1];
//        for (int i = 0; i <= numPavimentos; i++) {
//            paineisExternos[i] = new PainelExterno(i, elevador);
//        }

        //OBSERVER POLUI O TERMINAL
//        DisplayPanel externalDisplayPanel = DisplayPainelFactory.createExternalDisplayPanel(elevador, 2);
        PainelExterno painelExterno = new PainelExterno(2 , elevador);

        painel.apertarBotao(3);
        painel.apertarBotao(1);
        painel.apertarBotao(4);
        painel.apertarBotao(11);
        painelExterno.apertarBotaoSubir();
        painelExterno.apertarBotaoDescer();
        elevador.executar();
        painel.apertarBotao(3);
        elevador.executar();

    }
}
