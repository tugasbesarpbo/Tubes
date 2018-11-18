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

<<<<<<< HEAD
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    

    public void newPlayer() {
        DataPlayer dataPlayer = new DataPlayer();
        cekLogin = 1;
        tempat = 0;
        while (cekLogin == 1) {
            System.out.println("Username: ");
            user = sc.nextLine();
            System.out.println("Password : ");
            pass = sc.nextLine();
//            System.out.println(listPlayer.size());
            if (!listPlayer.isEmpty()) {
                for (int i = 0; i < listPlayer.size(); i++) {
                    if (listPlayer.get(i).nama.equals(user)) {
                        cekLogin = 1;
                        tempat = i;
                    } else {
                        cekLogin = 0;
                    }
                }
            } else {
                cekLogin = 0;
            }
            if (cekLogin == 1) {
                System.out.println("Username sudah dipakai! Silahkan isi ulang");
            }
        }
        dataPlayer.setNama(user);
        dataPlayer.setPass(pass);
        listPlayer.add(dataPlayer);
        System.out.println("Username anda : " + listPlayer.get(tempat).nama);
=======
    public void newPlayer(){
        //LL
>>>>>>> cd08890d8d23cee7a5888d765b98c2ee06914ad8
    }
   
}
