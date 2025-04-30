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
import java.awt.event.*;
import java.util.*;

public class View extends JFrame implements IModelObserver {
    private JButton aggiungiBottone = new JButton(" + ");
    private JButton serviBottone = new JButton(" - ");
    private JList<String> listaDaServire = new JList<>();
    private JList<String> listaServiti = new JList<>();
    private IViewObserver controller;

    public View() {
        super("Esercizio 5 - Model View Controller - Coda");

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(aggiungiBottone);
        topPanel.add(serviBottone);
        add(topPanel, BorderLayout.NORTH);

        JPanel listePanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel pannelloDaServire = new JPanel(new BorderLayout());
        pannelloDaServire.setBorder(BorderFactory.createTitledBorder("Da servire"));
        pannelloDaServire.add(new JScrollPane(listaDaServire), BorderLayout.CENTER);

        JPanel pannelloServiti = new JPanel(new BorderLayout());
        pannelloServiti.setBorder(BorderFactory.createTitledBorder("Serviti"));
        pannelloServiti.add(new JScrollPane(listaServiti), BorderLayout.CENTER);

        listePanel.add(pannelloDaServire);
        listePanel.add(pannelloServiti);

        add(listePanel, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        aggiungiBottone.addActionListener(e -> controller.aggiungiPersona());
        serviBottone.addActionListener(e -> controller.serviPersona());
    }

    public void setViewObserver(IViewObserver observer) {
        this.controller = observer;
    }

    @Override
    public void update(java.util.List<String> daServire, java.util.List<String> serviti) {
        listaDaServire.setListData(daServire.toArray(new String[0]));
        listaServiti.setListData(serviti.toArray(new String[0]));
    }

    @Override
    public void initialize() {
        controller.settiValuToModel();
    }
}