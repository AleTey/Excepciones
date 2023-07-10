
package Service;

import Entidad.Armadura;
import Enum.Estado;

public class BotaService {
    
    ArmaduraService as = new ArmaduraService();
    
    public void botasLuegoDeUso(Armadura armadura) {
        if(as.danioPorUso()) {
            armadura.getBotaD().setEstado(Estado.DAÑADO);
        }
        if(as.danioPorUso()) {
            armadura.getBotaI().setEstado(Estado.DAÑADO);
        }
        
    }
}
