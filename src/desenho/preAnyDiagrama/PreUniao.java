/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desenho.preAnyDiagrama;

import controlador.Diagram;

/**
 *
 * @author ccandido
 */
public class PreUniao extends PreEspecializacao {

    private static final long serialVersionUID = -3414008491237272878L;

    public PreUniao(Diagram modelo) {
        super(modelo);
        setDirecao(Direcao.Down);
        //SetTexto("U");
        toPaintTxt = "U";
    }

    public PreUniao(Diagram modelo, String texto) {
        super(modelo, texto);
        setDirecao(Direcao.Down);
        toPaintTxt = "U";
    }

//    @Override
//    protected void PinteRegiao(Graphics2D g) {
//        Stroke bkp = g.getStroke();
//        float[] dash4 = {2f, 2f, 2f};
//        BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash4,
//                2f);
//        g.setStroke(bs4);
//
//        super.PinteRegiao(g);
////        g.drawOval(getLeft() + getWidth()/4 + distSelecao, getTop() + getHeight()/4 + distSelecao, 
////                getWidth()/2 - 2*distSelecao, getHeight()/2 - 2*distSelecao);
//        g.setStroke(bkp);
//    }
}
