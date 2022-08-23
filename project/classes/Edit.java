package classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import classes.*;

public class Edit implements ActionListener {

    private Container c;
    private JFrame frame;
    private Cursor cursor;
    private JPanel panel;

    private JLabel fullName1;
    private JLabel displayName1;
    private JLabel phoneNumber1;
    private JLabel oldPassword1;
    private JLabel userName1;

    private JTextField fullField;
    private JTextField userField;
    private JTextField phoneField;

    private JLabel full;
    private JLabel user;
    private JLabel phone;

    private JButton fullnameButton;
    private JButton usernameButton;
    private JButton phoneButton;

    private JButton confirmButton1;
    private JButton confirmButton2;
    private JButton confirmButton3;
    private JButton logoutButton;
    private JButton exitButton;
    private JButton backButton;

    private int check;

    public Edit() {
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Edit Info");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#24292e"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("images/market.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        check = 0;

        cursor = new Cursor(Cursor.HAND_CURSOR);

        ImageIcon profile = new ImageIcon("images/profile.png");
        JLabel imgLabel = new JLabel(profile);
        imgLabel.setBounds(350, 0, profile.getIconWidth(), profile.getIconHeight());
        frame.add(imgLabel);

        displayName1 = new JLabel("Edit Infirmation");
        displayName1.setBounds(354, 150, 200, 50);
        Font displayName1Font = new Font("Times New Roman", Font.PLAIN, 23);
        displayName1.setFont(displayName1Font);
        displayName1.setForeground(Color.decode("#6577b3"));
        frame.add(displayName1);

        fullnameButton = new JButton("Full Name");
        fullnameButton.setVisible(true);
        fullnameButton.setBounds(355, 210, 150, 30);
        fullnameButton.setBorder(BorderFactory.createEmptyBorder());
        fullnameButton.setBackground(new Color(49, 111, 112));
        fullnameButton.setForeground(Color.decode("#8ee0f0"));
        Font fullnameButtonFont = new Font("Times New Roman", Font.BOLD, 19);
        fullnameButton.setFont(fullnameButtonFont);
        fullnameButton.setCursor(cursor);
        frame.add(fullnameButton);

        usernameButton = new JButton("User Name");
        usernameButton.setVisible(true);
        usernameButton.setBorder(BorderFactory.createEmptyBorder());
        usernameButton.setBounds(355, 270, 150, 30);
        usernameButton.setBackground(new Color(49, 111, 112));
        usernameButton.setForeground(Color.decode("#8ee0f0"));
        Font usernameButtonFont = new Font("Times New Roman", Font.BOLD, 19);
        usernameButton.setFont(usernameButtonFont);
        usernameButton.setCursor(cursor);
        frame.add(usernameButton);

        phoneButton = new JButton("Phone Number");
        phoneButton.setVisible(true);
        phoneButton.setBounds(355, 330, 150, 30);
        phoneButton.setBorder(BorderFactory.createEmptyBorder());
        phoneButton.setBackground(new Color(49, 111, 112));
        phoneButton.setForeground(Color.decode("#8ee0f0"));
        Font phoneButtonFont = new Font("Times New Roman", Font.BOLD, 19);
        phoneButton.setFont(phoneButtonFont);
        phoneButton.setCursor(cursor);
        frame.add(phoneButton);

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
        logoutButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(logoutButton);

        confirmButton1 = new JButton("Confirm");
        confirmButton1.setVisible(false);
        confirmButton1.setBounds(390, 290, 80, 30);
        confirmButton1.setBorder(BorderFactory.createEmptyBorder());
        confirmButton1.setBackground(new Color(49, 111, 112));
        confirmButton1.setForeground(Color.decode("#8ee0f0"));
        Font confirmButtonFont1 = new Font("Times New Roman", Font.BOLD, 15);
        confirmButton1.setFont(confirmButtonFont1);
        confirmButton1.setCursor(cursor);
        frame.add(confirmButton1);

        confirmButton2 = new JButton("Confirm");
        confirmButton2.setVisible(false);
        confirmButton2.setBounds(390, 290, 80, 30);
        confirmButton2.setBorder(BorderFactory.createEmptyBorder());
        confirmButton2.setBackground(new Color(49, 111, 112));
        confirmButton2.setForeground(Color.decode("#8ee0f0"));
        Font confirmButtonFont2 = new Font("Times New Roman", Font.BOLD, 15);
        confirmButton2.setFont(confirmButtonFont2);
        confirmButton2.setCursor(cursor);
        frame.add(confirmButton2);

        confirmButton3 = new JButton("Confirm");
        confirmButton3.setVisible(false);
        confirmButton3.setBounds(390, 290, 80, 30);
        confirmButton3.setBorder(BorderFactory.createEmptyBorder());
        confirmButton3.setBackground(new Color(49, 111, 112));
        confirmButton3.setForeground(Color.decode("#8ee0f0"));
        Font confirmButtonFont3 = new Font("Times New Roman", Font.BOLD, 15);
        confirmButton3.setFont(confirmButtonFont3);
        confirmButton3.setCursor(cursor);
        frame.add(confirmButton3);

        full = new JLabel("Enter your full name :");
        full.setVisible(false);
        full.setBounds(354, 210, 250, 30);
        Font fullFont = new Font("Times New Roman", Font.PLAIN, 17);
        full.setFont(fullFont);
        full.setForeground(Color.white);
        frame.add(full);

        fullField = new JTextField();
        fullField.setVisible(false);
        fullField.setBounds(354, 240, 150, 30);
        Font fullFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        fullField.setFont(fullFieldFont);
        fullField.setOpaque(false);
        fullField.setForeground(new Color(219, 226, 233));
        fullField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        fullField.setBorder(redBorder);
        frame.add(fullField);

        user = new JLabel("Enter new user name :");
        user.setVisible(false);
        user.setBounds(354, 210, 250, 30);
        Font userFont = new Font("Times New Roman", Font.PLAIN, 17);
        user.setFont(userFont);
        user.setForeground(Color.white);
        frame.add(user);

        userField = new JTextField();
        userField.setVisible(false);
        userField.setBounds(354, 240, 150, 30);
        Font userFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        userField.setFont(userFieldFont);
        userField.setOpaque(false);
        userField.setForeground(new Color(219, 226, 233));
        userField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        userField.setBorder(redBorder2);
        frame.add(userField);

        phone = new JLabel("Enter new phone number :");
        phone.setVisible(false);
        phone.setBounds(354, 210, 250, 30);
        Font phoneFont = new Font("Times New Roman", Font.PLAIN, 17);
        phone.setFont(phoneFont);
        phone.setForeground(Color.white);
        frame.add(phone);

        phoneField = new JTextField();
        phoneField.setVisible(false);
        phoneField.setBounds(354, 240, 173, 30);
        Font phoneFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        phoneField.setFont(phoneFieldFont);
        phoneField.setOpaque(false);
        phoneField.setForeground(new Color(219, 226, 233));
        phoneField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        phoneField.setBorder(redBorder3);
        frame.add(phoneField);

        usernameButton.addActionListener(this);
        phoneButton.addActionListener(this);
        fullnameButton.addActionListener(this);

        confirmButton1.addActionListener(this);
        confirmButton2.addActionListener(this);
        confirmButton3.addActionListener(this);
        logoutButton.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String name;
        boolean emptyName;

        if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            new Login();
        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Do you want to exit ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        }

        else if (e.getSource() == fullnameButton) {
            check = 1;
            fullField.setVisible(true);
            confirmButton1.setVisible(true);
            full.setVisible(true);

            confirmButton2.setVisible(false);
            confirmButton3.setVisible(false);

            user.setVisible(false);
            phone.setVisible(false);

            userField.setVisible(false);
            phoneField.setVisible(false);

            usernameButton.setVisible(false);
            fullnameButton.setVisible(false);
            phoneButton.setVisible(false);

        }

        else if (e.getSource() == usernameButton) {
            check = 1;
            userField.setVisible(true);
            confirmButton2.setVisible(true);
            user.setVisible(true);

            confirmButton1.setVisible(false);
            confirmButton3.setVisible(false);

            full.setVisible(false);
            phone.setVisible(false);

            fullField.setVisible(false);
            phoneField.setVisible(false);

            fullnameButton.setVisible(false);
            usernameButton.setVisible(false);
            phoneButton.setVisible(false);

            name = userField.getText();
            emptyName = name.isEmpty();
        }

        else if (e.getSource() == phoneButton) {
            check = 1;
            phoneField.setVisible(true);
            confirmButton3.setVisible(true);
            phone.setVisible(true);

            confirmButton1.setVisible(false);
            confirmButton2.setVisible(false);

            full.setVisible(false);
            user.setVisible(false);

            fullField.setVisible(false);
            userField.setVisible(false);

            fullnameButton.setVisible(false);
            phoneButton.setVisible(false);
            usernameButton.setVisible(false);

            name = phoneField.getText();
            emptyName = name.isEmpty();
        }

        else if (e.getSource() == backButton) {
            if (check == 0) {
                frame.setVisible(false);
                new Profile();
            } else {

                fullnameButton.setVisible(true);
                fullnameButton.setBounds(355, 210, 150, 30);
                usernameButton.setVisible(true);
                usernameButton.setBounds(355, 270, 150, 30);
                phoneButton.setVisible(true);
                phoneButton.setBounds(355, 330, 150, 30);

                confirmButton1.setVisible(false);
                confirmButton2.setVisible(false);
                confirmButton3.setVisible(false);

                full.setVisible(false);
                user.setVisible(false);
                phone.setVisible(false);

                fullField.setVisible(false);
                userField.setVisible(false);
                phoneField.setVisible(false);

                check = 0;

            }
        }

        else if (e.getSource() == confirmButton1) {

            name = fullField.getText();
            String newName;
            emptyName = name.isEmpty();

            if (emptyName == true) {
                showMessageDialog(null, "Enter your name", " Error!", JOptionPane.WARNING_MESSAGE);
            } else {
                newName = "Full Name : " + name;

                try {

                    FileReader fr1 = new FileReader(".\\files\\user_login.txt");
                    BufferedReader br1 = new BufferedReader(fr1);
                    String currentline1;
                    int target = 0;
                    while ((currentline1 = br1.readLine()) != null) {
                        if ((Login.fullUsername).equals(currentline1)) {
                            target = target - 1;
                            break;
                        } else {
                            target++;
                        }
                    }
                    fr1.close();
                    br1.close();

                    String tempfile = ".\\files\\temp3.txt";
                    File oldFile = new File(".\\files\\user_login.txt");
                    File newFile = new File(".\\files\\temp3.txt");
                    String currentline;

                    FileWriter fileWriter2 = new FileWriter(tempfile, false);
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                    PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

                    FileReader fr = new FileReader(".\\files\\user_login.txt");
                    BufferedReader br = new BufferedReader(fr);

                    int l = 0;
                    while ((currentline = br.readLine()) != null) {
                        if (target == l) {
                            printWriter2.println(newName);
                        } else {
                            printWriter2.println(currentline);
                        }
                        l++;

                    }
                    printWriter2.flush();
                    printWriter2.close();
                    fr.close();
                    br.close();
                    bufferedWriter2.close();
                    fileWriter2.close();
                    oldFile.delete();
                    File dumb = new File(".\\files\\user_login.txt");
                    newFile.renameTo(dumb);

                    Login.fullName = newName;

                    frame.setVisible(false);
                    new Profile();

                } catch (Exception ex) {

                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == confirmButton2) {
            name = userField.getText();
            String newName;
            emptyName = name.isEmpty();

            if (emptyName == true) {
                showMessageDialog(null, "Enter new user name", " Error!", JOptionPane.WARNING_MESSAGE);
            } else {
                newName = "User Name : " + name;

                try {

                    int totalLines = 0;
                    BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));
                    while (readFile.readLine() != null) {
                        totalLines++;
                    }
                    readFile.close();

                    // Admin login file checked
                    BufferedReader adminFile = new BufferedReader(new FileReader(".\\files\\admin_login.txt"));
                    int totalLines2 = 0;
                    while (adminFile.readLine() != null) {
                        totalLines2++;
                    }
                    adminFile.close();

                    boolean userflag = false;
                    boolean adminflag = false;

                    // for user
                    for (int i = 0; i < totalLines; i++) {
                        String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i);
                        if (line.equals("User Name : " + name)) {
                            userflag = true;
                            break;
                        }
                    }

                    // for admin
                    for (int i = 0; i < totalLines2; i++) {
                        String line = Files.readAllLines(Paths.get(".\\files\\admin_login.txt")).get(i);
                        if (line.equals("User Name : " + name)) {
                            adminflag = true;
                            break;
                        }
                    }

                    if (adminflag == false && userflag == false) {
                        FileReader fr1 = new FileReader(".\\files\\user_login.txt");
                        BufferedReader br1 = new BufferedReader(fr1);
                        String currentline1;
                        int target = 0;
                        while ((currentline1 = br1.readLine()) != null) {
                            if ((Login.fullUsername).equals(currentline1)) {
                                break;
                            } else {
                                target++;
                            }
                        }
                        fr1.close();
                        br1.close();

                        String tempfile = ".\\files\\temp3.txt";
                        File oldFile = new File(".\\files\\user_login.txt");
                        File newFile = new File(".\\files\\temp3.txt");
                        String currentline;

                        FileWriter fileWriter2 = new FileWriter(tempfile, false);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                        PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

                        FileReader fr = new FileReader(".\\files\\user_login.txt");
                        BufferedReader br = new BufferedReader(fr);

                        int l = 0;
                        while ((currentline = br.readLine()) != null) {
                            if (target == l) {
                                printWriter2.println(newName);
                            } else {
                                printWriter2.println(currentline);
                            }
                            l++;

                        }
                        printWriter2.flush();
                        printWriter2.close();
                        fr.close();
                        br.close();
                        bufferedWriter2.close();
                        fileWriter2.close();
                        oldFile.delete();
                        File dumb = new File(".\\files\\user_login.txt");
                        newFile.renameTo(dumb);

                        Login.fullUsername = newName;

                        frame.setVisible(false);
                        new Profile();
                    } else {
                        showMessageDialog(null, "User name already exist", " Error!", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (Exception ex) {

                    System.out.println(ex);
                }
            }
        }

        else if (e.getSource() == confirmButton3) {

            name = phoneField.getText();
            String newName;
            emptyName = name.isEmpty();
            int number;
            int numcount = 0;
            try {

                number = Integer.parseInt(name);
                if (name.length() != 11)
                    numcount++;
            } catch (Exception ex) {
                numcount = 1;
            }

            if (emptyName == true) {
                showMessageDialog(null, "Enter new phone number", " Error!", JOptionPane.WARNING_MESSAGE);
            } else if (numcount > 0) {
                showMessageDialog(null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);
            } else {
                newName = "Phone : " + name;

                try {

                    FileReader fr1 = new FileReader(".\\files\\user_login.txt");
                    BufferedReader br1 = new BufferedReader(fr1);
                    String currentline1;
                    int target = 0;
                    while ((currentline1 = br1.readLine()) != null) {
                        if ((Login.fullUsername).equals(currentline1)) {
                            target = target + 2;
                            break;
                        } else {
                            target++;
                        }
                    }
                    fr1.close();
                    br1.close();

                    String tempfile = ".\\files\\temp3.txt";
                    File oldFile = new File(".\\files\\user_login.txt");
                    File newFile = new File(".\\files\\temp3.txt");
                    String currentline;

                    FileWriter fileWriter2 = new FileWriter(tempfile, false);
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                    PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

                    FileReader fr = new FileReader(".\\files\\user_login.txt");
                    BufferedReader br = new BufferedReader(fr);

                    int l = 0;
                    while ((currentline = br.readLine()) != null) {
                        if (target == l) {
                            printWriter2.println(newName);
                        } else {
                            printWriter2.println(currentline);
                        }
                        l++;

                    }
                    printWriter2.flush();
                    printWriter2.close();
                    fr.close();
                    br.close();
                    bufferedWriter2.close();
                    fileWriter2.close();
                    oldFile.delete();
                    File dumb = new File(".\\files\\user_login.txt");
                    newFile.renameTo(dumb);

                    Login.phoneNumber = newName;

                    frame.setVisible(false);
                    new Profile();

                } catch (Exception ex) {

                    System.out.println(ex);
                }
            }
        }
    }
}