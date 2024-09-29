package Elevador;

public class Porta {
        private boolean isOpen;

        public void abrir(){
            if (!isOpen) {
                isOpen = true;
                System.out.println("Porta aberta");
            }
        }

        public void fechar(){
            if (isOpen) {
                isOpen = false;
                System.out.println("Porta fechada");
            }
        }

        public boolean isOpen(){
                return isOpen;
            }
}


