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

public class ForgetPass implements ActionListener {
    private JFrame frame;
    private JLabel username;
    private JTextField userField;
    private JButton next;
    private JButton exitButton;
    private JButton backButton;
    private Container c;
    private ImageIcon forgotUser;
    private Cursor cursor;
    protected static boolean loginFlag;
    protected static int deleteLine;

    public ForgetPass() {
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

        forgotUser = new ImageIcon("images/forgot_user.png");
        JLabel imgLabel = new JLabel(forgotUser);
        imgLabel.setBounds(0, 100, forgotUser.getIconWidth(), forgotUser.getIconHeight());
        frame.add(imgLabel);

        JLabel forget = new JLabel("Reset Password");
        forget.setBounds(375, 0, 200, 50);
        Font forgetFont = new Font("Times New Roman", Font.PLAIN, 22);
        forget.setFont(forgetFont);
        forget.setForeground(Color.white);
        frame.add(forget);

        username = new JLabel("User Name :");
        username.setBounds(385, 230, 180, 50);
        Font usernameFont = new Font("Verdana", Font.PLAIN, 18);
        username.setVisible(true);
        username.setFont(usernameFont);
        username.setForeground(Color.white);
        frame.add(username);

        userField = new JTextField();
        userField.setBounds(510, 242, 180, 30);
        Font userfieldFont = new Font("Times New Roman", Font.BOLD, 18);
        userField.setFont(userfieldFont);
        userField.setVisible(true);
        userField.setOpaque(false);
        userField.setForeground(new Color(219, 226, 233));
        userField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179, 63, 64));
        userField.setBorder(redBorder);
        frame.add(userField);

        ImageIcon fnext = new ImageIcon("images/fnext.png");
        next = new JButton(fnext);
        next.setBounds(652, 278, 45, 45);
        next.setBackground(new Color(0, 0, 0, 0));
        next.setOpaque(false);
        next.setBorder(BorderFactory.createEmptyBorder());
        next.setCursor(cursor);
        next.setVisible(true);
        frame.add(next);

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

        next.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String user = "User Name : " + userField.getText();
        String user1 = userField.getText();
        boolean userEmpty = user1.isEmpty();
        boolean yes = false;
        int totalLines = 0;

        if (e.getSource() == next) {
            try {
                File userfile = new File(".\\files\\user_login.txt");
                if (userfile.exists()) {
                    BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));

                    while (readFile.readLine() != null) {
                        totalLines++;
                    }
                    readFile.close();
                }

                if (userEmpty == true) {
                    showMessageDialog(null, "Enter User Name", "Error", JOptionPane.WARNING_MESSAGE);
                    yes = false;
                } else {

                    for (int i = 0; i < totalLines; i++) {

                        String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i);
                        if (line.equals(user)) {
                            deleteLine = i;
                            yes = true;
                            break;

                        }
                    }
                    if (yes == true) {
                        frame.setVisible(false);
                        new ForgetPass2();
                    } else {
                        showMessageDialog(null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                }

            } catch (Exception ex) {

                showMessageDialog(null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);

            }

        } else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new Login();
        }
    }
}