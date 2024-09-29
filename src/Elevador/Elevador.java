package Elevador;

import Observer.DisplayPanel;
import Observer.Observer;
import State.DescendoState;
import State.EstadoElevador;
import State.ParadoState;
import State.SubindoState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevador {
    private static Elevador instancia;
    private int andarAtual;
    private EstadoElevador estado;
    private List<Integer> filaRequisicoes;
    private Direcao direcao;
    private Porta portas;
    private List<Observer> observers;
    private int numPavimentos;

    private Elevador(int numPavimentos) {
        this.andarAtual = 0;
        this.filaRequisicoes = new ArrayList<>();
        this.estado = new ParadoState();
        this.direcao = Direcao.parado;
        this.portas = new Porta();
        this.observers = new ArrayList<>();
        this.numPavimentos = numPavimentos;
    }

    public static Elevador getInstancia(int numPavimentos) {
        if (instancia == null) {
            instancia = new Elevador(numPavimentos);
        }
        return instancia;
    }

    public int getNumPavimentos() {
        return numPavimentos;
    }
    public Direcao getDirecao(){return direcao;}
    public void setDirecao(Direcao direcao){
        this.direcao = direcao;
    }


    public int getAndarAtual() {return andarAtual;}
    public void setAndarAtual(int andarAtual) {this.andarAtual = andarAtual;}

    public List<Integer> getFilaRequisicoes() {
        return filaRequisicoes;
    }

    public void setEstado(EstadoElevador novoEstado) {
        this.estado = novoEstado;
    }


    public void requisitarAndar(int andar) {
        if (andar < 0 || andar > numPavimentos) {
            System.out.println("Andar inválido: " + andar);
            return;
        }
        if (!filaRequisicoes.contains(andar) && andar != andarAtual) {
            filaRequisicoes.add(andar);
            System.out.println("Andar " + andar + " requisitado.");
        }
        notifyObservers();
    }


    public void abrirPortas(){portas.abrir();}
    public void fecharPortas(){
        portas.fechar();
    }





//    public void moverParaAndar(int andarDestino) {
//        while (andarAtual != andarDestino) {
//            if (andarAtual < andarDestino) {
//                andarAtual++;
//            } else if (andarAtual > andarDestino) {
//                andarAtual--;
//            }
//
//            exibirPainel();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            if (!filaRequisicoes.isEmpty() && filaRequisicoes.get(0) == andarAtual) {
//                System.out.println("Elevador chegou ao andar " + andarAtual + ". Portas abrindo...");
//                filaRequisicoes.remove(0);
//                setEstado(new ParadoState(this));
//                System.out.println("Portas fechando...");
//            }
//        }
//
//        if (subindo && filaRequisicoes.stream().allMatch(a -> a < andarAtual)) {
//            subindo = false;
//            ordenarFila();
//        }

//        setEstado(new ParadoState(this));
//    }


    public void executar() {
        while (!filaRequisicoes.isEmpty()) {
            int destino = filaRequisicoes.get(0);
            if (destino > andarAtual) {
                setEstado(new SubindoState());
            } else if (destino < andarAtual) {
                setEstado(new DescendoState());
            }
            estado.executar(this);
            if (andarAtual == destino) {
                setEstado(new ParadoState());
                estado.executar(this);
                filaRequisicoes.remove(0);
            }
            notifyObservers();
        }
        setEstado(new ParadoState());
        direcao = Direcao.parado;
        System.out.println("Sem mais pedidos, Elevador parado no andar: " + andarAtual);
        notifyObservers();
    }

    public void attatchObeserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.atualizar();
        }
    }

}
