/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import View.Start;
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
        lblBackground.setIcon(new ImageIcon(resizeImage("Res/background.jpg",screen_width,screen_height)));
        this.add(lblBackground);
        
        lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(resizeImage("Res/Flappy_Logo.png",270,100)));
        lblLogo.setBounds(70, 50, 270, 100);
        lblBackground.add(lblLogo);
        
        btnPlay = new JLabel();
        btnPlay.setIcon(new ImageIcon(resizeImage("Res/play_button.png",120,55)));
        btnPlay.setBounds(140, 300, 120, 55);
        btnPlay.addMouseListener(new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent me) {
                //btnNameMouseClicked();
                btnPlay();
            }            
        });
        lblBackground.add(btnPlay);
        
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
    //JLabel lblIcon = new JLabel();
}
