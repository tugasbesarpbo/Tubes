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
import animal.Icon;
import java.io.File;
import obstacle.Pipe;
import animal.ChooseAnimal;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Nicholas Zanardi , Christian DY, Juan Wilson , Kezia interface blom
 * tau , mau konsul lagi
 */
public class Main extends Canvas implements Runnable,KeyListener,MouseListener{
    private static final long serialVersionUID = 3196520274556633778L;
    public static final int WIDTH = 400, HEIGHT = 600;

    private BufferedImage background= null; 
    private Thread thread;
    private Random r;
    private boolean running = false;
    private int choose = ChooseAnimal.choose;
    
    public static Pipe pipe;
    public static Icon icon;
    public static int up = 0;
    public static double score = 0;
    
    public Frame frame;
    
    public Main(){  
        r = new Random();
        addKeyListener(this);
        addMouseListener(this);
        BufferedImage sheets = null;
        
        try {
            background = ImageIO.read(new File("img/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        pipe = new Pipe(80);
        
        
        icon = new Icon(10, Main.HEIGHT/2, pipe.pipes);
        System.out.println("stat1: " + icon.gameOver);
        frame = new Frame(WIDTH, HEIGHT, this);
        
        
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
        long timer = System.currentTimeMillis();
        double amountOFTicks = 60.0;
        double ns = 1000000000 / amountOFTicks;
        double delta = 0;
        
        while(running && icon.gameOver == false){
            
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
                frames = 0;
            }
        }
        System.out.println("stat2: " + icon.gameOver);
        if (icon.gameOver == true) {
            System.out.println("masuk");
            int confirm = JOptionPane.showConfirmDialog(null, "Game Over! Ulang?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                frame.setVisible(false);
                new ChooseAnimal().setVisible(true);
                icon.gameOver = false;
            } else {
                JOptionPane.showMessageDialog(null, "Terima kasih telah bermain!");
                System.exit(0);
            }
        }
    }
    
    private void update(){
        pipe.update();
        icon.update();
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
        icon.render(g);
        g.dispose();
        bs.show();
    }
    
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
            icon.pressed = true;
            //System.out.println("press");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
            icon.pressed = false;
                
            //System.out.println("release");
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
