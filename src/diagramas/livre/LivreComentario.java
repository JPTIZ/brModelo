/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramas.livre;

import controlador.Diagram;

/**
 *
 * @author ccandido
 */
public class LivreComentario extends LivreBase {

    private static final long serialVersionUID = -2762375162776817796L;

    public LivreComentario(Diagram modelo, String texto) {
        super(modelo, texto);
        setTipoDesenho(LivreBase.TipoDraw.tpComentario);
    }

    public LivreComentario(Diagram modelo) {
        super(modelo);
        setTipoDesenho(LivreBase.TipoDraw.tpComentario);
    }
}
