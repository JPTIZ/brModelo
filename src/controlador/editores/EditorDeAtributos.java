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

import desenho.FormaElementar;
import desenho.formas.Forma;
import desenho.preAnyDiagrama.PreEntidade;
import desenho.preAnyDiagrama.PreEntidadeAssociativa;
import desenho.preAnyDiagrama.PreRelacionamento;
import diagramas.conceitual.Atributo;
import diagramas.conceitual.DiagramaConceitual;
import diagramas.conceitual.Ligacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import principal.Application;

/**
 *
 * @author chcan
 */
public class EditorDeAtributos extends javax.swing.JDialog {

    /**
     * Creates new form EditorDeCampos
     */
    public EditorDeAtributos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTabelas = new javax.swing.JLabel();
        comboEntidades = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        Adicionar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        Adbtxt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Principal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPronto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("principal/Formularios_pt_BR"); // NOI18N
        setTitle(bundle.getString("EditorDeAtributos.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("EditorDeAtributos.tituloTabela"))); // NOI18N

        lblTabelas.setText(bundle.getString("EditorDeAtributos.Entidade.selecionada")); // NOI18N

        comboEntidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTabelas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTabelas)
                .addComponent(comboEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mais.png"))); // NOI18N
        Adicionar.setText(bundle.getString("EditorDeAtributos.Adicionar.Atributo")); // NOI18N
        Adicionar.setActionCommand(bundle.getString("EditorDeAtributos.Adicionar")); // NOI18N
        Adicionar.setFocusable(false);
        Adicionar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Adicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });
        jToolBar1.add(Adicionar);
        jToolBar1.add(jSeparator1);

        Adbtxt.setText(bundle.getString("EditorDeAtributos.Adicionar.Atributo.Serie")); // NOI18N
        Adbtxt.setToolTipText(bundle.getString("EditorDeAtributos.tooltip.edt_attr")); // NOI18N
        Adbtxt.setFocusable(false);
        Adbtxt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Adbtxt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Adbtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdbtxtActionPerformed(evt);
            }
        });
        jToolBar1.add(Adbtxt);

        Principal.setBackground(new java.awt.Color(204, 204, 204));
        Principal.setLayout(null);
        jScrollPane1.setViewportView(Principal);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPronto.setText(bundle.getString("EditorDeAtributos.Fechar")); // NOI18N
        btnPronto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPronto)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnPronto))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleName(bundle.getString("EditorDeAtributos.grupo")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProntoActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnProntoActionPerformed

    int v = 0;

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        Atributo att = CriaAtributo();
        AdicionarPainel(att);

        if (selecionada instanceof PreEntidade) {
            selecionada.DoAnyThing(((PreEntidade) selecionada).CONST_DO_ORGATTR);
        } else {
            selecionada.DoAnyThing(((PreRelacionamento) selecionada).CONST_DO_ORGATTR);
        }
    }//GEN-LAST:event_AdicionarActionPerformed

    private Atributo CriaAtributo() {
        int wa = 7;
        int largAtt = 72;
        Atributo att = new Atributo(selecionada.getMaster(), "Atributo");
        Ligacao la = new Ligacao(selecionada.getMaster());

        Point posi;
        if (selecionada instanceof PreEntidade) {
            int step = 2 * wa;
            int cabe = (selecionada.getWidth() / step);
            long tl = selecionada.getListaDeLigacoes().stream().filter(L -> (L.getFormaPontaA() == selecionada ? L.getPontaA().getLado() == 1 : L.getPontaB().getLado() == 1)).count();
            cabe = cabe < 1 ? 1 : cabe;
            int qtd = (int) tl + 1;
            int rep = 0;
            int T = selecionada.getTop() + 2;
            if (cabe < qtd) {
                if ((2 * cabe) >= qtd) {
                    rep = -((step / 2) + (cabe * step));
                } else {
                    tl = selecionada.getListaDeLigacoes().stream().filter(L -> (L.getFormaPontaA() == selecionada ? L.getPontaA().getLado() == 3 : L.getPontaB().getLado() == 3)).count();
                    qtd = (int) tl + 1;
                    T = selecionada.getTopHeight()- 2;
                    if (cabe < qtd) {
                        if ((2 * cabe) >= qtd) {
                            rep = -((step / 2) + (cabe * step));
                        } else {
                            rep = -1;
                        }
                    }
                }
            }
            if (rep != -1) {
                posi = new Point(selecionada.getLeft() + step * qtd + rep, T);
            } else {
                int d = 4;
                posi = new Point(selecionada.getLeftWidth() - selecionada.getWidth() / d + 2, selecionada.getTop() + selecionada.getHeight() / d - 2);
            }
        } else {
            int d = 2;
            posi = new Point(selecionada.getLeftWidth() - selecionada.getWidth() / d + 2, selecionada.getTop() + selecionada.getHeight() / d - 2);

        }

        Point pt2a = new Point(posi.x, selecionada.getTop() - 4 * wa);

        att.SetBounds(pt2a.x, pt2a.y - wa, largAtt, (2 * wa));
        att.BringToFront();

        la.SuperInicie(0, posi, pt2a);
        att.reSetBounds();
        att.Reenquadre();
        att.DoMove(Ligacao.distancia, 0);
        return att;
    }

    private void AdbtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdbtxtActionPerformed
        String txt = util.Dialogos.ShowDlgTexto(Application.mainWindow.getRootPane(), "");
        if (txt.isEmpty()) {
            return;
        }
        String[] lst = txt.split("\n");
        for (String a : lst) {
            a = a.trim();
            String tipo = "";
            if (!a.isEmpty()) {
                if (a.contains(" ")) {
                    String[] ct = a.replaceAll(" +", " ").split(" ");
                    a = ct[0];
                    tipo = ct[1];
                }
                Atributo c = CriaAtributo();
                c.setTexto(a);
                if (!tipo.isEmpty()) {
                    c.setTipoAtributo(tipo);
                }
            }
        }
        if (selecionada instanceof PreEntidade) {
            selecionada.DoAnyThing(((PreEntidade) selecionada).CONST_DO_ORGATTR);
        } else {
            selecionada.DoAnyThing(((PreRelacionamento) selecionada).CONST_DO_ORGATTR);
        }
//        getSelecionada().DoMuda();
        Popule(getSelecionada());
    }//GEN-LAST:event_AdbtxtActionPerformed
    
    private int largura = 0;
    
    public void AdicionarPainel(Atributo attr) {
        javax.swing.JPanel ItemPan = new javax.swing.JPanel();
        final int altura = 37;
        
        ItemPan.setSize(largura, altura);
        java.awt.FlowLayout lay = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5);
        ItemPan.setLayout(lay);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("principal/Formularios_pt_BR");
        javax.swing.JCheckBox chkIdentificador = new javax.swing.JCheckBox();
        javax.swing.JTextField txtNome = new javax.swing.JTextField();
        javax.swing.JLabel lblNome = new javax.swing.JLabel();
        javax.swing.JComboBox<String> comboTipo = new javax.swing.JComboBox<>();
        javax.swing.JLabel lblTipo = new javax.swing.JLabel();
        javax.swing.JButton btnExcluir = new javax.swing.JButton();

        lblNome.setText(bundle.getString("EditorDeAtributos.lblAtributo")); // NOI18N
        lblNome.setSize(new Dimension(50, 14));
        ItemPan.add(lblNome);

        txtNome.setToolTipText("");
        txtNome.setPreferredSize(new Dimension(190, 20));
        ItemPan.add(txtNome);

        lblTipo.setText(bundle.getString("EditorDeAtributos.lbldominio")); // NOI18N
        lblTipo.setSize(new Dimension(24, 14));
        ItemPan.add(lblTipo);
        
        comboTipo.setEditable(true);
        String tipo_txt = attr.getTipoAtributo();
        if (!tipo_txt.trim().isEmpty() && tipos.indexOf(tipo_txt) < 0) {
            tipos.add(tipo_txt);
        }
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(tipos.toArray()));
        comboTipo.setPreferredSize(new Dimension(73, 20));
        ItemPan.add(comboTipo);

        chkIdentificador.setText(bundle.getString("EditorDeAtributos.chkIdentificador")); // NOI18N
        chkIdentificador.setSize(new Dimension(97, 23));
        ItemPan.add(chkIdentificador);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setToolTipText(bundle.getString("EditorDeAtributos.tooltip.excluir")); // NOI18N
        btnExcluir.setPreferredSize(new Dimension(49, 25));
        ItemPan.add(btnExcluir);

        Principal.add(ItemPan);
        if (largura == 0) {
            largura = lay.preferredLayoutSize(ItemPan).width;
        }
        ItemPan.setBounds(0, v, largura, altura);
        v += altura + 3;
        Principal.setPreferredSize(new Dimension(largura, v));

        btnExcluir.addActionListener((java.awt.event.ActionEvent evt) -> {

            FormaElementar bkp = attr.getMaster().getSelecionado();

            attr.getMaster().ClearSelect();
            attr.getMaster().setSelecionado(attr);
            attr.getMaster().deleteSelecao();
            //attr.getMaster().setSelecionado(selecionada);

            if (bkp != null) {
                bkp.getMaster().setSelecionado(bkp);
            }

            ItemPan.setEnabled(false);
            txtNome.setEnabled(false);
            comboTipo.setEnabled(false);
            chkIdentificador.setEnabled(false);
            lblNome.setEnabled(false);
            lblTipo.setEnabled(false);
            btnExcluir.setEnabled(false);
            ItemPan.setBackground(Color.lightGray);
        });

        chkIdentificador.addItemListener((java.awt.event.ItemEvent evt) -> {
            if (attr.isIdentificador() != chkIdentificador.isSelected()) {
                attr.setIdentificador(chkIdentificador.isSelected());
                attr.DoMuda();
                attr.InvalidateArea();
            }
        });

        txtNome.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!txtNome.getText().equals(attr.getTexto())) {
                    attr.setTexto(txtNome.getText());
                    attr.DoMuda();
                    attr.InvalidateArea();
                }
            }
        });

        comboTipo.addActionListener((ActionEvent e) -> {
            String txt = comboTipo.getSelectedItem().toString();
            if (!txt.equals(attr.getTipoAtributo())) {
                attr.setTipoAtributo(txt);
                attr.DoMuda();
                attr.InvalidateArea();
                if (tipos.indexOf(txt) < 0) {
                    tipos.add(0, txt);
                }
            }
        });

        comboTipo.getEditor().addActionListener((ActionEvent e) -> {
            String txt = comboTipo.getSelectedItem().toString();
            if (!txt.equals(attr.getTipoAtributo())) {
                attr.setTipoAtributo(txt);
                attr.DoMuda();
                attr.InvalidateArea();
                if (tipos.indexOf(txt) < 0) {
                    tipos.add(0, txt);
                }
            }
        });

        comboTipo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                comboTipo.setSelectedItem(attr.getTipoAtributo());
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboTipo.setSelectedItem(attr.getTipoAtributo());
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboTipo.setModel(new javax.swing.DefaultComboBoxModel(tipos.toArray()));
            }
        });

        txtNome.setText(attr.getTexto());
        chkIdentificador.setSelected(attr.isIdentificador());
        comboTipo.setSelectedItem(tipo_txt);

        ItemPan.validate();
        Principal.validate();
    }

    ArrayList<String> tipos = new ArrayList<>();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adbtxt;
    private javax.swing.JButton Adicionar;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton btnPronto;
    private javax.swing.JComboBox<String> comboEntidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTabelas;
    // End of variables declaration//GEN-END:variables

    DiagramaConceitual diagrama = null;
    List<Forma> entidades = null;

    public void Inicie(DiagramaConceitual diag) {
        diagrama = diag;
        comboEntidades.removeAllItems();
        entidades = diagrama.getListaDeItens().stream().filter(tb -> tb instanceof PreEntidade || tb instanceof PreRelacionamento).map(e -> (Forma) e).collect(Collectors.toList());

        diagrama.getListaDeItens().stream().filter(tb -> tb instanceof PreEntidadeAssociativa).map(en -> (PreEntidadeAssociativa) en).forEach(ea -> {
            entidades.add(entidades.indexOf(ea) + 1, ea.getInterno());
        });

        FormaElementar sel = diag.getSelecionado();
        sel = (sel instanceof PreEntidade || sel instanceof PreRelacionamento ? sel : null);
        int idx = 0;
        for (int i = 0; i < entidades.size(); i++) {
            Forma t = entidades.get(i);
            comboEntidades.addItem(String.valueOf(i + 1) + " - " + (t.getPrincipal() != t ? ((Forma) t.getPrincipal()).getTexto() + " -> " + t.getTexto() : t.getTexto()));

            if (t instanceof PreEntidade) {
                ((PreEntidade) t).getAtributos().stream().forEach(a -> {
                    String tp = a.getTipoAtributo();
                    if (!tp.isEmpty()) {
                        if (tipos.indexOf(tp) < 0) {
                            tipos.add(tp);
                        }
                    }
                });
            }
            if (t instanceof PreRelacionamento) {
                ((PreRelacionamento) t).getAtributos().stream().forEach(a -> {
                    String tp = a.getTipoAtributo();
                    if (!tp.isEmpty() && tipos.indexOf(tp) < 0) {
                        tipos.add(tp);
                    }
                });
            }

            if (t == sel) {
                idx = i;
            }
        }
        sel = entidades.get(idx);

        comboEntidades.setSelectedIndex(idx);

        comboEntidades.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                setSelecionada(entidades.get(comboEntidades.getSelectedIndex()));
            }
        });

        setSelecionada((Forma) sel);
    }

    private Forma selecionada = null;

    public Forma getSelecionada() {
        return selecionada;
    }

    public void setSelecionada(Forma selecionada) {
        if (this.selecionada != selecionada) {
            this.selecionada = selecionada;
            Popule(selecionada);
        }
    }

    private void Popule(Forma sel) {
        Principal.removeAll();
        Principal.validate();
        v = 0;
        if (sel instanceof PreEntidade) {
            ((PreEntidade) sel).getAtributos().stream().forEach(A -> AdicionarPainel(A));
        } else {
            ((PreRelacionamento) sel).getAtributos().stream().forEach(A -> AdicionarPainel(A));
        }
        Principal.repaint();
    }
}
