/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Lenovo
 */
public class MenuLogin extends JFrame {

    public MenuLogin() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flabby Animal");
        setSize(300, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        pnlPanel1 = new JPanel();
        pnlPanel1.setSize(100, 100);
        pnlPanel1.setLocation(100, 50);
        add(pnlPanel1);
        

    }

    public static void main(String[] args) {
        System.out.println("Test Git Hub");
        new MenuLogin().setVisible(true);

    }
private JPanel pnlPanel1;
 
}
   