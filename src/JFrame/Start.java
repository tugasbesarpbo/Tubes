/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.WindowConstants;

/**
 *
 * @author Lenovo
 */
public class Start extends JFrame {

    public Start() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flabby Animal");
        setSize(300, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

//        pnlPanel = new JPanel();
//        pnlPanel.setSize(300, 600);
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(resizeBackground("img/background.jpg")));
        background.setLayout(new FlowLayout());
//        add(background);

        pnlPanel1 = new JPanel();
        pnlPanel1.setSize(100, 100);
        pnlPanel1.setLocation(100, 50);
        lblIcon = new JLabel();
        lblIcon.setIcon(new ImageIcon(resizeImage("img/Flappy_Logo.png")));
        pnlPanel1.add(lblIcon);
        add(pnlPanel1);

//        lblIcon = new JLabel();
//        lblIcon.setIcon(new ImageIcon(resizeImage("img/Flappy_Logo.png")));
//        lblIcon.setLocation(0, 300);
//        background.add(lblIcon);
        pnlPanel2 = new JPanel();
        pnlPanel2.setSize(210, 90);
        pnlPanel2.setLocation(50, 400);
        btnSubmit3 = new JButton("");
        btnSubmit3.setPreferredSize(new Dimension(100, 100));
        btnSubmit3.setIcon(new ImageIcon(resizeImage("img/login.jpg")));
        btnSubmit3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                onClickBtnSubmit(e);
            }

            private void onClickBtnSubmit(MouseEvent e) {
                new MenuLogin().setVisible(true);
                setVisible(false);
            }

        });

        pnlPanel2.add(btnSubmit3);

        btnSubmit2 = new JButton("");
        btnSubmit2.setPreferredSize(new Dimension(100, 100));
        btnSubmit2.setIcon(new ImageIcon(resizeImage("img/register.jpg")));
        pnlPanel2.add(btnSubmit2);
        add(pnlPanel2);

        pnlPanel3 = new JPanel();
        pnlPanel3.setSize(100, 90);
        pnlPanel3.setLocation(100, 300);
        btnSubmit = new JButton("");
        btnSubmit.setPreferredSize(new Dimension(100, 100));
        btnSubmit.setIcon(new ImageIcon(resizeImage("img/play_button.png")));
        pnlPanel3.add(btnSubmit);
        add(pnlPanel3);
//        btnSubmit = new JButton("");
//        btnSubmit.setPreferredSize(new Dimension(100, 100));
//        btnSubmit.setIcon(new ImageIcon(resizeImage("img/play_button.png")));
//        btnSubmit.setLocation(150, 250);
//        background.add(btnSubmit);
//        btnSubmit3 = new JButton("");
//        btnSubmit3.setPreferredSize(new Dimension(100, 100));
//        btnSubmit3.setIcon(new ImageIcon(resizeImage("img/login.jpg")));
//        btnSubmit3.setLocation(300, 250);
//        background.add(btnSubmit3);
//        btnSubmit2 = new JButton("");
//        btnSubmit2.setPreferredSize(new Dimension(100, 100));
//        btnSubmit2.setIcon(new ImageIcon(resizeImage("img/register.jpg")));
//        btnSubmit2.setLocation(300, 450);
//        background.add(btnSubmit2);
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

//    public Image setBackground(String url) {
//        // Read the image and place it in the variable img so it can be used in paintComponent
//        img = Toolkit.getDefaultToolkit().createImage(url);
//        return img;
//    }
//
//    public void paintComponent(Graphics g) {
//        g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // draw the image
//    }
    public static void main(String[] args) {
        new Start().setVisible(true);
    }
    private JPanel pnlPanel;
    private JPanel pnlPanel1;
    private JPanel pnlPanel2;
    private JPanel pnlPanel3;
    private JPanel pnlPanel4;
    private JLabel lblIcon;
    private JLabel lblIcon2;
    private JButton btnSubmit;
    private JButton btnSubmit2;
    private JButton btnSubmit3;

}
