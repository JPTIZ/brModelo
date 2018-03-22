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
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author SAA
 */
public class SubpartManager implements Serializable{

    private static final long serialVersionUID = 8170769009687181088L;

    private String title = "";

    public void setTitle(String title) {
        this.title = title;
    }
    
    private byte[] rawImage = null;
    private String XMLCopiado = "";
    private String version = "";
    private Diagram.TipoDeDiagrama diagramType = Diagram.TipoDeDiagrama.CONCEITUAL;
    
    public SubpartManager(String titulo, byte[] byteImage, String XMLCopiado, String versaoDiagrama, Diagram.TipoDeDiagrama tipoDeDiagrama) {
        this.rawImage = byteImage;
        this.XMLCopiado = XMLCopiado;
        this.title = titulo;
        this.version = versaoDiagrama;
        this.diagramType = tipoDeDiagrama;
    }
    
    public SubpartManager() {
        //# Futuro
    }
    
    public void InitGerenciadorSubParte(String titulo, byte[] byteImage, String XMLCopiado, String versaoDiagrama, Diagram.TipoDeDiagrama tipo) {
        this.rawImage = byteImage;
        this.XMLCopiado = XMLCopiado;
        this.title = titulo;
        this.version = versaoDiagrama;
        this.diagramType = tipo;
    }

    public String getTitle() {
        return title;
    }
    
    public byte[] getRawImage() {
        return rawImage;
    }

    public String getXMLCopiado() {
        return XMLCopiado;
    }

    public String getVersion() {
        return version;
    }
    
    public Diagram.TipoDeDiagrama getDiagramType() {
        return diagramType;
    }

    public void setXMLCopiado(String XMLCopiado) {
        this.XMLCopiado = XMLCopiado;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDiagramType(Diagram.TipoDeDiagrama diagramType) {
        this.diagramType = diagramType;
    }
    
    
}
