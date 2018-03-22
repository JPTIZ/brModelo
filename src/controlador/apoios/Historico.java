/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.apoios;

import controlador.Editor;
import controlador.Diagram;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ccandido
 */
public class Historico {

    private final Editor master;

    public Historico(Editor aThis) {
        super();
        this.master = aThis;
    }

    class HistDiagrama {

        int posicao = 0;
        final int MAX = 500;
        
        Diagram diagrama;
        ArrayList<ByteArrayOutputStream> diagramas = new ArrayList<>();

        public HistDiagrama(Diagram diagrama) {
            this.diagrama = diagrama;
            diagramas.add(Diagram.SaveToStream(diagrama));
        }

        public boolean isMe(Diagram mod) {
            return diagrama == mod;
        }

        public boolean podeDesfazer() {
            return posicao > 0;
        }

        public boolean podeRefazer() {
            return posicao < diagramas.size() - 1;
        }

        public Diagram desfazer() {
            if (podeDesfazer()) {
                posicao--;
                LoadDiagrama();
                return diagrama;
            } else {
                return null;
            }
        }

        public Diagram refazer() {
            if (podeRefazer()) {
                posicao++;
                LoadDiagrama();
                return diagrama;
            } else {
                return null;
            }
        }

        private void LoadDiagrama() {
            String tmpNome = diagrama.getNome();
            String tmpArq = diagrama.getArquivo();
            diagrama = Diagram.LoadFromStream(diagramas.get(posicao));
            diagrama.SetNome(tmpNome);
            diagrama.setArquivo(tmpArq);
            diagrama.setMaster(Historico.this.master);
            diagrama.setMudou(true);
        }

        public synchronized void Append(Diagram mo) {
            ByteArrayOutputStream res = Diagram.SaveToStream(mo);
            if (res == null) {
                return;
            }
            posicao++;
            diagramas.add(posicao, res);
            while (diagramas.size() - 1 > posicao) {
                diagramas.remove(diagramas.size() - 1);
            }
            if (posicao > MAX) {
                diagramas.remove(0);
                posicao--;
            }
            //if posicção maior que MAX apago o "0" -- feito, não testado.
        }
    }
    private ArrayList<HistDiagrama> lista = new ArrayList<>();
    /**
     * Poupa percorrer toda a coleção para encontrar o hitórico atual
     */
    private HistDiagrama atual = null;

    /**
     * Poupa percorrer toda a coleção para encontrar o hitórico atual
     */
    private HistDiagrama updateAtual(Diagram diagramaAtual) {
        if (atual == null || !atual.isMe(diagramaAtual)) {
            atual = getByDiagrama(diagramaAtual);
        }
        return atual;
    }

    private HistDiagrama getByDiagrama(Diagram mo) {
        for (HistDiagrama hm : lista) {
            if (hm.isMe(mo)) {
                return hm;
            }
        }
        return null;
    }

    public ArrayList<String> getStrDiagramas() {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        for (Diagram hm : getDiagramas()) {
            i++;
            String tmp = "[" + Integer.toString(i) + "] " + hm.getNomeFormatado();

            res.add(tmp);
        }
        return res;
    }

    /**
     * Não precisa recompor a lista sempre.
     */
    private ArrayList<Diagram> listaDiagramas = new ArrayList<>();
    public ArrayList<Diagram> getDiagramas() {
        if (listaDiagramas != null) return listaDiagramas;
        ArrayList<Diagram> res = new ArrayList<>();
        lista.stream().forEach((hm) -> {
            res.add(hm.diagrama);
        });
        listaDiagramas = res;
        return res;
    }

    public boolean removeDiagrama(Diagram mo, Diagram noLugar) {
        listaDiagramas = null;

        HistDiagrama hm = getByDiagrama(mo);
        //int p = lista.indexOf(hm);
        boolean re = lista.remove(hm);
        if (noLugar == null) {
            atual = null;
        } else {
            updateAtual(noLugar);
        }
        return re;
    }

    public void add(Diagram mo) {
        listaDiagramas = null;
        lista.add(new HistDiagrama(mo));
    }

    public void add(Diagram mo, int index) {
        listaDiagramas = null;
        lista.add(index, new HistDiagrama(mo));
    }

    public Diagram desfazer(Diagram diagramaAtual) {
        listaDiagramas = null;
        HistDiagrama hm = updateAtual(diagramaAtual);
        if (hm == null) {
            return null;
        }
        return hm.desfazer();
    }

    public Diagram refazer(Diagram diagramaAtual) {
        listaDiagramas = null;
        HistDiagrama hm = updateAtual(diagramaAtual);
        if (hm == null) {
            return null;
        }
        return hm.refazer();
    }

    public boolean podeDesfazer(Diagram diagramaAtual) {
        HistDiagrama hm = updateAtual(diagramaAtual);
        if (hm == null) {
            return false;
        }
        return hm.podeDesfazer();
    }

    public boolean podeRefazer(Diagram diagramaAtual) {
        HistDiagrama hm = updateAtual(diagramaAtual);
        if (hm == null) {
            return false;
        }
        return hm.podeRefazer();
    }

    public void append(Diagram diagramaAtual) {
        listaDiagramas = null;
        HistDiagrama hm = updateAtual(diagramaAtual);
        if (hm == null) {
            return;
        }
        hm.Append(diagramaAtual);
    }
    
    public void removeAll() {
        lista.clear();
    }
}
