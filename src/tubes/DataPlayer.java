/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo Data Player bisa ada abstract
 */
public class DataPlayer extends Tubes {

    public int score;
    public String user = "";
    public String pass = "";
    public int cekLogin = 0;
    public int pilih = 1;
    public int count = 0;
    public int tempat = 0;

    ArrayList<DataPlayer> listPlayer = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public int hitungScore(int count) {
        return count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
    }

    public void loginPlayer() {
        System.out.print("Username: ");
        user = sc.nextLine();
        System.out.println("Password : ");
        pass = sc.nextLine();
        for (int i = 0; i < listPlayer.size(); i++) {
            if (listPlayer.get(i).nama.equals(user) && listPlayer.get(i).pass.equals(pass)) {
                cekLogin = 1;
                System.out.println("Berhasil Login !");
            }
        }
        if (cekLogin == 1) {

            //untuk masuk ke gamenya
        }else {
            System.out.println("Login Gagal! ");
        }
    }

    public void printPlayer() {
        System.out.println("------------------------------");
        System.out.println("Top 2 : ");
        System.out.println("1. " + listPlayer.get(0).nama);
        System.out.println("2. " + listPlayer.get(1).nama);
        System.out.println("------------------------------");
    }

}
