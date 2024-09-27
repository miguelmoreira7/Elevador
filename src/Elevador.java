import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevador {
    private static Elevador instancia;
    private int andarAtual;
    private EstadoElevador estado;
    private List<Integer> filaRequisicoes;
    private boolean subindo;

    private Elevador(int numPavimentos) {
        this.andarAtual = 0;
        this.filaRequisicoes = new ArrayList<>();
        this.estado = new ParadoState(this);
        this.subindo = true;
    }

    public static synchronized Elevador getInstancia(int numPavimentos) {
        if (instancia == null) {
            instancia = new Elevador(numPavimentos);
        }
        return instancia;
    }

    public void requisitarAndar(int andar) {
        if (!filaRequisicoes.contains(andar)) {
            filaRequisicoes.add(andar);
            System.out.println("Andar " + andar + " requisitado.");
            ordenarFila();
        }
    }

    public void chamarElevador(int andar, boolean subir) {
        if (!filaRequisicoes.contains(andar)) {
            filaRequisicoes.add(andar);
            System.out.println("Elevador chamado no andar " + andar + " para " + (subir ? "subir" : "descer") + ".");
            ordenarFila();
        }
    }

    public void iniciarProcessamento() {
        System.out.println("Iniciando o processamento da fila de requisições...");
        processarRequisicoes();
    }

    private void ordenarFila() {
        if (subindo) {
            Collections.sort(filaRequisicoes);
        } else {
            Collections.sort(filaRequisicoes, Collections.reverseOrder());
        }
    }

    private void processarRequisicoes() {
        while (!filaRequisicoes.isEmpty()) {
            int destino = filaRequisicoes.get(0);
            if (destino > andarAtual) {
                setEstado(new SubindoState(this));
            } else if (destino < andarAtual) {
                setEstado(new DescendoState(this));
            } else {
                System.out.println("Elevador chegou ao andar " + andarAtual + ". Portas abrindo...");
                filaRequisicoes.remove(0);
                System.out.println("Portas fechando...");
            }
        }
        setEstado(new ParadoState(this));
    }

    public void setEstado(EstadoElevador novoEstado) {
        this.estado = novoEstado;
        this.estado.executar();
    }

    public void moverParaAndar(int andarDestino) {
        while (andarAtual != andarDestino) {
            if (andarAtual < andarDestino) {
                andarAtual++;
            } else if (andarAtual > andarDestino) {
                andarAtual--;
            }

            exibirPainel();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!filaRequisicoes.isEmpty() && filaRequisicoes.get(0) == andarAtual) {
                System.out.println("Elevador chegou ao andar " + andarAtual + ". Portas abrindo...");
                filaRequisicoes.remove(0);
                System.out.println("Portas fechando...");
            }
        }

        if (subindo && filaRequisicoes.stream().allMatch(a -> a < andarAtual)) {
            subindo = false;
            ordenarFila();
        }

        setEstado(new ParadoState(this));
    }

    public void exibirPainel() {
        System.out.println("+-----------------+");
        System.out.print("| ");
        for (Integer andar : filaRequisicoes) {
            System.out.print(andar + " ");
        }
        System.out.println("|");
        System.out.println("+-----------------+");
        String status = (estado instanceof SubindoState) ? "subindo" : (estado instanceof DescendoState) ? "descendo" : "parado";
        System.out.println("| " + status + " [" + andarAtual + "] |");
        System.out.println("+-----------------+");
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public List<Integer> getFilaRequisicoes() {
        return filaRequisicoes;
    }
}
