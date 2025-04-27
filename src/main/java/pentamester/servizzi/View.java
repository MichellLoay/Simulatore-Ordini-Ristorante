/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.servizzi;

/**
 *
 * @author shwak
 */
import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class View extends JFrame implements Observer {
    JButton aggiungiButton;
    JButton serviButton;
    JList<String> listaDaServire;
    JList<String> listaServiti;

    public View() {
        setTitle("Esercizio 5 - Model View Controller - Coda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(1, 2));

        JPanel panelDaServire = new JPanel(new BorderLayout());
        aggiungiButton = new JButton("+");
        listaDaServire = new JList<>(new DefaultListModel<>());
        panelDaServire.add(aggiungiButton, BorderLayout.NORTH);
        panelDaServire.add(new JScrollPane(listaDaServire), BorderLayout.CENTER);

        JPanel panelServiti = new JPanel(new BorderLayout());
        serviButton = new JButton("-");
        listaServiti = new JList<>(new DefaultListModel<>());
        panelServiti.add(serviButton, BorderLayout.NORTH);
        panelServiti.add(new JScrollPane(listaServiti), BorderLayout.CENTER);

        add(panelDaServire);
        add(panelServiti);
        
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Quando il Model cambia, aggiorniamo la View
        if (o instanceof Model model) {
            listaDaServire.setModel(model.getDaServireModel());
            listaServiti.setModel(model.getServitiModel());
        }
    }
}


