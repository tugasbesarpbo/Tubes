/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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

/**
 *
 * @author Christ
 */
public class FrameExample extends JFrame {
    public FrameExample() {
        System.out.println("makanan");
        initComponent();
    }
    
    private Image resizeImage (String url) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
    
    private void initComponent() {
        //size kotak
        this.setSize(500,500);
        
        //untuk koordinat muncul kotaknya
        //setBounds(100,300,200,200); 
        
        //center
        this.setLocationRelativeTo(null);
        
        //background
        this.getContentPane().setBackground(Color.blue);
        this.setTitle("Flappy Birds");
        /*
            bisa kalau tidak dipakai, tapi kalau tidak di pakai maka akan jadi Flow
            setiap kita tmbh border maka dia kana mengikuti arus dan akan tertumpuk ke bawhnya
        */
        //this.setLayout(new BorderLayout());                                     //Border
        
        /*
            1 baris 2 kolom
        */
        //this.setLayout(new GridLayout(1,2));                                    //Grid
        //this.setLayout(new GridLayout(2, 2, 10, 10));                           //Grid
        
        this.setLayout(null);                                                   //Null Layout, JLabel & JTextFile
        //------------------------------------------------------
        pnlPanel1 = new JPanel();
        //                  x  y   x    y
        //pnlPanel1.setBounds(0, 0, 500, 100);                                    //Null layout
        pnlPanel1.setSize(500,150);                                             //Grid, Border, JLabel & JTextField
        pnlPanel1.setBackground(Color.red);
        add(pnlPanel1);                                                         
        //this.add(pnlPanel1, BorderLayout.NORTH);                                //Border
        
        lblMyLabel1 = new JLabel("Name ");                                      //JLabel & JTextField
        //bukan this karena yang mau ditambahkan d panelnya bukan di frame
        pnlPanel1.add(lblMyLabel1);                                             //JLabel & JTextField
        
        txtText1 = new JTextField(20);                                          //JLabel & JTextField
        pnlPanel1.add(txtText1);                                                //JLabel & JTextField
        
        /*
        pnlPanel2 = new JPanel();
        //pnlPanel2.setBounds(0, 400, 500, 100);                                  //Null layout
        pnlPanel1.setSize(500,100);                                             //Grid, Border, JLabel & JTextField
        pnlPanel2.setBackground(Color.black);
        add(pnlPanel2);                                                         
        //this.add(pnlPanel1, BorderLayout.SOUTH);                                //Border
        */
        
        /* Null Layout 2 saja dulu
            pnlPanel3 = new JPanel();
            pnlPanel3.setBounds(0, 0, 500, 100);                                    //Null layout
            //pnlPanel1.setSize(500,100);                                             //Grid, Border
            pnlPanel3.setBackground(Color.cyan);
            add(pnlPanel3);                                                         
            //this.add(pnlPanel1, BorderLayout.SOUTH);                               //Border
        */
        
        lblIcon = new JLabel();                                                 //JLabel & JTextField
        
        lblIcon.setIcon(new ImageIcon(resizeImage("img/bird.png")));            //JLabel & JTextField
        pnlPanel1.add(lblIcon);                                                 //JLabel & JTextField
        
        btnSubmit = new JButton("Submit");                                      //JButton
        btnSubmit.setPreferredSize(new Dimension(200,20));                      //JButton
        pnlPanel1.add(btnSubmit);
    }
    public static void main(String[] args) {
        FrameExample frameExample = new FrameExample();
        
        //new FrameExample().setVisible(true)
        frameExample.setVisible(true);
        
        
    }
    JPanel pnlPanel1 = new JPanel();
    JPanel pnlPanel2 = new JPanel();
    JPanel pnlPanel3 = new JPanel();
    JLabel lblMyLabel1 = new JLabel();
    JLabel lblIcon = new JLabel();
    JButton btnSubmit = new JButton();
    JTextField txtText1 = new JTextField();
    
}
