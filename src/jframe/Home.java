/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Main;
import animal.ChooseAnimal;
import view.Start;


/**
 *
 * @author Lenovo
 */
public class Home extends JFrame{    
    private Image resizeImage (String url,int x,int y) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
    
    public Home () {
        initComponent();
    }
    
    private void initComponent () {
        int screen_height = 600;
        int screen_width = 400;
        this.setTitle("Flappy Animal");
        this.setSize(screen_width, screen_height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        lblBackground = new JLabel();
        lblBackground.setIcon(new ImageIcon(resizeImage("img/background.jpg",screen_width,screen_height)));
        this.add(lblBackground);
        
        lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(resizeImage("img/Flappy_Logo.png",270,100)));
        lblLogo.setBounds(70, 50, 270, 100);
        lblBackground.add(lblLogo);
        
        btnPlay = new JLabel();
        btnPlay.setIcon(new ImageIcon(resizeImage("img/play_button.png",120,55)));
        btnPlay.setBounds(140, 300, 120, 55);
        btnPlay.addMouseListener(new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent me) {
                //btnNameMouseClicked();
                btnPlay();
            }            
        });
        lblBackground.add(btnPlay);
        
        btnExit = new JButton();
        btnExit.setBounds(280, 520, 120, 55);
        btnExit.setOpaque(false);
        btnExit.setIcon(new ImageIcon(resizeImage("img/exit.png", 120, 55)));
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickBtnSubmit(e);
            }

            private void onClickBtnSubmit(MouseEvent e) {
                new Start().setVisible(true);
                setVisible(false);
            }

        });
        lblBackground.add(btnExit);
        
    }
    
    private void btnPlay () {
        this.setVisible(false);
        new ChooseAnimal().setVisible(true);
    }
    
    public static void main(String[] args) {
        new Home().setVisible(true);
    }
    
    private JLabel lblBackground;
    private JLabel btnPlay;
    private JLabel lblLogo;
    private JLabel cat;
    private JButton btnExit;
    //JLabel lblIcon = new JLabel();
}
