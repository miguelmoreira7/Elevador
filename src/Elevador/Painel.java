package Elevador;

import Command.*;

import java.util.HashMap;
import java.util.Map;

public class Painel {
    private Map<Integer,Command> commands = new HashMap<>();


    public Painel(Elevador elevador){
        initializeCommands(elevador);
    }

    public void setComandos(int botao, Command comando){
        commands.put(botao, comando);
    }

    private void initializeCommands(Elevador elevador) {
        for (int andar = 0; andar <= elevador.getNumPavimentos(); andar++) {
            commands.put(andar, new RequisitarAndarCommand(elevador, andar));
        }

        commands.put(100, new AbrirPortaCommand(elevador));
        commands.put(101, new FecharPortaCommand(elevador));
    }

    public void apertarBotao(int botao){
        Command command = commands.get(botao);

        if (command != null){
            command.executar();
        } else {
            System.out.println("Botao invalido");
        }
    }
}
