/*
 * Copyright (C) 2016 chcan
 */
package diagramas.livre;
import controlador.Diagram;
import desenho.preDiagrama.baseDrawer;

public class LivreDrawer extends baseDrawer {

    private static final long serialVersionUID = 8822609460359454495L;
    
    public LivreDrawer(Diagram diagrama, String texto) {
        super(diagrama, texto);
    }

    public LivreDrawer(Diagram diagrama) {
        super(diagrama);
    }
        
}
