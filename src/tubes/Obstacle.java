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
public abstract class Obstacle extends Tubes {

    public int lokasi_x, lokasi_y;
    public int damage = 1;
    public  String status;

    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage() {
        this.damage = damage;
    }
    

    public int getLokasi_x() {
        return lokasi_x;
    }

    public void setLokasi_x(int lokasi_x) {
        this.lokasi_x = lokasi_x;
    }

    public int getLokasi_y() {
        return lokasi_y;
    }

    public void setLokasi_y(int lokasi_y) {
        this.lokasi_y = lokasi_y;
    }
    public abstract void effects ();

}
