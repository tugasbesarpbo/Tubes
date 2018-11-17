/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import tubes.Music;
import main.Main;

/**
 *
 * @author Lenovo
 */
public class Pipe {

    private int  time;
	private int currentTime = 0;
	private int speed = 5;
	public ArrayList <Rectangle> pipes;
	int y;
	int width, height;
	int heightPipesBot, heightPipesTop;
	
	private final int WIDTH_PIPES = 50;
	private final int SPACE_PIPES = 150;
	
	private Random random;
	private BufferedImage texture = null;
	private BufferedImage texture2 = null;
	private Music music;
	public Pipe(int time){
		pipes = new ArrayList<>();
		this.time = time;
		random = new Random();
		music = new Music("/jump.wav");
		try {
			texture2 = ImageIO.read(new File("Res/pipe2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalStateException("why my image wood is null", e);
		}
	}
	
	public void update(){
            currentTime++;
            if(currentTime == time){
                currentTime=0;
                
                //tinggi tube bawah yang random
                heightPipesTop = random.nextInt(Main.HEIGHT/2);
                
                y = heightPipesTop + SPACE_PIPES;
                
                //tinggi tube bawah
                heightPipesBot = Main.HEIGHT - y;
                
                //nambah tube atas
                pipes.add(new Rectangle(Main.WIDTH, -50, WIDTH_PIPES, heightPipesTop));
                
                //nambah tube bawah
                pipes.add(new Rectangle(Main.WIDTH, y, WIDTH_PIPES, heightPipesBot));
            }

            for(int i = 0; i < pipes.size(); i++){
                Rectangle rect = pipes.get(i);
                
                //code buat tubesnya jalan
                rect.x -= speed;

                if(rect.x + rect.width <= 0){
                    pipes.remove(i--);
                }
                if(rect.x == 300){
                    //music.play();
                    Main.score += 0.5;
                }
                continue;
            }
	}
        
	public void render(Graphics g){
            for(int i = 0; i < pipes.size(); i++){
                Rectangle rect = pipes.get(i);
                g.drawImage(texture2, rect.x, rect.y, rect.width, rect.height, null);
            }
	}

}
