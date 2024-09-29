package Factory;

import Elevador.Elevador;
import Observer.*;

public class DisplayPainelFactoryConcreta implements DisplayPainelFactory {

    @Override
    public DisplayPanel createInternalDisplayPanel(Elevador elevador) {
        return new InternalDisplayPanel(elevador);
    }

    @Override
    public DisplayPanel createExternalDisplayPanel(Elevador elevador, int andar) {
        return new ExternalDisplayPanel(elevador, andar);
    }
}
