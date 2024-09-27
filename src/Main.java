import Command.ChamarElevadorCommand;
import Command.IniciarProcessamentoCommand;
import Command.RequisitarAndarCommand;
import Command.Command;
import Elevador.Elevador;

public class Main {
    public static void main(String[] args) {
        Elevador elevador = Elevador.getInstancia(10);

        Command requisitarAndar10 = new RequisitarAndarCommand(elevador, 10);
        Command requisitarAndar8 = new RequisitarAndarCommand(elevador, 8);
        Command requisitarAndar6 = new RequisitarAndarCommand(elevador, 6);
        Command requisitarAndar2 = new RequisitarAndarCommand(elevador, 2);
        Command requisitarAndar7 = new RequisitarAndarCommand(elevador, 7);
        Command chamarElevador = new ChamarElevadorCommand(elevador, 1, true);
        Command iniciarProcessamento = new IniciarProcessamentoCommand(elevador);

        requisitarAndar10.executar();
        requisitarAndar8.executar();
        requisitarAndar6.executar();
        iniciarProcessamento.executar();
        requisitarAndar2.executar();
        iniciarProcessamento.executar();
        chamarElevador.executar();
        requisitarAndar7.executar();
        iniciarProcessamento.executar();
    }
}
