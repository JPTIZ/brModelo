/*
 * Copyright (C) 2017 chcan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package controlador.editores;

import controlador.editores.EditorTexto;
import controlador.Editor;
import diagramas.logico.DataBaseModel;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import principal.Aplicacao;

/**
 *
 * @author chcan
 */
public class MostradorDeCodigo extends javax.swing.JDialog implements ClipboardOwner{

    public MostradorDeCodigo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblHtml = new JLabel();
        scrPrincipal.getViewport().add(lblHtml);
        //dbModel.InicieAnsi2011();
        
        getRootPane().registerKeyboardAction(e -> {
            //this.dispose();
            //setResultado(JOptionPane.CANCEL_OPTION);
            setVisible(false);

        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        getRootPane().registerKeyboardAction(e -> {
            //setResultado(JOptionPane.OK_OPTION);
            setVisible(false);
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        getRootPane().registerKeyboardAction(e -> {
            btnCopyActionPerformed(null);
        }, KeyStroke.getKeyStroke(KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        setTitle(Editor.fromConfiguracao.getValor("Controler.interface.Titulo.MostradorDeCodigo"));
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        scrPrincipal = new javax.swing.JScrollPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnZmn = new javax.swing.JButton();
        txtZoon = new javax.swing.JTextField();
        btnZma = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCopy = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("principal/Formularios_pt_BR"); // NOI18N
        btnFechar.setText(bundle.getString("MC.btnFchar")); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btnZmn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoommenos.png"))); // NOI18N
        btnZmn.setFocusable(false);
        btnZmn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZmn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZmn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZmnActionPerformed(evt);
            }
        });
        jToolBar1.add(btnZmn);

        txtZoon.setEditable(false);
        txtZoon.setText("12");
        jToolBar1.add(txtZoon);

        btnZma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btnZma.setFocusable(false);
        btnZma.setHideActionText(true);
        btnZma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZmaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnZma);
        jToolBar1.add(jSeparator1);

        btnCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/copy.png"))); // NOI18N
        btnCopy.setFocusable(false);
        btnCopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCopy.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cpdim_cp.png"))); // NOI18N
        btnCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCopy);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/green_edit.gif"))); // NOI18N
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrPrincipal)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 514, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(scrPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    int vlZoom = 12;
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnZmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZmaActionPerformed
        vlZoom++;
        if (vlZoom > 72) {
            vlZoom = 72;
            return;
        }
        txtZoon.setText(String.valueOf(vlZoom));
        setTexto(buffer);
    }//GEN-LAST:event_btnZmaActionPerformed

    private void btnZmnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZmnActionPerformed
        vlZoom--;
        if (vlZoom < 1) {
            vlZoom = 1;
            return;
        }
        txtZoon.setText(String.valueOf(vlZoom));
        setTexto(buffer);
    }//GEN-LAST:event_btnZmnActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        StringSelection vai = new StringSelection(buffer);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(vai, this);
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        controlador.editores.EditorTexto edt = new EditorTexto((Frame) (Aplicacao.fmPrincipal.getRootPane()).getParent(), true);
        edt.setLocationRelativeTo(Aplicacao.fmPrincipal.getRootPane());
        edt.setTexto(buffer);
        edt.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnZma;
    private javax.swing.JButton btnZmn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane scrPrincipal;
    private javax.swing.JTextField txtZoon;
    // End of variables declaration//GEN-END:variables

    public JLabel lblHtml = null;

    public String getTexto() {
        return buffer;
    }

    public void setTexto(String texto) {
        buffer = texto;
        this.lblHtml.setText(Formate(texto));
    }

    private DataBaseModel dbModel = new DataBaseModel();

    private String buffer = "";

    public DataBaseModel getDbModel() {
        return dbModel;
    }

    public void setDbModel(DataBaseModel dbModel) {
        this.dbModel = dbModel;
    }

    private String Formate(String texto) {
        String[] subs = texto.split("\n");
        StringBuilder bu = new StringBuilder();

        final String fr = "<font color='red'>";
        final String fb = "<font color='blue'><b>";
        final String fimR = "</font>";
        final String fimB = "<b/></font>";
        int fl = fimB.length();
        
        for (String str : subs) {
            String tmp = " " + str.toUpperCase() + " ";
            for (String rw : dbModel.getDataTypes()) {
                int p = tmp.indexOf(" " + rw + " ");
                while (p > -1) {
                    str = injete(str, rw, fb, fimB, p);
                    tmp = " " + str.toUpperCase() + " ";
                    p = tmp.indexOf(" " + rw + " ", p + rw.length() + 1 + fl);
                }
                p = tmp.indexOf(" " + rw + ",");
                while (p > -1) {
                    str = injete(str, rw, fb, fimB, p);
                    tmp = " " + str.toUpperCase() + " ";
                    p = tmp.indexOf(" " + rw + ",", p + rw.length() + 1 + fl);
                }
            }
            fl = fimR.length();
            //tmp = " " + str.toUpperCase() + " ";
            for (String rw : dbModel.getReservedWords()) {
                int p = tmp.indexOf(" " + rw + " ");
                while (p > -1) {
                    str = injete(str, rw, fr, fimR, p);
                    tmp = " " + str.toUpperCase() + " ";
                    p = tmp.indexOf(" " + rw + " ", p + rw.length() + 1 + fl);
                }
                p = tmp.indexOf(" " + rw + ",");
                while (p > -1) {
                    str = injete(str, rw, fr, fimR, p);
                    tmp = " " + str.toUpperCase() + " ";
                    p = tmp.indexOf(" " + rw + ",", p + rw.length() + 1 + fl);
                }
            }

            str = str.replaceAll("  ", "&nbsp;&nbsp;");
            bu.append("<li>").append(str).append("</li>").append("\n");
        }

        String res = "<html>\n"
                + "<style>ol {\n"
                + "    display: block;\n"
                + "    list-style-type: decimal;\n"
                + "    margin-top: 1em;\n"
                + "    margin-bottom: 1em;\n"
                + "    margin-left:  " + vlZoom + ";\n"
                + "    margin-right: 0;\n"
                + "    padding-left: " + vlZoom + "px;\n"
                + "}</style>"
//                + "<body style=\"font-size: " + vlZoom + "\">\n <font size='" + vlZoom + "'><ol style=\"font-size: " + vlZoom + "\">"
                + "<body style=\"font-size: " + vlZoom + "\">\n<ol>"
                //+ "<font size='" + vlZoom + "'>"
                + bu.toString()
                + "</ol>\n"
                + "</font>\n</body>\n"
                + "</html>";
        return res;
    }

    public String injete(String origem, String palavra, String inj, String fim, int posi) {
        String res;
        if (posi == 0) {
            res = inj + origem.substring(0, palavra.length());
        } else {
            res = origem.substring(0, posi) + inj + origem.substring(posi, posi + palavra.length());
        }
        posi += palavra.length();
        res = res + fim + (posi < origem.length() ? origem.substring(posi) : "");
        return res;
    }
    
    @Override
    public void lostOwnership(Clipboard clpbrd, Transferable t) {
        
    }
}