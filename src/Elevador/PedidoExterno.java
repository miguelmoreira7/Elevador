package Elevador;

public class PedidoExterno {
    private int andar;
    private Direcao direcao;

    public PedidoExterno(int andar, Direcao direcao){
        this.andar = andar;
        this.direcao = direcao;

    }

    public int getAndar(){
        return andar;
    }
    public Direcao getDirecao(){
        return direcao;
    }
}
