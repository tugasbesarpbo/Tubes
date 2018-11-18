/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tubes.DataPlayer;

/**
 *
 * @author Lenovo
 */
public class Connection {

    private java.sql.Connection conn;
    private static String server = "jdbc:mysql://localhost/flappybirds";
    private String username = "root";
    private String password = "";

    public Connection() {
    }

    public java.sql.Connection logOn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(server, username, password);
            System.out.println("Koneksi sukses");

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            System.out.println("Koneksi gagal" + e.toString());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
            System.out.println("JDBC.ODBC driver tidak ditemukan");
        }
        return conn;
    }

    public void logOff() {
        try {
            conn.close();
            System.out.println("koneksi close");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static List<DataPlayer> selectDataPlayer(String user, String pass) {
        List<DataPlayer> listDataPlayer = new ArrayList<>();

        Connection conMan = new Connection();
        java.sql.Connection con = conMan.logOn();

        String query = "SELECT user , pass FROM player WHERE user = " + user + " AND pass = " + pass;
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DataPlayer b = new DataPlayer();
                b.setUser(rs.getString("user"));
                b.setPass(rs.getString("pass"));

                listDataPlayer.add(b);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }

        conMan.logOff();
        return listDataPlayer;
    }

    public static void insertData(DataPlayer b) {
        Connection conMan = new Connection();
        java.sql.Connection con = conMan.logOn();

        try {
            String query = "insert into (user,pass)"
                    + "value ('" + b.getUser() + "','" + b.getPass() + "')";
            System.out.println(query);
            Statement st = con.createStatement();
            boolean rs = st.execute(query);

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
        conMan.logOff();
    }

    public static void main(String[] args) {
        Connection conManager = new Connection();
        conManager.logOn();
    }

}
