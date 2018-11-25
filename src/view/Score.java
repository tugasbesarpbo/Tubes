/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
/**
 *
 * @author WaduHek
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
 
public class Score extends JFrame {
   private JTable tabel;
   private TableColumn tc1 = new TableColumn();
   private TableColumn tc2 = new TableColumn();
   private JLabel score = new JLabel("SCORE");
   private DefaultTableModel model;
   private JScrollPane scrollPane;
 
    public Score(){
        setVisible(true);
        int screen_height = 600;
        int screen_width = 400;
        this.setTitle("Flappy Animal");
        this.setSize(screen_width, screen_height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container konten = getContentPane();
 
        String field[] = {"Nama","Score"}; //Membuat Nama Field
        String record[][] ={{,}};  //Membuat recordnya dengan metode array dua dimensi
 
        konten.setLayout(null);
        model = new DefaultTableModel(record,field); // set Model Tabel
        tabel = new JTable(model);
 
        tc1 = tabel.getColumnModel().getColumn(0); //Menampilkan isi kolom 0
        tc2 = tabel.getColumnModel().getColumn(1); //Menampilkan isi kolom 1

        tc1.setPreferredWidth(50); //set lebar kolom 0
        tc2.setPreferredWidth(150);//set lebar kolom 1
        
        tabel.setGridColor(Color.GREEN); //Memberi warna garis tabel
 
        score.setForeground(Color.BLUE);
        score.setBounds(200,10,200,25);
        konten.add(score);
        scrollPane = new JScrollPane(tabel);
        scrollPane.setBounds(20,50,550,200);
        konten.add(scrollPane);
    }
 
    public static void main (String[] arr) {
        new Score();
    }
 
}