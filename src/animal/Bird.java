/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import obstacle.Pipe;
import main.Main;

/**
 *
 * @author Lenovo
 */
public class Bird extends Rectangle{
    private final int spd = 6;
    public boolean pressed = false;
    private BufferedImage sheets = null;
    private ArrayList<Rectangle> pipe;
    
    public Bird(int x, int y, ArrayList<Rectangle> obstacle){  
        setBounds(x, y, 100, 100);
        this.pipe = obstacle;
        
        try {
            sheets = ImageIO.read(new File("img/bird.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(sheets == null){
            System.out.println("sheets is null");
        }
    }
    
    public void update(){
        if (pressed) {
            if (y <= 0) {
                y = 0;
            } else {
                y -= spd;
            }
        } else {
            y += spd/2;
            if (y >= 500) {
                y = 500;
            }
        }
        
        //kalau kena obstaclenya game over
        for (int i = 0; i < pipe.size(); i++) {
            if (this.intersects(pipe.get(i))) {  
                Main.pipe = new Pipe(80);
                pipe = Main.pipe.pipes;
                y = Main.HEIGHT/2;
                Main.score = 0;
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(sheets, x, y, width, height, null);

    }
}
