package classes;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.nio.charset.CoderMalfunctionError;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import classes.*;

public class test {

    private Container c;
    private JFrame frame;
    private Cursor cursor;
    private ImageIcon mallName;
    private JButton userInfo, shopInfo, selfInfo, chngPass, exitButton, backButton;
    private JButton userAdd, userDlt;
    private JButton shopAdd, shopDlt;
    private JLabel details, details1;
    private JTable table1;
    private DefaultTableModel model;
    private JScrollPane scroll1;

    private JTable table;
    private JScrollPane scroll;
    private int tablecount;
    private String type;
    private String typearr[];
    private String size;
    private String sizearr[];
    private String rent;
    private String rentarr[];
    private String quantity;
    private String quantityarr[];
    private String shopno;
    private String shoparr[];
    private String imglink;
    private String imglinkarr[];
    String file;
    String temp;

    public test() {
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Admin Home");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#24292e"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        file = ".\\Data\\all_shops.txt";
        temp = ".\\Data\\temp.txt";

        ImageIcon icon = new ImageIcon("images/market.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        // String file = ".\\file\\user_login.txt";
        try {
            File file = new File(".\\files\\user_login.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(".\\files\\user_login.txt"));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            int totalLines1 = 0;
            for (int j = 0; j < totalLines; j++) {
                String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(j);
                if (line.equals("===============================================")) {
                    totalLines1++;
                }
            }
            totalLines1 = totalLines1 / 2;

            String[] titleCol1 = { "Full Name", "User Name", "Password", "Phone " };
            String[][] titleRow1 = new String[totalLines1][4];

            int k = 0;

            char ch;
            for (int i = 0; i < totalLines; i++) {
                int m = 0;
                String line2 = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get((i));
                if (line2.charAt(0) == 'F') {
                    String fullname = "";
                    for (int f = 0; f < line2.length(); f++) {
                        if (line2.charAt(f) == ':' && line2.charAt(f + 1) == ' ') {
                            for (int p = f + 2; p < line2.length(); p++) {
                                ch = line2.charAt(p);
                                fullname = fullname + ch;
                            }
                            break;
                        }
                    }
                    titleRow1[k][m] = fullname;
                    m++;

                    String username = "";
                    String line3 = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get((i + 1));
                    for (int f = 0; f < line3.length(); f++) {
                        if (line3.charAt(f) == ':' && line3.charAt(f + 1) == ' ') {
                            for (int p = f + 2; p < line3.length(); p++) {
                                ch = line3.charAt(p);
                                username = username + ch;
                            }
                            break;
                        }
                    }
                    titleRow1[k][m] = username;
                    m++;

                    String line4 = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get((i + 2));
                    String password = "";
                    for (int f = 0; f < line4.length(); f++) {
                        if (line4.charAt(f) == ':' && line4.charAt(f + 1) == ' ') {
                            for (int p = f + 2; p < line4.length(); p++) {
                                ch = line4.charAt(p);
                                password = password + ch;
                            }
                            break;
                        }
                    }

                    titleRow1[k][m] = password;
                    m++;

                    String line5 = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get((i + 3));

                    String phone = "";
                    for (int f = 0; f < line5.length(); f++) {
                        if (line5.charAt(f) == ':' && line5.charAt(f + 1) == ' ') {
                            for (int p = f + 2; p < line5.length(); p++) {
                                ch = line5.charAt(p);
                                phone = phone + ch;
                            }
                            break;
                        }
                    }
                    titleRow1[k][m] = phone;
                    k++;
                    i += 5;
                }

            }
            table1 = new JTable(titleRow1, titleCol1);
            table1.setEnabled(false);
            Font tableFont = new Font("Times New Roman", Font.PLAIN, 15);
            table1.setBackground(Color.decode("#ede4d9"));
            table1.setForeground(Color.decode("#24292e"));
            table1.setFont(tableFont);

            scroll1 = new JScrollPane(table1);
            scroll1.setBounds(300, 100, 500, 200);
            frame.add(scroll1);
        } catch (Exception exa) {
            System.out.println(exa);

        }

    }

}
