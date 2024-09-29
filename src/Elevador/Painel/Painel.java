package Elevador.Painel;

import Command.*;
import Elevador.Elevador;

import java.util.HashMap;
import java.util.Map;

public abstract class Painel {
    protected Map<Integer, Command> comandos = new HashMap<>();
    protected Elevador elevador;
    protected Integer andar;
    public Painel(Elevador elevador, Integer andar) {
        this.elevador = elevador;
        this.andar = andar;
        initializeCommands();
    }

    protected abstract void initializeCommands();

    public void apertarBotao(int codigo) {
        Command comando = comandos.get(codigo);
        if (comando != null) {
            comando.executar();
        } else {
            System.out.println("Botão inválido: " + codigo);
        }
    }
}
