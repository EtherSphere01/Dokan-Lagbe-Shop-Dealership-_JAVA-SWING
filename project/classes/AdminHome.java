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

public class AdminHome implements ActionListener {
    private Container c;
    private JFrame frame;
    private Cursor cursor;
    private ImageIcon mallName;
    private JButton userInfo, shopInfo, selfInfo, exitButton, backButton;
    private JButton userAdd;
    private JButton shopAdd, shopDlt;
    private JLabel details, details1, details3;
    private JTable table1;
    private JScrollPane scroll1;

    private JTable table, table3;
    private JScrollPane scroll, scroll3;
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
    int count, shopcount;
    private String userList;

    private JButton logoutButton;

    public AdminHome() {
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Admin Home");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#24292e"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        file = ".\\files\\all_shops.txt";
        temp = ".\\files\\temp.txt";

        ImageIcon icon = new ImageIcon("images/market.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        mallName = new ImageIcon("images/welcome3.png");
        JLabel imgLabel = new JLabel(mallName);
        imgLabel.setBounds(20, 50, mallName.getIconWidth(), mallName.getIconHeight());
        frame.add(imgLabel);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        userInfo = new JButton("User Information");
        userInfo.setBounds(30, 200, 150, 30);
        Font userInfoFont = new Font("Monospace", Font.BOLD, 16);
        userInfo.setBorder(BorderFactory.createEmptyBorder());
        userInfo.setFont(userInfoFont);
        userInfo.setOpaque(false);
        userInfo.setForeground(new Color(152, 152, 156));
        userInfo.setOpaque(false);
        userInfo.setBackground(new Color(0, 0, 0, 0));
        frame.add(userInfo);
        userInfo.setCursor(cursor);
        userInfo.addActionListener(this);

        shopInfo = new JButton("Shop Information");
        shopInfo.setBounds(30, 150, 150, 30);
        Font shopInfoFont = new Font("Monospace", Font.BOLD, 16);
        shopInfo.setBorder(BorderFactory.createEmptyBorder());
        shopInfo.setFont(shopInfoFont);
        shopInfo.setOpaque(false);
        shopInfo.setForeground(new Color(152, 152, 156));
        shopInfo.setOpaque(false);
        shopInfo.setBackground(new Color(0, 0, 0, 0));
        frame.add(shopInfo);
        shopInfo.setCursor(cursor);
        shopInfo.addActionListener(this);

        selfInfo = new JButton("Rented Shops");
        selfInfo.setBounds(25, 250, 150, 30);
        Font selfInfoFont = new Font("Monospace", Font.BOLD, 16);
        selfInfo.setBorder(BorderFactory.createEmptyBorder());
        selfInfo.setFont(selfInfoFont);
        selfInfo.setOpaque(false);
        selfInfo.setForeground(new Color(152, 152, 156));
        selfInfo.setOpaque(false);
        selfInfo.setBackground(new Color(0, 0, 0, 0));
        frame.add(selfInfo);
        selfInfo.setCursor(cursor);
        selfInfo.addActionListener(this);

        ImageIcon exit = new ImageIcon("images/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(802, 478, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(exitButton);

        // ImageIcon backimg = new ImageIcon("images/previous.png");
        // backButton = new JButton(backimg);
        // backButton.setBounds(0, 479, backimg.getIconWidth(),
        // backimg.getIconHeight());
        // backButton.setBackground(Color.black);
        // backButton.setOpaque(false);
        // backButton.setBorder(BorderFactory.createEmptyBorder());
        // frame.add(backButton);
        // backButton.setCursor(cursor);
        // backButton.addActionListener(this);

        details1 = new JLabel("User Information");
        details1.setBounds(460, 30, 350, 60);
        Font details1Font = new Font("Times New Roman", Font.PLAIN, 28);
        details1.setFont(details1Font);
        details1.setForeground(new Color(215, 210, 203));
        frame.add(details1);
        details1.setVisible(false);

        details3 = new JLabel("Rented Shops");
        details3.setBounds(460, 30, 350, 60);
        Font details3Font = new Font("Times New Roman", Font.PLAIN, 28);
        details3.setFont(details3Font);
        details3.setForeground(new Color(215, 210, 203));
        frame.add(details3);
        details3.setVisible(false);

        userAdd = new JButton("Add User");
        userAdd.setBounds(480, 320, 130, 30);
        Font userAddFont = new Font("Monospace", Font.BOLD, 16);
        userAdd.setBorder(BorderFactory.createEmptyBorder());
        userAdd.setFont(userAddFont);
        userAdd.setOpaque(false);
        userAdd.setForeground(new Color(152, 152, 156));
        userAdd.setOpaque(false);
        userAdd.setBackground(new Color(0, 0, 0, 0));
        frame.add(userAdd);
        userAdd.setCursor(cursor);
        userAdd.addActionListener(this);
        userAdd.setVisible(false);

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
        scroll1.setVisible(false);

        details = new JLabel("Shops Information");
        details.setBounds(460, 30, 250, 60);
        Font detailsFont = new Font("Times New Roman", Font.PLAIN, 28);
        details.setFont(detailsFont);
        details.setForeground(new Color(215, 210, 203));
        frame.add(details);

        shopAdd = new JButton("Add Shop");
        shopAdd.setBounds(430, 330, 130, 30);
        Font shopAddFont = new Font("Monospace", Font.BOLD, 16);
        shopAdd.setBorder(BorderFactory.createEmptyBorder());
        shopAdd.setFont(shopAddFont);
        shopAdd.setOpaque(false);
        shopAdd.setForeground(new Color(152, 152, 156));
        shopAdd.setOpaque(false);
        shopAdd.setBackground(new Color(0, 0, 0, 0));
        frame.add(shopAdd);
        shopAdd.setCursor(cursor);
        shopAdd.addActionListener(this);

        shopDlt = new JButton("Delete Shop");
        shopDlt.setBounds(600, 330, 130, 30);
        Font shopDltFont = new Font("Monospace", Font.BOLD, 16);
        shopDlt.setBorder(BorderFactory.createEmptyBorder());
        shopDlt.setFont(shopDltFont);
        shopDlt.setOpaque(false);
        shopDlt.setForeground(new Color(152, 152, 156));
        shopDlt.setOpaque(false);
        shopDlt.setBackground(new Color(0, 0, 0, 0));
        frame.add(shopDlt);
        shopDlt.setCursor(cursor);
        shopDlt.addActionListener(this);

        try {
            File file1 = new File(".\\files\\all_shops.txt");
            if (!file1.exists()) {
                file1.createNewFile();
            }
            Scanner input = new Scanner(file1);

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
            // table.setEnabled(false);
            Font tableFont = new Font("Times New Roman", Font.PLAIN, 15);
            table.setBackground(Color.decode("#ede4d9"));
            table.setForeground(Color.decode("#24292e"));
            table.setFont(tableFont);

            scroll = new JScrollPane(table);
            scroll.setBounds(300, 100, 500, 200);
            frame.add(scroll);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            File file1 = new File(".\\files\\rented_shops.txt");
            if (!file1.exists()) {
                file1.createNewFile();
            }
            Scanner input = new Scanner(file1);

            BufferedReader readFile1 = new BufferedReader(new FileReader(".\\files\\rented_shops.txt"));
            int totalLines1 = 0;
            int count2 = 0;
            while (readFile1.readLine() != null) {
                count2++;
            }

            readFile1.close();

            for (int j = 0; j < count2; j++) {
                String line = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get(j);
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

            BufferedReader readFile3 = new BufferedReader(new FileReader(".\\files\\rented_shops.txt"));

            int totalLines3 = 0;
            while (readFile3.readLine() != null) {
                totalLines3++;
            }
            readFile3.close();

            for (int l = 0; l < totalLines3; l++) {

                String line = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get(l);
                if (line.equals("Shop Details")) {
                    String line2 = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get((l + 1));
                    String line3 = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get((l + 2));
                    String line4 = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get((l + 3));
                    String line5 = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get((l + 4));
                    String line6 = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get((l + 5));
                    String line7 = Files.readAllLines(Paths.get(".\\files\\rented_shops.txt")).get((l + 6));
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

            table3 = new JTable(titleRow, titleCol);
            // table.setEnabled(false);
            Font table3Font = new Font("Times New Roman", Font.PLAIN, 15);
            table3.setBackground(Color.decode("#ede4d9"));
            table3.setForeground(Color.decode("#24292e"));
            table3.setFont(table3Font);

            scroll3 = new JScrollPane(table3);
            scroll3.setBounds(300, 100, 500, 200);
            frame.add(scroll3);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        scroll3.setVisible(false);

        ImageIcon logout = new ImageIcon("images/logout.png");
        logoutButton = new JButton(logout);
        logoutButton.setBounds(807, 2, logout.getIconWidth(), logout.getIconHeight());
        logoutButton.setBackground(Color.black);
        logoutButton.setOpaque(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(logoutButton);

        logoutButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userInfo) {
            scroll.setVisible(false);
            shopAdd.setVisible(false);
            shopDlt.setVisible(false);
            details.setVisible(false);
            details3.setVisible(false);
            scroll3.setVisible(false);

            scroll1.setVisible(true);
            details1.setVisible(true);
            userAdd.setVisible(true);

        } else if (e.getSource() == shopInfo) {
            scroll.setVisible(true);
            shopAdd.setVisible(true);
            shopDlt.setVisible(true);
            details.setVisible(true);

            scroll1.setVisible(false);
            details1.setVisible(false);
            userAdd.setVisible(false);
            details3.setVisible(false);
            scroll3.setVisible(false);
        } else if (e.getSource() == selfInfo) {
            scroll.setVisible(false);
            shopAdd.setVisible(false);
            shopDlt.setVisible(false);
            details.setVisible(false);
            scroll1.setVisible(false);
            details1.setVisible(false);
            userAdd.setVisible(false);

            scroll3.setVisible(true);
            details3.setVisible(true);
        }

        else if (e.getSource() == shopAdd) {
            frame.setVisible(false);
            new AddShop();
        } else if (e.getSource() == userAdd) {
            frame.setVisible(false);
            new userAdd();
        }

        else if (e.getSource() == shopDlt) {

            if (table.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    BufferedReader readFile1 = new BufferedReader(new FileReader(".\\files\\all_shops.txt"));
                    int totalLines1 = 0;
                    int count2 = 0;
                    while (readFile1.readLine() != null) {
                        count2++;
                    }
                    for (int j = 0; j < count2; j++) {
                        String line = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(j);
                        if (line.equals("Shop Details")) {
                            totalLines1++;
                        }

                    }
                    tablecount = totalLines1;
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
                    System.out.println(removeUser);

                    for (int i = 0; i < shopcount; i++) {
                        if (typearr[i].equals(removeUser)) {
                            count2 = i;
                            break;
                        }
                    }

                    userList = removeUser;
                    String targetshop;
                    for (int j = 0; j < count2; j++) {
                        String line = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(j);
                        if (line.equals(removeUser)) {
                            count = j;
                        }

                    }

                    String tempfile = ".\\files\\temp.txt";
                    File oldFile = new File(".\\files\\all_shops.txt");
                    File newFile = new File(".\\files\\temp.txt.txt");
                    int l = 0;

                    String currentline;

                    FileWriter fileWriter2 = new FileWriter(tempfile, true);
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                    PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

                    FileReader fr = new FileReader(".\\files\\all_shops.txt");
                    BufferedReader br = new BufferedReader(fr);

                    BufferedReader readFile3 = new BufferedReader(new FileReader(".\\files\\all_shops.txt"));
                    int totalLines3 = 0;
                    while (readFile3.readLine() != null) {

                        totalLines3++;
                    }

                    readFile3.close();

                    int a = count - 1;
                    int b = count;
                    int c = count + 1;
                    int d = count + 2;
                    int f = count + 3;
                    int g = count + 4;
                    int h = count + 5;
                    int j = count + 6;
                    while ((currentline = br.readLine()) != null) {
                        l++;
                        if (a != l && b != l && c != l && d != l && f != l && g != l && h != l && j != l) {
                            printWriter2.println(currentline);
                        }

                    }

                    printWriter2.flush();
                    printWriter2.close();
                    fr.close();
                    br.close();
                    bufferedWriter2.close();
                    fileWriter2.close();

                    oldFile.delete();
                    File dumb = new File(".\\files\\temp.txt");
                    dumb.createNewFile();
                    newFile.renameTo(dumb);
                    frame.setVisible(false);
                    new ShopDlt();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        } else if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            new Login();
        }
    }
}
