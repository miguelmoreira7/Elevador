package Factory;

import Observer.DisplayPanel.DisplayPanel;
import Elevador.Elevador;

public interface DisplayPainelFactory {
    DisplayPanel createInternalDisplayPanel(Elevador elevador);
    DisplayPanel createExternalDisplayPanel(Elevador elevador, int andar);
}
