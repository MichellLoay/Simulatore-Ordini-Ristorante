/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.servizzi;

/**
 *
 * @author shwak
 */
public interface IModelObserver {
    void update(java.util.List<String> daServire, java.util.List<String> serviti);
    void initialize();
}
