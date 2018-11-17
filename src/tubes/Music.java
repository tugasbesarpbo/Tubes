/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author Lenovo
 */
public class Music {
    private AudioClip clip;
	
    public Music(String path){
        //clip = Applet.newAudioClip(getClass().getResource(path));
    }
    public void play(){
        new Thread(){
                public void run(){
                        clip.play();
                }
        }.start();
    }
}
