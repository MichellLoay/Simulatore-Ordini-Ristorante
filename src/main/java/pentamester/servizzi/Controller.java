/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.servizzi;

/**
 *
 * @author shwak
 */
public class Controller implements IViewObserver {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setViewObserver(this);
    }

    public void aggiungiPersona() {
        model.aggiungiPersona();
    }

    public void serviPersona() {
        model.serviPersona();
    }

    public void settiValuToModel() {
        view.update(model.getDaServire(), model.getServiti());
    }
}