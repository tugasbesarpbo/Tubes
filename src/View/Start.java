/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import javax.swing.JOptionPane;
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
        int screen_height = 600;
        int screen_width = 400;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flabby Animal");
        setSize(screen_width, screen_height);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(resizeImage("img/background.jpg", screen_width, screen_height)));
        add(background);

        pnlPanel1 = new JLabel();
        pnlPanel1.setBounds(70, 50, 270, 100);
        pnlPanel1.setOpaque(false);
        pnlPanel1.setIcon(new ImageIcon(resizeImage("img/Flappy_Logo.png", 270, 100)));
        background.add(pnlPanel1);

        pnlPanel2 = new JButton();
        pnlPanel2.setBounds(30, 300, 120, 55);
        pnlPanel2.setOpaque(false);
        pnlPanel2.setPreferredSize(new Dimension(100, 80));
        pnlPanel2.setIcon(new ImageIcon(resizeImage("img/login.png", 120, 55)));
        pnlPanel2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                onClickBtnSubmit(e);
            }

            private void onClickBtnSubmit(MouseEvent e) {
                new MenuLogin().setVisible(true);
                setVisible(false);
            }

        });

        background.add(pnlPanel2);

        pnlPanel4 = new JButton();
        pnlPanel4.setBounds(230, 300, 120, 55);
        pnlPanel4.setPreferredSize(new Dimension(100, 80));
        pnlPanel4.setIcon(new ImageIcon(resizeImage("img/register.png", 120, 55)));

        background.add(pnlPanel4);

        pnlPanel3 = new JButton();
        pnlPanel3.setBounds(280, 545, 120, 55);
        pnlPanel3.setOpaque(false);
        pnlPanel3.setIcon(new ImageIcon(resizeImage("img/exit.png", 120, 55)));
        pnlPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int x = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit ?", "",
                        JOptionPane.YES_NO_OPTION);

                if (x == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    setVisible(false);
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                }
            }

        });
        background.add(pnlPanel3);

    }

    private Image resizeImage(String url, int x, int y) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    public static void main(String[] args) {
        new Start().setVisible(true);
    }
    private JLabel pnlPanel;
    private JLabel pnlPanel1;
    private JButton pnlPanel2;
    private JButton pnlPanel3;
    private JButton pnlPanel4;
    private JLabel lblIcon;
    private JLabel lblIcon2;
    private JButton btnSubmit;
    private JButton btnSubmit2;
    private JButton btnSubmit3;

}
