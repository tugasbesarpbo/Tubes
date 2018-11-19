/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import jframe.Home;
import tubes.DataPlayer;

/**
 *
 * @author Lenovo
 */
public class MenuLogin extends JFrame {

    public MenuLogin() {
        initComponents();
    }

    private void initComponents() {
        int screen_height = 600;
        int screen_width = 400;

        setSize(screen_width, screen_height);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Flabby Animal");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(resizeImage("img/background.jpg", screen_width, screen_height)));
        add(background);

        pnlPanel1 = new JLabel();
        pnlPanel1.setBounds(70, 50, 270, 100);
        pnlPanel1.setOpaque(false);
        pnlPanel1.setIcon(new ImageIcon(resizeImage("img/login_title.png", 270, 100)));
        background.add(pnlPanel1);

        pnlPanel2 = new JPanel();
        pnlPanel2.setSize(screen_width, 150);
        pnlPanel2.setLocation(0, 200);
        pnlPanel2.setOpaque(false);
        lblIcon2 = new JLabel("Username : ");
        pnlPanel2.add(lblIcon2);
        txtText1 = new JTextField(25);
        pnlPanel2.add(txtText1);
        lblIcon3 = new JLabel("Password : ");
        pnlPanel2.add(lblIcon3);
        txtText2 = new JPasswordField(25);
        pnlPanel2.add(txtText2);
        btnSubmit3 = new JButton("Submit");
        btnSubmit3.setPreferredSize(new Dimension(100, 30));
        btnSubmit3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                onClickBtnSubmit(e);
            }

            public void onClickBtnSubmit(MouseEvent e) {
                user = txtText1.getText();
                pass = txtText2.getText();
                txtText1.setText("");
                txtText2.setText("");

                List<DataPlayer> listPlayer = Dao.Connection.selectDataPlayer(user, pass);

                //cek list
                for (DataPlayer barang : listPlayer) {
                    System.out.println(barang.getUser());
                }
                
                if (listPlayer == null) {
                    //ke register
                    new MenuRegister().setVisible(true);
                    setVisible(false);
                } else {
                    //ke game
                    new Home().setVisible(true);
                    setVisible(false);
                }

            }
        });

        pnlPanel2.add(btnSubmit3);
        background.add(pnlPanel2);

        pnlPanel3 = new JButton();
        pnlPanel3.setBounds(280, 545, 120, 55);
        pnlPanel3.setOpaque(false);
        pnlPanel3.setIcon(new ImageIcon(resizeImage("img/exit.png", 120, 55)));
        pnlPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickBtnSubmit(e);
            }

            private void onClickBtnSubmit(MouseEvent e) {
                new Start().setVisible(true);
                setVisible(false);
            }

        });
        background.add(pnlPanel3);
    }

    private Image resizeImage(String url, int x, int y) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    public static void main(String[] args) {
        new MenuLogin().setVisible(true);

    }
    private JLabel pnlPanel1;
    private JPanel pnlPanel2;
    private JButton pnlPanel3;
    private JLabel lblIcon;
    private JLabel lblIcon2;
    private JLabel lblIcon3;
    private JLabel lblIcon4;
    private JButton btnSubmit;
    private JButton btnSubmit3;
    private JTextField txtText1;
    private JPasswordField txtText2;
    private String user;
    private String pass;

}
