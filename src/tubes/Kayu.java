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
public class Kayu extends Obstacle {

    @Override
    public void effects() {
        status = setStatus("haste");
    }

}
