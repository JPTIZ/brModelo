/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author ccandido
 */
public class Logger {

    private static JLabel status;

    public static JLabel getStatus() {
        return status;
    }

    public static void setStatus(JLabel status) {
        Logger.status = status;
    }

    /**
     * Internal Exception representation.
     */
    public static class Exception {
        public String type = "";
        public String value = "";
        public String complement = "";
        
        public Exception(String type, String value) {
            this.type = type;
            this.value = value;
        }
        
        public Exception(String type, String value, String complemento) {
            this(type, value);
            this.complement = complemento;
        }

        @Override
        public String toString() {
            return type + ": " + value;
        }
    }
            
    /**
     * History of error logs.
     */
    public final static ArrayList<Exception> logs = new ArrayList<>();
    
    public static void log(String rpt, String exception) {
        Exception p = new Exception(rpt , (exception != null ? " (java: " + exception + ")" : ""));
        logs.add(p);
        if (status != null) {
            status.setForeground(Color.red);
            String msg = p.type + p.value;
            status.setText(msg);
        }
    }

    public static void log(String rpt, String complement, String exception) {
        Exception p = new Exception(rpt, (exception != null ? " (java: " + exception + ")" : ""), complement);
        logs.add(p);
        if (status != null) {
            status.setForeground(Color.red);
            String msg = p.type + p.complement + p.value;
            status.setText(msg);
        }
    }
    
    public static void clean() {
        logs.clear();
        getStatus().setText("");
    }
}
