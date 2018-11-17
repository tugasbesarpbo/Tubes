/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.Main;
import obstacle.Pipe;

/**
 *
 * @author Christ
 */
public class Cat extends Rectangle{
    private final int spd = 6;
    public int yMotion;
    public boolean pressed = false;
    public boolean started, gameOver;
    private BufferedImage sheets = null;
    private ArrayList<Rectangle> pipe;
    
    public Cat(int x, int y, ArrayList<Rectangle> obstacle){  
        setBounds(x, y, 100, 100);
        this.pipe = obstacle;
        
        try {
            sheets = ImageIO.read(new File("Res/cat.png"));
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
            //for (int i = 0; i < 20; i++) {
                if (y <= 0) {
                    y = 0;
                } else {
                    y -= spd;
                }
            //}
            //pressed = false;
        } else {
            y += 4;
            if (y >= 500) {
                y = 500;
            }
        }
        
        //kalau kena obstaclenya game over
        for (int i = 0; i < pipe.size(); i++) {
            //System.out.println("pipe: " + pipe.size());
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
