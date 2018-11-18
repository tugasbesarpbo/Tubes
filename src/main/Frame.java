package main;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import animal.Bird;

public class Frame extends JFrame{

	/**
	 * 
	 */
    private static final long serialVersionUID = -4810618286807932601L;
    public Frame(int width,int height,Main game){
            this.setPreferredSize(new Dimension(width,height));
            this.setMaximumSize(new Dimension(width,height));
            this.setMinimumSize(new Dimension(width,height));

            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.add(game);
            game.start();
    }
}
