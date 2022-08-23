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

public class Login implements ActionListener {
    private JFrame frame;
    private JLabel username;
    private JLabel password;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JButton forgot;
    private JButton signup;
    private JButton exitButton;
    private JButton skipButton;
    private ImageIcon on;
    private ImageIcon off;
    private JToggleButton toggleButton;
    private Container c;
    private ImageIcon welcome;
    private Cursor cursor;
    protected static boolean loginFlag;
    public static String USERNAME;
    protected static String fullName;
    protected static String oldPassword;
    protected static String phoneNumber;
    protected static String fullUsername;

    public Login() {
        loginFlag = false;
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Login");
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

        welcome = new ImageIcon("images/welcome2.png");
        JLabel imgLabel = new JLabel(welcome);
        imgLabel.setBounds(45, 25, welcome.getIconWidth(), welcome.getIconHeight());
        frame.add(imgLabel);

        ImageIcon login = new ImageIcon("images/login logo2.png");
        JLabel imgLabel2 = new JLabel(login);
        imgLabel2.setBounds(30, 110, login.getIconWidth(), login.getIconHeight());
        frame.add(imgLabel2);

        JLabel lo = new JLabel("LOGIN");
        lo.setBounds(600, 140, 200, 30);
        Font loFont = new Font("Verdana", Font.BOLD, 22);
        lo.setFont(loFont);
        lo.setForeground(new Color(215, 210, 203));
        frame.add(lo);

        username = new JLabel("Username");
        username.setBounds(520, 200, 200, 30);
        Font usernameFont = new Font("Verdana", Font.PLAIN, 18);
        username.setFont(usernameFont);
        username.setForeground(new Color(215, 210, 203));
        frame.add(username);

        userField = new JTextField();
        userField.setBounds(520, 235, 236, 30);
        Font userfieldFont = new Font("Times New Roman", Font.BOLD, 17);
        userField.setFont(userfieldFont);
        userField.setOpaque(false);
        userField.setForeground(new Color(219, 226, 233));
        userField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        userField.setBorder(redBorder);
        frame.add(userField);

        password = new JLabel("Password");
        password.setBounds(520, 275, 200, 30);
        Font passwordFont = new Font("Verdana", Font.PLAIN, 18);
        password.setFont(passwordFont);
        password.setForeground(new Color(215, 210, 203));
        frame.add(password);

        passField = new JPasswordField();
        passField.setBounds(520, 310, 212, 30);
        Font passfieldFont = new Font("Verdana", Font.BOLD, 17);
        passField.setFont(passfieldFont);
        passField.setOpaque(false);
        passField.setForeground(new Color(219, 226, 233));
        passField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        passField.setBorder(redBorder2);
        passField.setEchoChar('*');
        frame.add(passField);

        forgot = new JButton("Forgotten Password ?");
        forgot.setBounds(648, 343, 120, 19);
        Font forgotFont = new Font("Monospace", Font.BOLD, 10);
        forgot.setBorder(BorderFactory.createEmptyBorder());
        forgot.setFont(forgotFont);
        forgot.setOpaque(false);
        forgot.setForeground(new Color(179, 63, 64));
        forgot.setOpaque(false);
        forgot.setBackground(new Color(0, 0, 0, 0));
        frame.add(forgot);
        forgot.setCursor(cursor);

        skipButton = new JButton("SKIP >>");
        skipButton.setBounds(748, 0, 120, 19);
        Font skipButtonFont = new Font("Monospace", Font.BOLD, 14);
        skipButton.setBorder(BorderFactory.createEmptyBorder());
        skipButton.setFont(skipButtonFont);
        skipButton.setOpaque(false);
        skipButton.setForeground(new Color(152, 152, 156));
        skipButton.setOpaque(false);
        skipButton.setBackground(new Color(0, 0, 0, 0));
        frame.add(skipButton);
        skipButton.setCursor(cursor);

        on = new ImageIcon("images/tg1.png");
        off = new ImageIcon("images/tg2.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(720, 300, 40, 40);
        toggleButton.setBackground(new Color(0, 0, 0, 0));
        toggleButton.setForeground(new Color(0, 0, 0, 0));
        toggleButton.setOpaque(false);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        toggleButton.setBorder(redBorder3);
        frame.add(toggleButton);

        ImageIcon loginb = new ImageIcon("images/Login_Button.png");
        loginButton = new JButton(loginb);
        loginButton.setBounds(600, 370, loginb.getIconWidth(), loginb.getIconHeight());
        loginButton.setBackground(new Color(0, 0, 0, 0));
        loginButton.setOpaque(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setCursor(cursor);
        frame.add(loginButton);

        ImageIcon exit = new ImageIcon("images/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(802, 478, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(exitButton);
        exitButton.setCursor(cursor);

        ImageIcon singupImage = new ImageIcon("images/Signup_Text.png");
        signup = new JButton(singupImage);
        signup.setBounds(610, 482, singupImage.getIconWidth(), singupImage.getIconHeight());
        signup.setBackground(Color.black);
        signup.setOpaque(false);
        signup.setBorder(BorderFactory.createEmptyBorder());
        frame.add(signup);
        signup.setCursor(cursor);

        JLabel sign = new JLabel("Don't have an account?");
        sign.setBounds(450, 472, 200, 50);
        Font signFont = new Font("Verdana", Font.PLAIN, 13);
        sign.setFont(signFont);
        sign.setForeground(new Color(215, 210, 203));
        frame.add(sign);

        toggleButton.addActionListener(this);
        signup.addActionListener(this);
        exitButton.addActionListener(this);
        loginButton.addActionListener(this);
        skipButton.addActionListener(this);
        forgot.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = passField.getText();
        boolean userEmpty = user.isEmpty();
        boolean passEmpty = pass.isEmpty();

        if (e.getSource() == toggleButton) {
            if (toggleButton.isSelected()) {
                toggleButton.setIcon(on);
                passField.setEchoChar((char) 0);
            } else {
                toggleButton.setIcon(off);
                passField.setEchoChar('*');
            }
        }

        else if (e.getSource() == signup) {
            frame.setVisible(false);
            new Signup();
        }

        else if (e.getSource() == skipButton) {
            frame.setVisible(false);
            new Skip();

        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        }

        else if (e.getSource() == loginButton) {
            if (userEmpty == true || passEmpty == true) {
                showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            }

            else {
                boolean userbool = false;
                boolean adminbool = false;
                try {
                    File file = new File(".\\files\\admin_login.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);

                        printWriter.println("===============================================");
                        printWriter.println("User Name : admin");
                        printWriter.println("Password : admin");
                        printWriter.println("===============================================");
                        printWriter.close();
                    }

                    String uname = "User Name : " + user;
                    String pin = "Password : " + pass;

                    // for admin
                    BufferedReader readFile1 = new BufferedReader(new FileReader(".\\files\\admin_login.txt"));

                    // for admin
                    int totalLines1 = 0;
                    while (readFile1.readLine() != null) {
                        totalLines1++;
                    }
                    readFile1.close();

                    // for admin login
                    for (int i = 0; i < totalLines1; i++) {

                        String line = Files.readAllLines(Paths.get(".\\files\\admin_login.txt")).get(i);
                        if (line.equals(uname)) {
                            String line2 = Files.readAllLines(Paths.get(".\\files\\admin_login.txt")).get((i + 1));
                            if (line2.equals(pin)) {

                                frame.setVisible(false);
                                new AdminHome();

                                loginFlag = true;
                                adminbool = true;
                                USERNAME = user;
                                break;
                            } else {
                                adminbool = false;
                            }
                        } else {
                            adminbool = false;
                        }
                    }

                    // for user
                    if (adminbool == false) {
                        File userfile = new File(".\\files\\user_login.txt");
                        if (userfile.exists()) {
                            BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));
                            int totalLines = 0;
                            while (readFile.readLine() != null) {
                                totalLines++;
                            }
                            readFile.close();

                            // for user login
                            for (int i = 0; i < totalLines; i++) {

                                String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i);
                                if (line.equals(uname)) {
                                    String line2 = Files.readAllLines(Paths.get(".\\files\\user_login.txt"))
                                            .get((i + 1));
                                    if (line2.equals(pin)) {

                                        loginFlag = true;
                                        userbool = true;
                                        USERNAME = user;

                                        fullName = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i - 1);
                                        phoneNumber = Files.readAllLines(Paths.get(".\\files\\user_login.txt"))
                                                .get(i + 2);
                                        oldPassword = Files.readAllLines(Paths.get(".\\files\\user_login.txt"))
                                                .get(i + 1);
                                        fullUsername = uname;

                                        File file3 = new File(".\\files\\" + USERNAME + "_shops.txt");
                                        if (!file3.exists()) {
                                            file3.createNewFile();
                                        }

                                        frame.setVisible(false);
                                        new CustomerHome();

                                        break;
                                    } else {
                                        userbool = false;
                                    }
                                } else {
                                    userbool = false;
                                }
                            }
                        } else {
                            userbool = false;
                        }
                    }
                    if (userbool == false && adminbool == false) {
                        showMessageDialog(null, "Invalid Name or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }

                }

                catch (Exception ex) {
                    if (userbool == false && adminbool == false) {
                        showMessageDialog(null, "Invalid Name or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        } else if (e.getSource() == forgot) {
            frame.setVisible(false);
            new ForgetPass();
        }

    }

    public static boolean getloginFlag() {
        return loginFlag;
    }

}