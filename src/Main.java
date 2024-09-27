public class Main {
    public static void main(String[] args) {
        Elevador elevador = Elevador.getInstancia(10);

        // Criando comandos
        Command requisitarAndar10 = new RequisitarAndarCommand(elevador, 10);
        Command chamarElevador = new ChamarElevadorCommand(elevador, 1, true);
        Command iniciarProcessamento = new IniciarProcessamentoCommand(elevador);

        // Criando uma thread para simular o atraso de chamar o elevador
        Thread chamarElevadorThread = new Thread(() -> {
            try {
                System.out.println("Elevador chamado.");

                // Depois de chamar o elevador, o usuário pode requisitar um andar
                requisitarAndar10.executar();
                System.out.println("Andar 10 requisitado.");
                iniciarProcessamento.executar();
                Thread.sleep(2000);
                chamarElevador.executar();


                // Iniciar o processamento da fila de requisições

            } catch (InterruptedException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        });

        // Iniciando a thread para chamar o elevador com atraso
        chamarElevadorThread.start();

        // Esperando que a thread termine antes de encerrar o programa
        try {
            chamarElevadorThread.join();
        } catch (InterruptedException e) {
            System.out.println("Erro ao esperar a thread: " + e.getMessage());
        }
    }
}
