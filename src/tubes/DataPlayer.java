/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.Scanner;

/**
 *
 * @author Lenovo Data Player bisa ada abstract
 */
public class DataPlayer extends Tubes {

    public int score;
    
    public int hitungScore(int count){
        return count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void newPlayer(){
        //LL
    }
   
}
