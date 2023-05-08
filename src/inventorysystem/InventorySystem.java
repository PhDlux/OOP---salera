/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

import javax.swing.JFrame;

/**
 *
 * @author Lance Salera
 */
public class InventorySystem extends JFrame {
    public static void main(String[] args) {
        CreateAccount ca = new CreateAccount();
        ca.show();
        ca.setLocationRelativeTo(null);
    }
}
