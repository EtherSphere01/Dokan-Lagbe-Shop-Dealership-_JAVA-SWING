package classes;

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.nio.charset.CoderMalfunctionError;
import java.nio.file.*;
import classes.*;

public class Skip implements ActionListener {
    private JFrame frame;
    private Container c;
    private Cursor cursor;
    private ImageIcon mallName;
    private JTable table;
    private JScrollPane scroll;
    private JComboBox combobox;
    private JLabel imgLabel2;
    private int tablecount;
    private JPanel panel2;
    private JLabel lblText1, lblText2, lblText3, lblText4, lblText5, lblText6;
    private JLabel label;
    private JButton confirmButton;
    private JButton exitButton;
    private JButton backButton;
    private JButton logoutButton;

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
    private String userList;
    private int count;
    private int count2;

    public Skip() {
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Available Shops");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#24292e"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("images/market.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        label = new JLabel("<----Choose to See Individual Shop Details");
        label.setVisible(true);
        label.setBounds(205, 217, 500, 60);
        label.setForeground(Color.decode("#ede4d9"));
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 20);
        label.setFont(labelFont);
        frame.add(label);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        mallName = new ImageIcon("images/welcome3.png");
        JLabel imgLabel = new JLabel(mallName);
        imgLabel.setBounds(310, 5, mallName.getIconWidth(), mallName.getIconHeight());
        frame.add(imgLabel);

        // creating table
        JLabel details = new JLabel("Available Shops");
        details.setBounds(360, 30, 250, 60);
        Font detailsFont = new Font("Times New Roman", Font.PLAIN, 20);
        details.setFont(detailsFont);
        details.setForeground(new Color(215, 210, 203));
        frame.add(details);

        try {
            File file = new File(".\\files\\all_shops.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner input = new Scanner(file);

            BufferedReader readFile1 = new BufferedReader(new FileReader(".\\files\\all_shops.txt"));
            int totalLines1 = 0;
            int count2 = 0;
            while (readFile1.readLine() != null) {
                count2++;
            }

            readFile1.close();

            for (int j = 0; j < count2; j++) {
                String line = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(j);
                if (line.equals("Shop Details")) {
                    totalLines1++;
                }
            }
            tablecount = totalLines1;

            String titleCol[] = { "Type", "Size(square feet)", "Shop Number", "Rent(TK)", "Place" };
            String titleRow[][] = new String[totalLines1][5];

            typearr = new String[totalLines1];

            sizearr = new String[totalLines1];
            rentarr = new String[totalLines1];

            quantityarr = new String[totalLines1];

            shoparr = new String[totalLines1];

            imglinkarr = new String[totalLines1];

            String[] combolist = new String[totalLines1 + 1];
            combolist[0] = "Choose here";
            int i = 0;
            int k = 1;

            BufferedReader readFile3 = new BufferedReader(new FileReader(".\\files\\all_shops.txt"));

            // for admin
            int totalLines3 = 0;
            while (readFile3.readLine() != null) {
                totalLines3++;
            }
            readFile3.close();

            for (int l = 0; l < totalLines3; l++) {

                String line = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(l);
                if (line.equals("Shop Details")) {
                    String line2 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get((l + 1));
                    String line3 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get((l + 2));
                    String line4 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get((l + 3));
                    String line5 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get((l + 4));
                    String line6 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get((l + 5));
                    String line7 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get((l + 6));
                    int j = 0;
                    type = line2;
                    titleRow[i][j] = type;
                    typearr[i] = type;
                    combolist[k] = type;
                    k++;
                    ++j;

                    size = line3;
                    titleRow[i][j] = size;
                    sizearr[i] = size;
                    ++j;

                    shopno = line4;
                    titleRow[i][j] = shopno;
                    shoparr[i] = shopno;
                    ++j;

                    rent = line5;
                    titleRow[i][j] = rent;
                    rentarr[i] = rent;
                    ++j;

                    quantity = line6;
                    titleRow[i][j] = quantity;
                    quantityarr[i] = quantity;
                    ++j;

                    imglink = line7;
                    imglinkarr[i] = imglink;
                    i++;
                    l += 5;
                }
            }

            table = new JTable(titleRow, titleCol);
            table.setEnabled(false);
            Font tableFont = new Font("Times New Roman", Font.PLAIN, 15);
            table.setBackground(Color.decode("#ede4d9"));
            table.setForeground(Color.decode("#24292e"));
            table.setFont(tableFont);

            scroll = new JScrollPane(table);
            scroll.setBounds(0, 80, 835, 110);
            frame.add(scroll);

            JLabel question = new JLabel("Select a shop for rent");
            question.setBounds(1, 200, 250, 30);
            Font questionFont = new Font("Times New Roman", Font.PLAIN, 17);
            question.setFont(questionFont);
            question.setForeground(new Color(215, 210, 203));
            frame.add(question);

            combobox = new JComboBox(combolist);
            combobox.setBounds(1, 235, 185, 30);
            Font comboboxFont = new Font("Times New Roman", Font.PLAIN, 16);
            combobox.setFont(comboboxFont);
            combobox.setBackground(Color.decode("#ede4d9"));
            combobox.setForeground(Color.decode("#24292e"));
            frame.add(combobox);

            lblText1 = new JLabel();
            lblText1.setBounds(0, 0, 360, 60);
            lblText1.setForeground(Color.decode("#ede4d9"));
            Font lblText1Font = new Font("Times New Roman", Font.PLAIN, 18);
            lblText1.setFont(lblText1Font);

            lblText2 = new JLabel();
            lblText2.setBounds(0, 30, 360, 60);
            lblText2.setForeground(Color.decode("#ede4d9"));
            Font lblText2Font = new Font("Times New Roman", Font.PLAIN, 18);
            lblText2.setFont(lblText2Font);

            lblText3 = new JLabel();
            lblText3.setBounds(0, 90, 360, 60);
            lblText3.setForeground(Color.decode("#ede4d9"));
            Font lblText3Font = new Font("Times New Roman", Font.PLAIN, 18);
            lblText3.setFont(lblText3Font);

            lblText4 = new JLabel();
            lblText4.setBounds(0, 60, 360, 60);
            lblText4.setForeground(Color.decode("#ede4d9"));
            Font lblText4Font = new Font("Times New Roman", Font.PLAIN, 18);
            lblText4.setFont(lblText4Font);

            lblText5 = new JLabel();
            lblText5.setBounds(0, 150, 360, 60);
            lblText5.setForeground(Color.white);
            Font lblText5Font = new Font("Times New Roman", Font.PLAIN, 19);
            lblText5.setFont(lblText5Font);

            lblText6 = new JLabel();
            lblText6.setBounds(0, 120, 360, 60);
            lblText6.setForeground(Color.white);
            Font lblText6Font = new Font("Times New Roman", Font.PLAIN, 19);
            lblText6.setFont(lblText6Font);

            imgLabel2 = new JLabel();
            panel2 = new JPanel();
            panel2.setBounds(485, 235, 360, 200);
            panel2.setLayout(null);
            panel2.setVisible(true);
            panel2.setOpaque(false);
            frame.add(panel2);

            panel2.add(lblText1);
            panel2.add(lblText2);
            panel2.add(lblText4);
            panel2.add(lblText3);
            panel2.add(lblText5);
            panel2.add(lblText6);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        ImageIcon confirmimg = new ImageIcon("images/confirm.png");
        confirmButton = new JButton(confirmimg);
        confirmButton.setBounds(167, 166, confirmimg.getIconWidth(), confirmimg.getIconHeight());
        confirmButton.setBackground(Color.black);
        confirmButton.setVisible(false);
        confirmButton.setOpaque(false);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setCursor(cursor);
        panel2.add(confirmButton);

        ImageIcon exit = new ImageIcon("images/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(802, 478, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(exitButton);

        ImageIcon backimg = new ImageIcon("images/previous.png");
        backButton = new JButton(backimg);
        backButton.setBounds(0, 479, backimg.getIconWidth(), backimg.getIconHeight());
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(backButton);

        ImageIcon logout = new ImageIcon("images/logout.png");
        logoutButton = new JButton(logout);
        logoutButton.setBounds(807, 2, logout.getIconWidth(), logout.getIconHeight());
        logoutButton.setBackground(Color.black);
        logoutButton.setOpaque(false);
        logoutButton.setVisible(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(logoutButton);
        if (Login.loginFlag == true) {
            logoutButton.setVisible(true);
        }

        combobox.addActionListener(this);
        confirmButton.addActionListener(this);
        exitButton.addActionListener(this);
        backButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == combobox) {

            String list = combobox.getSelectedItem().toString();
            int index = combobox.getSelectedIndex();

            for (int i = 0; i < tablecount; i++) {
                label.setVisible(false);
                panel2.setVisible(true);
                imgLabel2.setVisible(true);
                confirmButton.setVisible(true);

                if (list.equals(typearr[i])) {
                    count2 = i;
                    userList = list;
                    String line = imglinkarr[i];
                    imgLabel2.setIcon(new ImageIcon(line));
                    imgLabel2.setBounds(220, 235, 250, 250);
                    frame.add(imgLabel2);
                    lblText1.setText("You Have Selected : " + typearr[i]);
                    lblText2.setText("Rent Per Month : " + rentarr[i] + " TK");
                    lblText4.setText("Shop Size : " + sizearr[i] + " Square Feet");
                    lblText6.setText("Shop No : " + shoparr[i]);
                    lblText3.setText("Place : " + quantityarr[i]);

                    lblText5.setText("Confirm Rent-->");
                    break;

                } else {

                    label.setVisible(true);
                    panel2.setVisible(false);
                    imgLabel2.setVisible(false);
                    confirmButton.setVisible(false);

                }
            }

        } else if (e.getSource() == confirmButton) {

            if (Login.loginFlag == false) {
                JOptionPane.showMessageDialog(null, "Please Sign Up First", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Confirmation Alart!",
                        JOptionPane.YES_NO_OPTION);

                if (yesORno == 0) {
                    String line = ".\\files\\" + Login.USERNAME + "_shops.txt";
                    try {
                        File file = new File(line);
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);

                            printWriter.close();
                        }
                        for (int j = 0; j < tablecount; j++) {
                            if (userList.equals(typearr[j])) {
                                FileWriter fileWriter = new FileWriter(file, true);
                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                                printWriter.println("Shop Details");
                                printWriter.println(typearr[j]);
                                printWriter.println(sizearr[j]);
                                printWriter.println(shoparr[j]);
                                printWriter.println(rentarr[j]);
                                printWriter.println(quantityarr[j]);
                                printWriter.println(imglinkarr[j]);
                                printWriter.println();
                                printWriter.close();

                                String tempfile = ".\\files\\temp2.txt";
                                File oldFile = new File(".\\files\\all_shops.txt");
                                File newFile = new File(".\\files\\temp2.txt.txt");
                                int l = 0;

                                String currentline;

                                FileWriter fileWriter2 = new FileWriter(tempfile, true);
                                BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                                PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

                                File rentShop = new File(".\\files\\rented_shops.txt");
                                if (!rentShop.exists()) {
                                    rentShop.createNewFile();
                                }
                                FileWriter fileWriter3 = new FileWriter(rentShop, true);
                                BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
                                PrintWriter printWriter3 = new PrintWriter(bufferedWriter3);
                                printWriter3.println();

                                FileReader fr = new FileReader(".\\files\\all_shops.txt");
                                BufferedReader br = new BufferedReader(fr);

                                BufferedReader readFile3 = new BufferedReader(
                                        new FileReader(".\\files\\all_shops.txt"));
                                int totalLines3 = 0;
                                while (readFile3.readLine() != null) {
                                    totalLines3++;
                                }
                                readFile3.close();

                                for (int k = 0; k < totalLines3; k++) {
                                    String linek = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(k);
                                    String linek1 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(k + 1);
                                    String linek2 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(k + 4);
                                    String linek3 = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(k + 2);
                                    if (linek.equals(typearr[count2]) && linek1.equals(sizearr[count2])
                                            && linek2.equals(quantityarr[count2]) && linek3.equals(shoparr[count2])) {
                                        count = k;
                                        break;
                                    }
                                }
                                int a = count;
                                int b = count + 1;
                                int c = count + 2;
                                int d = count + 3;
                                int f = count + 4;
                                int g = count + 5;
                                int h = count + 6;
                                while ((currentline = br.readLine()) != null) {
                                    l++;
                                    if (a != l && b != l && c != l && d != l && f != l && g != l && h != l) {
                                        printWriter2.println(currentline);
                                    } else {
                                        printWriter3.println(currentline);
                                    }

                                }

                                printWriter3.println(Login.USERNAME);

                                printWriter2.flush();
                                printWriter2.close();
                                fr.close();
                                br.close();
                                bufferedWriter2.close();
                                fileWriter2.close();
                                printWriter3.flush();
                                printWriter3.close();
                                bufferedWriter3.close();
                                fileWriter3.close();

                                oldFile.delete();
                                File dumb = new File(".\\files\\temp.txt");
                                dumb.createNewFile();
                                newFile.renameTo(dumb);
                                frame.setVisible(false);
                                new Skip2();
                                break;
                            }
                        }

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }

        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        } else if (e.getSource() == backButton) {
            if (Login.loginFlag == true) {
                frame.setVisible(false);
                new CustomerHome();
            } else {
                frame.setVisible(false);
                new Login();
            }
        }

        else if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            new Login();
        }
    }
}
