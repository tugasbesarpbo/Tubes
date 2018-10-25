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
public class Burung extends Animal {

    @Override
    public double skill() {
        if (getHitPoints() <= 2) {
            return speed * 1.5;
        } else {
            return speed;
        }
    }

    @Override
    public void live() {
        hitPoints = 5;
    }

}
