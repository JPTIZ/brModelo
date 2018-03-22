/*
 * Copyright (C) 2015 SAA
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
package partepronta;

import controlador.Diagram;
import desenho.FormaElementar;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import static util.ImageGenerate.geraImagemForPrnSelecao;

/**
 *
 * @author SAA
 */
public class PartsManager implements Serializable {

    private static final long serialVersionUID = 5549339395194123920L;

    private final ArrayList<SubpartManager> subparts = new ArrayList<>();

    public ArrayList<SubpartManager> getSubparts() {
        return subparts;
    }

    public void add(SubpartManager parte) {
        subparts.add(parte);
        setChanged(true);
    }

    public SubpartManager add(String texto, Diagram diag) {
        byte[] byteImage = getSelectionImage(diag);
        String XMLCopiado = Diagram.saveToXml(diag, true);
        String versaoDiagrama = diag.getVersao();
        Diagram.TipoDeDiagrama tipo = diag.getTipo();
        
        SubpartManager parte = new SubpartManager(texto, byteImage, XMLCopiado, versaoDiagrama, tipo);
        
        PartsManager.this.add(parte);
        return parte;
    }

    public byte[] getSelectionImage(Diagram current) {
        final int margin = 2;
        Point p2 = current.getPontoExtremoSelecionado();
        int minX = p2.x;
        int minY = p2.y;

        for (int i = current.getItensSelecionados().size() - 1; i >= 0; i--) {
            FormaElementar el = current.getItensSelecionados().get(i);
            minX = Math.min(minX, el.getLeft());
            minY = Math.min(minY, el.getTop());
        }

        minX = Math.max(minX - margin, 0);
        minY = Math.max(minY - margin, 0);

        BufferedImage cpImage = geraImagemForPrnSelecao(current, p2.x + margin, p2.y + margin);
        return util.TratadorDeImagens.toByteArray(cpImage.getSubimage(minX, minY, p2.x - minX, p2.y - minY));
    }

    public void remove(SubpartManager sp) {
        subparts.remove(sp);
        setChanged(true);
    }
   
    
    //<editor-fold defaultstate="collapsed" desc="save">
    private boolean changed = false;
    
    public boolean hasChanged() {
        return changed;
    }
    
    public void setChanged(boolean mudou) {
        // TODO: Make it only as a callback.
        this.changed = mudou;
    }
    
    /**
     * 
     * @param filename
     * @return 
     * 
     * TODO: Change String to java.io.Path
     */
    public static PartsManager fromFile(String filename) {
        try (FileInputStream file = new FileInputStream(filename)) {
            try (ObjectInput in = new ObjectInputStream(file)) {
                PartsManager res = (PartsManager)in.readObject();
                res.setChanged(false);
                return res;
            }
        } catch (NullPointerException |
                 IOException |
                 ClassNotFoundException e) {
            util.Logger.log("ERROR_TEMPLATE_LOAD", e.getMessage());
            return null;
        }
    }
    
    public static PartsManager loadDataTemplate() {
        String filename = System.getProperty("user.dir") + File.separator + "Template.brMt";
        PartsManager manager = fromFile(filename);
        if (manager == null) {
            manager = new PartsManager();
            PartsManager.saveDataTemplate(manager);
        }
        return manager;
    }
    
    public static boolean save(PartsManager manager, String filename) {
        try (FileOutputStream file = new FileOutputStream(filename)) {
            try (ObjectOutput out = new ObjectOutputStream(file)) {
                out.writeObject(manager);
            }
            manager.setChanged(false);
            return true;
        } catch (IOException e) {
            util.Logger.log("ERROR_TEMPLATE_SAVELOAD", e.getMessage());
            return false;
        }
    }
    
    public static boolean saveDataTemplate(PartsManager manager) {
        String filename = System.getProperty("user.dir") +
                          File.separator +
                          "Template.brMt";
        return save(manager, filename);
    }
    //</editor-fold>

    public void edit(SubpartManager part, String title) {
        part.setTitle(title);
        setChanged(true);
    }
}
