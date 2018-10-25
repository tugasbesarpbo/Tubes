/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.*;

/**
 *
 * @author Nicholas Zanardi , Christian DY, Juan Wilson , Kezia
 */
public class Main {

    public static void main(String[] args) {
        DataPlayer x = new DataPlayer();
        int pilih = 1;
        Scanner sc = new Scanner(System.in);
        while (pilih != 0) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Daftar Player");
            System.out.println("0. Exit");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    x.loginPlayer();
                    break;
                case 2:
                    x.newPlayer();
                    break;
                case 3:
                    x.printPlayer();
                    break;
                default:
                    pilih = 0;
                    break;
            }
        }
    }
}
