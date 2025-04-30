/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pentamester.servizzi;

/**
 *
 * @author shwak
 */
import java.util.*;
public class Model {
    private LinkedList<String> daServire = new LinkedList<>();
    private LinkedList<String> serviti = new LinkedList<>();
    private int ultimoVal = 0;
    private List<IModelObserver> observers = new ArrayList<>();

    public void aggiungiPersona() {
        String nome = "Da servire " + ultimoVal;
        daServire.addLast(nome);
        ultimoVal++;
        notificaObserver();
    }

    public void serviPersona() {
        if (!daServire.isEmpty()) {
            String daServito = daServire.removeFirst(); 
            String servito = daServito.replace("Da servire", "Servito");
            serviti.addFirst(servito); 
            notificaObserver();
        }
    }

    public List<String> getDaServire() {
        return new ArrayList<>(daServire);
    }

    public List<String> getServiti() {
        return new ArrayList<>(serviti);
    }

    public void aggiungiObserver(IModelObserver observer) {
        observers.add(observer);
    }

    private void notificaObserver() {
        for (IModelObserver o : observers) {
            o.update(new ArrayList<>(daServire), new ArrayList<>(serviti));
        }
    }
}