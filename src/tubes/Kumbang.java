/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author Lenovo
 */
public class Kumbang extends Animal {

    @Override
    public double skill() {
        if (getHitPoints() <= 3) {
            return speed * 2;
        } else {
            return speed;
        }
    }

    @Override
    public void live() {
        hitPoints = 7;
    }

}
