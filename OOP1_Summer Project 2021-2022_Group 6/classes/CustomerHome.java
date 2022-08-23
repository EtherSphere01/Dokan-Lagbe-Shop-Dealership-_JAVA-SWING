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

public class CustomerHome implements ActionListener {
    private JFrame frame;
    private Container c;
    private Cursor cursor;

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
    String file;
    String temp;
    int shopcount;
    int count;

    private JTable table;
    private JScrollPane scroll;
    private int tablecount;

    private JButton profileButton;
    private JButton buyButton;
    private JButton deleteButton;
    private JButton exitButton;
    private JButton backButton;
    private JButton logoutButton;
    private String newfiles;

    private String usernamenew = Login.USERNAME;

    public CustomerHome() {

        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Customer Home");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#24292e"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("images/market.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        try {
            newfiles = ".\\files\\" + usernamenew + "_shops.txt";
            File file = new File(newfiles);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner input = new Scanner(file);

            BufferedReader readFile1 = new BufferedReader(new FileReader(newfiles));
            int totalLines1 = 0;
            int count2 = 0;
            while (readFile1.readLine() != null) {
                count2++;
            }

            readFile1.close();

            for (int j = 0; j < count2; j++) {
                String line = Files.readAllLines(Paths.get(newfiles)).get(j);
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

            BufferedReader readFile3 = new BufferedReader(new FileReader(newfiles));

            // for admin
            int totalLines3 = 0;
            while (readFile3.readLine() != null) {
                totalLines3++;
            }
            readFile3.close();

            for (int l = 0; l < totalLines3; l++) {

                String line = Files.readAllLines(Paths.get(newfiles)).get(l);
                if (line.equals("Shop Details")) {
                    String line2 = Files.readAllLines(Paths.get(newfiles)).get((l + 1));
                    String line3 = Files.readAllLines(Paths.get(newfiles)).get((l + 2));
                    String line4 = Files.readAllLines(Paths.get(newfiles)).get((l + 3));
                    String line5 = Files.readAllLines(Paths.get(newfiles)).get((l + 4));
                    String line6 = Files.readAllLines(Paths.get(newfiles)).get((l + 5));
                    String line7 = Files.readAllLines(Paths.get(newfiles)).get((l + 6));
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
            Font tableFont = new Font("Times New Roman", Font.PLAIN, 15);
            table.setBackground(Color.decode("#ede4d9"));
            table.setForeground(Color.decode("#24292e"));
            table.setFont(tableFont);

            scroll = new JScrollPane(table);
            scroll.setBounds(0, 100, 835, 180);
            frame.add(scroll);
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel details = new JLabel("Your rented shops");
        details.setBounds(340, 50, 250, 60);
        Font detailsFont = new Font("Times New Roman", Font.PLAIN, 22);
        details.setFont(detailsFont);
        details.setForeground(new Color(215, 210, 203));
        frame.add(details);

        buyButton = new JButton("Rent Shop");
        buyButton.setBounds(280, 290, 80, 30);
        buyButton.setBackground(new Color(0, 0, 0, 0));
        buyButton.setBorder(BorderFactory.createEmptyBorder());
        buyButton.setForeground(Color.decode("#6577b3"));
        buyButton.setOpaque(false);
        Font buyButtonFont = new Font("Times New Roman", Font.BOLD, 17);
        buyButton.setFont(buyButtonFont);
        buyButton.setCursor(cursor);
        frame.add(buyButton);

        deleteButton = new JButton("Return Shop");
        deleteButton.setBounds(380, 290, 100, 30);
        deleteButton.setBackground(new Color(0, 0, 0, 0));
        deleteButton.setBorder(BorderFactory.createEmptyBorder());
        deleteButton.setForeground(Color.decode("#6577b3"));
        deleteButton.setOpaque(false);
        Font deleteButtonFont = new Font("Times New Roman", Font.BOLD, 17);
        deleteButton.setFont(deleteButtonFont);
        deleteButton.setCursor(cursor);
        frame.add(deleteButton);

        profileButton = new JButton(usernamenew);
        profileButton.setBounds(490, 290, 100, 30);
        profileButton.setBackground(new Color(0, 0, 0, 0));
        profileButton.setBorder(BorderFactory.createEmptyBorder());
        profileButton.setOpaque(false);
        profileButton.setForeground(Color.decode("#6577b3"));
        Font profileButtonFont = new Font("Times New Roman", Font.BOLD, 17);
        profileButton.setFont(profileButtonFont);
        profileButton.setCursor(cursor);
        frame.add(profileButton);

        ImageIcon exit = new ImageIcon("images/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(802, 478, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(exitButton);

        ImageIcon logout = new ImageIcon("images/logout.png");
        logoutButton = new JButton(logout);
        logoutButton.setBounds(807, 2, logout.getIconWidth(), logout.getIconHeight());
        logoutButton.setBackground(Color.black);
        logoutButton.setOpaque(false);
        logoutButton.setVisible(true);
        logoutButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(logoutButton);

        deleteButton.addActionListener(this);
        buyButton.addActionListener(this);
        profileButton.addActionListener(this);
        exitButton.addActionListener(this);
        logoutButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {

            if (table.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a shop to return", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    BufferedReader readFile1 = new BufferedReader(new FileReader(newfiles));
                    int totalLines1 = 0;
                    int count2 = 0;
                    while (readFile1.readLine() != null) {
                        count2++;
                    }
                    for (int j = 0; j < count2; j++) {
                        String line = Files.readAllLines(Paths.get(newfiles)).get(j);
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
                        String line = Files.readAllLines(Paths.get(newfiles)).get(j);
                        if (line.equals(removeUser)) {
                            count = j;
                        }
                    }

                    String tempfile = ".\\files\\temp.txt";
                    File oldFile = new File(newfiles);
                    File newFile = new File(".\\files\\temp.txt.txt");
                    int l = 0;

                    String currentline;
                    File rentShop = new File(".\\files\\all_shops.txt");

                    FileWriter fileWriter3 = new FileWriter(rentShop, true);
                    BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
                    PrintWriter printWriter3 = new PrintWriter(bufferedWriter3);
                    printWriter3.println();

                    FileWriter fileWriter2 = new FileWriter(tempfile, true);
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                    PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

                    FileReader fr = new FileReader(newfiles);
                    BufferedReader br = new BufferedReader(fr);

                    BufferedReader readFile3 = new BufferedReader(new FileReader(newfiles));
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
                        } else {
                            printWriter3.println(currentline);
                        }

                    }

                    printWriter2.flush();
                    printWriter2.close();
                    printWriter3.flush();
                    printWriter3.close();
                    fr.close();
                    br.close();
                    bufferedWriter2.close();
                    fileWriter2.close();
                    bufferedWriter3.close();
                    fileWriter3.close();

                    oldFile.delete();
                    File dumb = new File(".\\files\\temp.txt");
                    dumb.createNewFile();
                    newFile.renameTo(dumb);
                    frame.setVisible(false);
                    new Delete();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        } else if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            new Login();
        } else if (e.getSource() == buyButton) {
            frame.setVisible(false);
            new Skip();
        } else if (e.getSource() == profileButton) {
            frame.setVisible(false);
            new Profile();
        }
    }
}
