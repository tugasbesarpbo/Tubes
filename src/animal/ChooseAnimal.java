/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import main.Main;

/**
 *
 * @author Christ
 */
public class ChooseAnimal extends JFrame{
    public static int choose = 0;
    
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
    
    public ChooseAnimal(){
        initComponent();
    }
    
    private void initComponent(){
        int screen_height = 600;
        int screen_width = 400;
        this.setTitle("Choose Animal");
        this.setSize(screen_width, screen_height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        lblBackground = new JLabel();
        lblBackground.setIcon(new ImageIcon(resizeImage("img/background.jpg",screen_width,screen_height)));
        this.add(lblBackground);
        
        iconCat = new JLabel();
        iconCat.setIcon(new ImageIcon(resizeImage("img/cat.png", 100, 100)));
        iconCat.setBounds(45, 225, 100, 100);
        lblBackground.add(iconCat);
        
        btnCat = new JButton("Cat");
        btnCat.setBounds(45, 300, 100, 30);
        btnCat.setBackground(Color.LIGHT_GRAY);
        btnCat.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                choose = chooseCat();
                btnCat.setBackground(Color.cyan);
                btnCatChristmas.setBackground(Color.LIGHT_GRAY);
            }
            
        });
        lblBackground.add(btnCat);
        
        iconCatChristmas = new JLabel();
        iconCatChristmas.setIcon(new ImageIcon(resizeImage("img/cat2.png", 80, 80)));
        iconCatChristmas.setBounds(269, 234, 80, 80);
        lblBackground.add(iconCatChristmas);
        
        btnCatChristmas = new JButton("Cat Christmas");
        btnCatChristmas.setBounds(255, 300, 100, 30);
        btnCatChristmas.setBackground(Color.LIGHT_GRAY);
        btnCatChristmas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                choose = chooseBird();
                btnCatChristmas.setBackground(Color.cyan);
                btnCat.setBackground(Color.LIGHT_GRAY);
            }
            
        });
        lblBackground.add(btnCatChristmas);
        
        btnOK = new JLabel();
        btnOK.setIcon(new ImageIcon(resizeImage("img/button_ok.png", 100, 30)));
        btnOK.setBounds(150, 470, 100, 30);
        btnOK.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                btnClickedOK();
            }
        });
        lblBackground.add(btnOK);
    }
    
    private void btnClickedOK(){
        if (choose != 0) {
            this.setVisible(false);
            new Main().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Kamu belum memilih animal!");
        }
    }
    
    public int chooseBird(){
        return 2;
    }
    
    public int chooseCat(){
        return 1;
    }
    
    public static void main(String[] args) {
        new ChooseAnimal().setVisible(true);
    }    
    
    private JLabel lblBackground;
    private JLabel iconCat;
    private JButton btnCat;
    private JLabel iconCatChristmas;
    private JButton btnCatChristmas;
    private JLabel btnOK;
    
}
