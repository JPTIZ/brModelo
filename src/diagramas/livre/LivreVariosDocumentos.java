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
public class LivreVariosDocumentos extends LivreBase {

    private static final long serialVersionUID = 1699623308177437273L;

    public LivreVariosDocumentos(Diagram modelo, String texto) {
        super(modelo, texto);
        setTipoDesenho(LivreBase.TipoDraw.tpVariosDocumentos);
    }

    public LivreVariosDocumentos(Diagram modelo) {
        super(modelo);
        setTipoDesenho(LivreBase.TipoDraw.tpVariosDocumentos);
    }
}
