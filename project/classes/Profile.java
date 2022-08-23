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

public class Profile implements ActionListener {
    private Container c;
    private JFrame frame;
    private Cursor cursor;
    private JPanel panel;

    private JLabel fullName1;
    private JLabel displayName1;
    private JLabel phoneNumber1;
    private JLabel oldPassword1;
    private JLabel userName1;

    private JButton editButton;
    private JButton logoutButton;
    private JButton exitButton;
    private JButton backButton;

    public Profile() {
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Profile");
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

        panel = new JPanel();
        panel.setBounds(200, 200, 360, 300);
        panel.setLayout(null);
        panel.setVisible(true);
        // panel.setBackground(Color.white);
        panel.setOpaque(false);
        frame.add(panel);

        ImageIcon profile = new ImageIcon("images/profile.png");
        JLabel imgLabel = new JLabel(profile);
        imgLabel.setBounds(350, 0, profile.getIconWidth(), profile.getIconHeight());
        frame.add(imgLabel);

        String displayName = "";
        String p = Login.fullName;
        char ch;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ':' && p.charAt(i + 1) == ' ') {
                for (int j = i + 2; j < p.length(); j++) {
                    ch = p.charAt(j);
                    displayName = displayName + ch;
                }
                break;
            } else {

            }
        }

        displayName1 = new JLabel("Profile Information");
        displayName1.setBounds(340, 150, 200, 50);
        Font displayName1Font = new Font("Times New Roman", Font.PLAIN, 23);
        displayName1.setFont(displayName1Font);
        displayName1.setForeground(Color.decode("#6577b3"));
        frame.add(displayName1);

        fullName1 = new JLabel(Login.fullName);
        fullName1.setBounds(0, 0, 300, 50);
        Font fullName1Font = new Font("Times New Roman", Font.PLAIN, 22);
        fullName1.setFont(fullName1Font);
        fullName1.setForeground(Color.decode("#8ee0f0"));
        panel.add(fullName1);

        userName1 = new JLabel(Login.fullUsername);
        userName1.setBounds(0, 50, 300, 50);
        Font userName1Font = new Font("Times New Roman", Font.PLAIN, 22);
        userName1.setFont(userName1Font);
        userName1.setForeground(Color.decode("#8ee0f0"));
        panel.add(userName1);

        phoneNumber1 = new JLabel(Login.phoneNumber);
        phoneNumber1.setBounds(0, 100, 300, 50);
        Font phoneNumber1Font = new Font("Times New Roman", Font.PLAIN, 22);
        phoneNumber1.setFont(phoneNumber1Font);
        phoneNumber1.setForeground(Color.decode("#8ee0f0"));
        panel.add(phoneNumber1);

        editButton = new JButton("Edit Info");
        editButton.setBounds(368, 370, 80, 30);
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setForeground(Color.decode("#6577b3"));
        editButton.setOpaque(false);
        Font editButtonFont = new Font("Times New Roman", Font.BOLD, 17);
        editButton.setFont(editButtonFont);
        editButton.setCursor(cursor);
        frame.add(editButton);

        ImageIcon edit = new ImageIcon("images/edit.png");
        JLabel edit1 = new JLabel(edit);
        edit1.setBounds(342, 369, edit.getIconWidth(), edit.getIconHeight());
        frame.add(edit1);

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

        logoutButton.addActionListener(this);
        editButton.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            new Login();
        }

        else if (e.getSource() == editButton) {
            frame.setVisible(false);
            new Edit();
        }

        else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new CustomerHome();
        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Do you want to exit ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        }
    }
}
