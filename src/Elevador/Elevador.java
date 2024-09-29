package Elevador;

import Observer.Observer;
import State.DescendoState;
import State.EstadoElevador;
import State.ParadoState;
import State.SubindoState;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Elevador {
    private static Elevador instancia;
    private int andarAtual;
    private EstadoElevador estado;
    private Direcao direcao;
    private Porta portas;
    private List<Observer> observers;
    private int numPavimentos;
    private PriorityQueue<Integer> filaSubida;
    private PriorityQueue<Integer> filaDescida;
    private List<PedidoExterno> pedidosExternos;

    private Elevador(int numPavimentos) {
        this.andarAtual = 0;
        this.estado = new ParadoState();
        this.direcao = Direcao.parado;
        this.portas = new Porta();
        this.observers = new ArrayList<>();
        this.numPavimentos = numPavimentos;

        this.filaSubida = new PriorityQueue<>();
        this.filaDescida = new PriorityQueue<>();
        this.pedidosExternos = new ArrayList<>();
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


    public void setEstado(EstadoElevador novoEstado) {
        this.estado = novoEstado;
    }


    public void requisitarAndar(int andar) {
        if (andar < 0 || andar > numPavimentos) {
            System.out.println("Andar inválido: " + andar);
            return;
        }
        if (andar == andarAtual) {
            System.out.println("Voce ja esta no andar");
        }
        if (andar > andarAtual){
            if (!filaSubida.contains(andar)){
                filaSubida.add(andar);
                System.out.println("Andar " + andar + " adicionado à fila ascendente.");
            }
        } else {
          if (!filaDescida.contains(andar)){
              filaDescida.add(andar);
              System.out.println("Andar " + andar + " adicionado à fila descendente.");
          }
        }
        notifyObservers();
    }

    public void addRequisicaoExterna(int andar, Direcao direcao){
        if (andar < 0 || andar > numPavimentos){
            System.out.println("Andar inválido: " + andar);
        }
        PedidoExterno pedido = new PedidoExterno(andar, direcao);
        if(!pedidosExternos.contains(pedido)){
            pedidosExternos.add(pedido);
            System.out.println("Requisição externa adicionada: Andar " + andar + " solicitando " + direcao);
        }
        if (direcao == Direcao.subindo) {
            if (!filaSubida.contains(andar)) {
                filaSubida.add(andar);
            }
        } else if (direcao == Direcao.descendo) {
            if (!filaDescida.contains(andar)) {
                filaDescida.add(andar);
            }
        }
        notifyObservers();
    }


    public void abrirPortas(){portas.abrir();}
    public void fecharPortas(){
        portas.fechar();
    }


    public void executar() {
        while (!filaSubida.isEmpty() || !filaDescida.isEmpty() || !pedidosExternos.isEmpty()) {
            if (direcao == Direcao.subindo || direcao == Direcao.parado){
                atenderRequisicaoSubindo();
                if(!filaDescida.isEmpty()){
                    direcao = Direcao.descendo;
                    atenderRequisicaoDescendo();
                }
            } else if (direcao == Direcao.descendo){
                atenderRequisicaoDescendo();
                if (!filaSubida.isEmpty()){
                    direcao = Direcao.subindo;
                    atenderRequisicaoSubindo();
                }
            }
            if (filaSubida.isEmpty() && filaDescida.isEmpty()) {
                direcao = Direcao.parado;
                setEstado(new ParadoState());
                estado.executar(this);
                notifyObservers();
            }
        }
        System.out.println("Sem mais pedidos, Elevador parado no andar: " + andarAtual);
    }

    public void attatchObeserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.atualizar();
        }
    }
    private void atenderRequisicaoSubindo() {
        direcao = Direcao.subindo;
        while (!filaSubida.isEmpty()) {
            int destino = filaSubida.poll();
            while (andarAtual < destino) {
                setEstado(new SubindoState());
                estado.executar(this);
                notifyObservers();
            }

            setEstado(new ParadoState());
            estado.executar(this);
            notifyObservers();
            removerRequisicaoExterna(andarAtual);
        }
    }

    private void atenderRequisicaoDescendo() {
        direcao = Direcao.descendo;
        while (!filaDescida.isEmpty()) {
            int destino = filaDescida.poll();
            while (andarAtual > destino) {
                setEstado(new DescendoState());
                estado.executar(this);
                notifyObservers();
            }
            setEstado(new ParadoState());
            estado.executar(this);
            notifyObservers();
            removerRequisicaoExterna(andarAtual);
        }
    }

    private void removerRequisicaoExterna(int andar) {
        pedidosExternos.removeIf(req -> req.getAndar() == andar);
    }

    public PriorityQueue<Integer> getFilaSubida() {
        return filaSubida;
    }

    public List<PedidoExterno> getPedidosExternos() {
        return pedidosExternos;
    }

    public PriorityQueue<Integer> getFilaDescida() {
        return filaDescida;
    }
}
