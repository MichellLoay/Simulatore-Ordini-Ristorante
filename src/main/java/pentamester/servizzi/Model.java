/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pentamester.servizzi;

/**
 *
 * @author shwak
 */
import javax.swing.DefaultListModel;

import java.util.*;
import javax.swing.*;

public class Model extends Observable {
    private DefaultListModel<String> daServire;
    private DefaultListModel<String> serviti;
    private int counter = 0;

    public Model() {
        daServire = new DefaultListModel<>();
        serviti = new DefaultListModel<>();
    }

    public DefaultListModel<String> getDaServireModel() {
        return daServire;
    }

    public DefaultListModel<String> getServitiModel() {
        return serviti;
    }

    public void aggiungiPersona() {
        daServire.addElement("Da servire " + counter);
        counter++;
        setChanged();
        notifyObservers();
    }

    public void serviPersona() {
        if (!daServire.isEmpty()) {
            String persona = daServire.remove(0);
            persona = persona.replace("Da servire", "Servito/a");
            serviti.addElement(persona);
            setChanged();
            notifyObservers();
        }
    }
}
