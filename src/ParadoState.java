public class ParadoState implements EstadoElevador {
    private Elevador elevador;

    public ParadoState(Elevador elevador) {
        this.elevador = elevador;
    }

    @Override
    public void executar() {
        System.out.println("Elevador está parado no andar " + elevador.getAndarAtual());
        // Não faz nada. Fica aguardando até que uma nova requisição seja adicionada.
    }
}