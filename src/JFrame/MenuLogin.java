/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(resizeBackground("img/background.jpg")));
        background.setLayout(new FlowLayout());
//  

        pnlPanel1 = new JPanel();
        pnlPanel1.setSize(100, 100);
        pnlPanel1.setLocation(100, 50);
        lblIcon = new JLabel();
        lblIcon.setIcon(new ImageIcon(resizeImage("img/login_title.png")));
        pnlPanel1.add(lblIcon);
//        add(pnlPanel1);

        pnlPanel2 = new JPanel();
        pnlPanel2.setSize(300, 150);
        pnlPanel2.setLocation(0, 200);
        lblIcon2 = new JLabel("Username : ");
        pnlPanel2.add(lblIcon2);
        txtText1 = new JTextField(20);
        pnlPanel2.add(txtText1);
        lblIcon3 = new JLabel("Password : ");
        pnlPanel2.add(lblIcon3);
        txtText2 = new JTextField(20);
        pnlPanel2.add(txtText2);
        btnSubmit3 = new JButton("Submit");
        btnSubmit3.setPreferredSize(new Dimension(100, 30));
        pnlPanel2.add(btnSubmit3);
//        lblIcon4 = new JLabel();
//        lblIcon4.setIcon(new ImageIcon(resizeBackground("img/background.jpg")));
//        lblIcon4.setLayout(new FlowLayout());
//        pnlPanel2.add(lblIcon4);
//        add(pnlPanel2);

        pnlPanel3 = new JPanel();
        pnlPanel3.setSize(100, 80);
        pnlPanel3.setLocation(185, 475);
        btnSubmit = new JButton();
        btnSubmit.setPreferredSize(new Dimension(100, 80));
        btnSubmit.setIcon(new ImageIcon(resizeImage("img/exit.png")));
        btnSubmit.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                onClickBtnSubmit(e);
            }

            private void onClickBtnSubmit(MouseEvent e) {
                new Start().setVisible(true);
                setVisible(false);
            }

        });
        pnlPanel3.add(btnSubmit);
        
        add(pnlPanel1);
        add(pnlPanel2);
        add(pnlPanel3);
        add(background);

    }

    private Image resizeImage(String url) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(100, 80, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    private Image resizeBackground(String url) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(300, 600, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    public static void main(String[] args) {
        new MenuLogin().setVisible(true);

    }
    private JPanel pnlPanel1;
    private JPanel pnlPanel2;
    private JPanel pnlPanel3;
    private JLabel lblIcon;
    private JLabel lblIcon2;
    private JLabel lblIcon3;
    private JLabel lblIcon4;
    private JButton btnSubmit;
    private JButton btnSubmit3;
    private JTextField txtText1;
    private JTextField txtText2;

}
