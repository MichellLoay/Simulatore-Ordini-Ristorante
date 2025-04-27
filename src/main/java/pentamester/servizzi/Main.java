/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.servizzi;

/**
 *
 * @author shwak
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        model.addObserver(view);
        Controller controller = new Controller(model, view);
    }
}


