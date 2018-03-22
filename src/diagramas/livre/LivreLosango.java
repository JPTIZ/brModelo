/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diagramas.livre;

import controlador.Diagram;

/**
 *
 * @author SAA
 */
public class LivreLosango extends LivreBase {

    private static final long serialVersionUID = 531349171884606537L;

    public LivreLosango(Diagram modelo, String texto) {
        super(modelo, texto);
        setTipoDesenho(LivreBase.TipoDraw.tpLosango);
    }

    public LivreLosango(Diagram modelo) {
        super(modelo);
        setTipoDesenho(LivreBase.TipoDraw.tpLosango);
    }

    
}
