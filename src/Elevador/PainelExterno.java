package Elevador;

public class PainelExterno {
    private int andar;
    private Elevador elevador;

    public PainelExterno(int andar, Elevador elevador){
        this.andar = andar;
        this.elevador = elevador;
    }

    public void apertarBotaoSubir(){
        if (andar < elevador.getNumPavimentos()){
            elevador.addRequisicaoExterna(andar, Direcao.subindo);
        }else {
            System.out.println("Você já está no último andar.");
        }
    }
    public void apertarBotaoDescer() {
        if (andar > 0) {
            elevador.addRequisicaoExterna(andar, Direcao.descendo);
        } else {
            System.out.println("Você já está no térreo.");
        }
    }
}
