public class DescendoState implements EstadoElevador {
    private Elevador elevador;

    public DescendoState(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void executar() {
        System.out.println("Elevador descendo...");
        int destino = elevador.getFilaRequisicoes().get(0);  // Usa get(0) para pegar o primeiro elemento da lista
        elevador.moverParaAndar(destino);
    }
}