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
public class LivreCirculo extends LivreBase {

    private static final long serialVersionUID = -4320967864621147459L;

    public LivreCirculo(Diagram modelo, String texto) {
        super(modelo, texto);
        setTipoDesenho(LivreBase.TipoDraw.tpCirculo);
    }

    public LivreCirculo(Diagram modelo) {
        super(modelo);
        setTipoDesenho(LivreBase.TipoDraw.tpCirculo);
    }

    
}
