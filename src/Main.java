
import Command.*;
import Elevador.*;
import Observer.DisplayPanel;

public class Main {
    public static void main(String[] args) {
        Elevador elevator = Elevador.getInstancia(10);
        DisplayPanel displayPanel = new DisplayPanel(elevator);

        Painel painel = new Painel(elevator);

        painel.apertarBotao(1);
        painel.apertarBotao(2);
        painel.apertarBotao(3);
        painel.apertarBotao(4);
        painel.apertarBotao(9);
        painel.apertarBotao(11);
        elevator.executar();
        painel.apertarBotao(101);

    }
}
