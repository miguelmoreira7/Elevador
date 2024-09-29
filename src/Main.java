
import Elevador.*;
import Elevador.Painel.Painel;
import Elevador.Painel.PainelExterno;
import Elevador.Painel.PainelInterno;
import Factory.*;
import Observer.DisplayPanel.DisplayPanel;

public class Main {
    private static final int BOTAO_SUBIR = 1000;
    private static final int BOTAO_DESCER = 1001;

    public static void main(String[] args) {
        int numPavimentos = 4;
        Elevador elevador = Elevador.getInstancia(numPavimentos);


        //Painel de comandos
        Painel painelInterno = new PainelInterno(elevador);

        PainelExterno[] paineisExternos = new PainelExterno[numPavimentos + 1];
        for (int i = 0; i <= numPavimentos; i++) {
            paineisExternos[i] = new PainelExterno(elevador, i);
        }

        //Painel de Display
        DisplayPainelFactory DisplayPainelFactory = new DisplayPainelFactoryConcreta();

        DisplayPanel internalDisplayPanel = DisplayPainelFactory.createInternalDisplayPanel(elevador);

//        DisplayPanel[] externalDisplayPanels = new DisplayPanel[numPavimentos + 1];
//        for (int i = 0; i <= numPavimentos; i++) {
//            externalDisplayPanels[i] = DisplayPainelFactory.createExternalDisplayPanel(elevador, i);
//        }


        //OBSERVER POLUI O TERMINAL
//        DisplayPanel externalDisplayPanel = DisplayPainelFactory.createExternalDisplayPanel(elevador, 2);

        painelInterno.apertarBotao(3);
        painelInterno.apertarBotao(1);
        painelInterno.apertarBotao(4);
        painelInterno.apertarBotao(11);
        System.out.println("***************************************");
        paineisExternos[3].apertarBotao(BOTAO_SUBIR);
        paineisExternos[1].apertarBotao(BOTAO_DESCER);
        elevador.executar();
        System.out.println("***************************************");
        painelInterno.apertarBotao(3);
        elevador.executar();
        System.out.println("***************************************");

    }
}
