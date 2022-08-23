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
import classes.*;

public class ForgetPass2 implements ActionListener {
    private JFrame frame;
    private JLabel phone;
    private JTextField phoneField;
    private JLabel hintphn;
    private JButton next2;
    private JButton exitButton;
    private JButton backButton;
    private Container c;
    private ImageIcon forgotUser;
    private Cursor cursor;
    protected static boolean loginFlag;

    int totalLines;

    public ForgetPass2() {
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Reset Password");
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

        JLabel forget = new JLabel("Reset Password");
        forget.setBounds(375, 0, 200, 50);
        Font forgetFont = new Font("Times New Roman", Font.PLAIN, 22);
        forget.setFont(forgetFont);
        forget.setForeground(Color.white);
        frame.add(forget);

        forgotUser = new ImageIcon("images/forgot_user2.png");
        JLabel imgLabel = new JLabel(forgotUser);
        imgLabel.setBounds(0, 115, forgotUser.getIconWidth(), forgotUser.getIconHeight());
        frame.add(imgLabel);

        phone = new JLabel("Phone No :");
        phone.setBounds(385, 230, 180, 50);
        Font phoneFont = new Font("Verdana", Font.PLAIN, 18);
        phone.setFont(phoneFont);
        phone.setForeground(Color.white);
        phone.setVisible(true);
        frame.add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(510, 242, 180, 30);
        Font phoneFieldFont = new Font("Times New Roman", Font.BOLD, 18);
        phoneField.setFont(phoneFieldFont);
        phoneField.setOpaque(false);
        phoneField.setForeground(new Color(219, 226, 233));
        phoneField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder1 = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179, 63, 64));
        phoneField.setBorder(redBorder1);
        phoneField.setVisible(true);
        frame.add(phoneField);

        ImageIcon fnext = new ImageIcon("images/fnext.png");
        next2 = new JButton(fnext);
        next2.setBounds(652, 278, 45, 45);
        next2.setBackground(new Color(0, 0, 0, 0));
        next2.setOpaque(false);
        next2.setBorder(BorderFactory.createEmptyBorder());
        next2.setCursor(cursor);
        next2.setVisible(true);
        frame.add(next2);

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

        try {
            File userfile = new File(".\\files\\user_login.txt");
            int k = ((ForgetPass.deleteLine) + 2);
            String line1 = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(k);
            String line2 = "";
            // for (int j = 16; j < line1.length(); j++) {
            line2 = line2 + line1.charAt(16);
            line2 = line2 + line1.charAt(17);
            line2 = line2 + line1.charAt(18);
            // }

            hintphn = new JLabel("Hint :xxxxxxxx" + line2);
            hintphn.setBounds(528, 210, 180, 30);
            hintphn.setForeground(new Color(245, 242, 208, 150));
            Font hintphnFont = new Font("Verdana", Font.BOLD, 14);
            hintphn.setFont(hintphnFont);
            hintphn.setVisible(true);
            frame.add(hintphn);

        } catch (Exception e) {
            System.out.println(e);
        }

        next2.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        String user = "Phone : " + phoneField.getText();
        String user1 = phoneField.getText();
        boolean userEmpty = user1.isEmpty();
        boolean yes = false;
        boolean yes2 = false;
        if (e.getSource() == next2) {

            try {
                File userfile = new File(".\\files\\user_login.txt");

                if (userEmpty == true) {

                    showMessageDialog(null, "Enter phone number", "Error", JOptionPane.WARNING_MESSAGE);

                } else if (userEmpty == false) {

                    int n = ((ForgetPass.deleteLine) + 2);
                    BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));
                    String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(n);
                    if (line.equals(user)) {
                        yes = true;

                    } else {
                        yes = false;
                    }

                    if (yes == false) {
                        showMessageDialog(null, "Phone number not found!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        frame.setVisible(false);
                        new ForgetPass3();
                    }
                    readFile.close();

                }

            } catch (Exception ex) {
                showMessageDialog(null, "Phone number not found!", "Error", JOptionPane.WARNING_MESSAGE);

            }
        } else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new ForgetPass();
        }
    }
}
