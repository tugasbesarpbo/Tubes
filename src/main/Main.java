/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import jframe.Home;
import animal.Bird;
import animal.Cat;
import java.io.File;
import obstacle.Pipe;
import animal.ChooseAnimal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author Nicholas Zanardi , Christian DY, Juan Wilson , Kezia interface blom
 * tau , mau konsul lagi
 */
public class Main extends Canvas implements Runnable,KeyListener,MouseListener{

    private static final long serialVersionUID = 3196520274556633778L;
    public static final int WIDTH = 400, HEIGHT = 600;
    public static int up = 0;

    private Thread thread;
    private Random r;
    public static Pipe pipe;
    public static Bird bird;
    public static Cat cat;

    private BufferedImage background= null; 
    public static double score=0;
    private boolean running = false;
    private int choose = ChooseAnimal.choose;
    public Main(){  
        r = new Random();
        addKeyListener(this);
        addMouseListener(this);
        BufferedImage sheets = null;
        
        try {
            background = ImageIO.read(new File("Res/background.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        pipe = new Pipe(80);
        
        System.out.println("Choose : " + choose);
        if (choose == 1) {
             cat = new Cat(10, Main.HEIGHT/2, pipe.pipes);
        } else if (ChooseAnimal.choose == 2) {
            bird = new Bird(10, Main.HEIGHT/2, pipe.pipes);
        }
        new Frame(WIDTH, HEIGHT, this);
    }  

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        //gameloop
        int frames = 0;
        long lastTime = System.nanoTime();
        double amountOFTicks = 60.0;
        double ns = 1000000000 / amountOFTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                render();
                
                delta--;
                frames++;
            }

            if(System.currentTimeMillis() - timer >= 1000){
                timer += 1000;
                //System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
    }

    private void update(){
        pipe.update();
        if (choose == 1) {
            cat.update();
        } else if (choose == 2) {
            bird.update();
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        
        //Font "Score"
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        
        //nampilin score
        g.drawString("Score : " + (int)score, 50, 50);
        
        pipe.render(g);
        if (choose == 1) {
            cat.render(g);
        } else if (choose == 2) {
            bird.render(g);
        }
        g.dispose();
        bs.show();
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
            if (choose == 1) {
                cat.pressed = true;
            } else if (choose == 2) {
                bird.pressed = true;
            }
            System.out.println("press");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
            if (choose == 1) {
                cat.pressed = false;
            } else if (choose == 2) {
                bird.pressed = false;
            }
            System.out.println("release");
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Main().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (choose == 1) {
            cat.pressed = true;
        } else if (choose == 2) {
            bird.pressed = true;
        }
        System.out.println("press");
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
