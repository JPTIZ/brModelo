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
public class LivreRetangulo extends LivreBase {

    private static final long serialVersionUID = 3740634104066034638L;

    public LivreRetangulo(Diagram modelo, String texto) {
        super(modelo, texto);
        setTipoDesenho(LivreBase.TipoDraw.tpRetangulo);
    }

    public LivreRetangulo(Diagram modelo) {
        super(modelo);
        setTipoDesenho(LivreBase.TipoDraw.tpRetangulo);
    }
}