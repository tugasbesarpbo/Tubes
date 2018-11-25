/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import main.Main;
import static main.Main.HEIGHT;
import obstacle.Pipe;
import jframe.Home;
import main.Frame;
import static main.Main.HEIGHT;
import static main.Main.WIDTH;
import static main.Main.icon;
import static animal.ChooseAnimal.choose;
/**
 *
 * @author Christ
 */
public class Icon extends Rectangle{
    public boolean pressed = false;
    public static boolean gameOver = false;
    
    private BufferedImage sheets = null;
    private ArrayList<Rectangle> pipe;
    
    private final int spd = 6;
    private String img;
    
    public Icon(int x, int y, ArrayList<Rectangle> obstacle){  
        setBounds(x, y, 100, 100);
        this.pipe = obstacle;
        
        if (choose == 1) {
            img = "img/cat.png";
        } else if (choose == 2) {
            img = "img/cat2.png";
        }
        
        try {
            sheets = ImageIO.read(new File(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sheets == null){
            System.out.println("sheets is null");
        }
    }
    
    //utk gerak
    public void update(){
        if (pressed) {
            if (y <= 0) {
                y = 0;
            } else {
                y -= spd;
            }
        } else {
            y += 4;
            if (y >= 500) {
                y = 500;
            }
        }
        
        //kalau kena obstaclenya game over
        int i = 0;
        
        while (i < pipe.size() && !gameOver) {
            if (this.intersects(pipe.get(i))) {  
                System.out.println("gameover");
                gameOver = true;
                Main.pipe = new Pipe(80);
                pipe = Main.pipe.pipes;
                y = Main.HEIGHT/2;
                Main.score = 0;
            }
            i++;
        } 
    }
    
    public void render(Graphics g){
        g.drawImage(sheets, x, y, width, height, null);
    }
}
