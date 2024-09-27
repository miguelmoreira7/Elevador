public class AcionarAndarCommand implements ComandoElevador {
    private Elevador elevador;
    private int andar;

    public AcionarAndarCommand(Elevador elevador, int andar) {
        this.elevador = elevador;
        this.andar = andar;
    }

    @Override
    public void executar() {
//        elevador.requisitarAndar(andar);
    }
}