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

public class userAdd implements ActionListener {
    private Container c;
    private JFrame frame;
    private JLabel username;
    private JLabel password;
    private JLabel confpassword;
    private JLabel email;
    private JTextField userField;
    private JTextField emailField;
    private JPasswordField passField;
    private JPasswordField confpassField;
    private JLabel fullName;
    private JTextField fullField;

    private ImageIcon on;
    private ImageIcon off;
    private JToggleButton toggleButton;
    private JToggleButton toggleButton2;
    private JButton exitButton;
    private JButton useradd;
    private JButton backButton;

    private Cursor cursor;

    public userAdd() {

        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Add User");
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

        JLabel lo = new JLabel("Registation");
        lo.setBounds(383, 0, 200, 30);
        Font loFont = new Font("Verdana", Font.BOLD, 22);
        lo.setFont(loFont);
        lo.setForeground(new Color(215, 210, 203));
        frame.add(lo);

        fullName = new JLabel("Full Name :");
        fullName.setBounds(315, 60, 150, 50);
        Font fullNameFont = new Font("Verdana", Font.PLAIN, 17);
        fullName.setFont(fullNameFont);
        fullName.setForeground(Color.white);
        frame.add(fullName);

        fullField = new JTextField();
        fullField.setBounds(315, 100, 248, 30);
        Font fullFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        fullField.setFont(fullFieldFont);
        fullField.setOpaque(false);
        fullField.setForeground(new Color(219, 226, 233));
        fullField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        fullField.setBorder(redBorder);
        frame.add(fullField);

        username = new JLabel("User Name :");
        username.setBounds(315, 130, 150, 50);
        Font usernameFont = new Font("Verdana", Font.PLAIN, 17);
        username.setFont(usernameFont);
        username.setForeground(Color.white);
        frame.add(username);

        userField = new JTextField();
        userField.setBounds(315, 170, 248, 30);
        Font userfieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        userField.setFont(userfieldFont);
        userField.setOpaque(false);
        userField.setForeground(new Color(219, 226, 233));
        userField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        userField.setBorder(redBorder1);
        frame.add(userField);

        email = new JLabel("Phone Number :");
        email.setBounds(315, 200, 150, 50);
        Font emailFont = new Font("Verdana", Font.PLAIN, 17);
        email.setFont(emailFont);
        email.setForeground(Color.white);
        frame.add(email);

        emailField = new JTextField();
        emailField.setBounds(315, 240, 248, 30);
        Font emailFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        emailField.setFont(emailFieldFont);
        emailField.setOpaque(false);
        emailField.setForeground(new Color(219, 226, 233));
        emailField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        emailField.setBorder(redBorder2);
        frame.add(emailField);

        password = new JLabel("Password :");
        password.setBounds(315, 270, 150, 50);
        Font passwordFont = new Font("Verdana", Font.PLAIN, 17);
        password.setFont(passwordFont);
        password.setForeground(Color.white);
        frame.add(password);

        passField = new JPasswordField();
        passField.setBounds(315, 310, 212, 30);
        Font passfieldFont = new Font("Verdana", Font.PLAIN, 18);
        passField.setFont(passfieldFont);
        passField.setEchoChar('*');
        passField.setOpaque(false);
        passField.setForeground(new Color(219, 226, 233));
        passField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        passField.setBorder(redBorder3);
        frame.add(passField);

        confpassword = new JLabel("Confirm Password :");
        confpassword.setBounds(315, 340, 200, 50);
        Font cconfpasswordFont = new Font("Verdana", Font.PLAIN, 17);
        confpassword.setFont(cconfpasswordFont);
        confpassword.setForeground(Color.white);
        frame.add(confpassword);

        confpassField = new JPasswordField();
        confpassField.setBounds(315, 380, 212, 30);
        Font confpassFieldFont = new Font("Verdana", Font.PLAIN, 18);
        confpassField.setFont(confpassFieldFont);
        confpassField.setEchoChar('*');
        confpassField.setOpaque(false);
        confpassField.setForeground(new Color(219, 226, 233));
        confpassField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder4 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        confpassField.setBorder(redBorder4);
        frame.add(confpassField);

        useradd = new JButton("Add User");
        useradd.setBounds(360, 430, 150, 30);
        Font useraddFont = new Font("Monospace", Font.BOLD, 16);
        useradd.setBorder(BorderFactory.createEmptyBorder());
        useradd.setFont(useraddFont);
        useradd.setOpaque(false);
        useradd.setForeground(new Color(152, 152, 156));
        useradd.setOpaque(false);
        useradd.setBackground(new Color(0, 0, 0, 0));
        frame.add(useradd);
        useradd.setCursor(cursor);
        useradd.addActionListener(this);

        ImageIcon backimg = new ImageIcon("images/previous.png");
        backButton = new JButton(backimg);
        backButton.setBounds(0, 479, backimg.getIconWidth(), backimg.getIconHeight());
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(backButton);
        backButton.addActionListener(this);

        on = new ImageIcon("images/tg1.png");
        off = new ImageIcon("images/tg2.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(525, 300, 40, 40);
        toggleButton.setBackground(new Color(0, 0, 0, 0));
        toggleButton.setForeground(new Color(0, 0, 0, 0));
        toggleButton.setOpaque(false);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder5 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        toggleButton.setBorder(redBorder5);
        frame.add(toggleButton);

        toggleButton2 = new JToggleButton(off);
        toggleButton2.setBounds(525, 370, 40, 40);
        toggleButton2.setBackground(new Color(0, 0, 0, 0));
        toggleButton2.setForeground(new Color(0, 0, 0, 0));
        toggleButton2.setOpaque(false);
        toggleButton2.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder6 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        toggleButton2.setBorder(redBorder6);
        frame.add(toggleButton2);

        ImageIcon exit = new ImageIcon("images/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(805, 481, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(exitButton);

        exitButton.addActionListener(this);
        toggleButton.addActionListener(this);
        toggleButton2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = passField.getText();
        String confpass = confpassField.getText();
        String name = fullField.getText();
        String em = emailField.getText();
        boolean userEmpty = user.isEmpty();
        boolean passEmpty = pass.isEmpty();
        boolean confEmpty = confpass.isEmpty();
        boolean nameEmpty = name.isEmpty();
        boolean emailEmpty = em.isEmpty();
        boolean check = pass.equals(confpass);
        long number = 0;
        int numcount = 0;

        try {

            number = Integer.parseInt(em);
            if (em.length() != 11)
                numcount++;
        } catch (Exception ex) {
            numcount = 1;
        }

        if (e.getSource() == useradd) {

            if (userEmpty == true || passEmpty == true || confEmpty == true || nameEmpty == true
                    || emailEmpty == true) {
                showMessageDialog(null, "Please fill all of the fields.", "Error!", JOptionPane.WARNING_MESSAGE);
            } else if (numcount > 0) {
                showMessageDialog(null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);
            } else if (check == false) {
                showMessageDialog(null, "Password is not matching", " Error!", JOptionPane.WARNING_MESSAGE);
            }

            else {
                try {
                    File file = new File(".\\files\\user_login.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                    String timeAndDate = myDateObj.format(myFormatObj);

                    // User Login file checked
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
                        if (line.equals("User Name : " + user)) {
                            userflag = true;
                            break;
                        }
                    }

                    // for admin
                    for (int i = 0; i < totalLines2; i++) {
                        String line = Files.readAllLines(Paths.get(".\\files\\admin_login.txt")).get(i);
                        if (line.equals("User Name : " + user)) {
                            adminflag = true;
                            break;
                        }
                    }
                    if (userflag == false && adminflag == false) {
                        printWriter.println("===============================================");
                        printWriter.println("Full Name : " + name);
                        printWriter.println("User Name : " + user);
                        printWriter.println("Password : " + pass);
                        printWriter.println("Phone : " + em);
                        printWriter.println("Time & Date : " + timeAndDate);
                        printWriter.println("===============================================");
                        JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
                                "Registration Complete", JOptionPane.WARNING_MESSAGE);

                    } else {
                        showMessageDialog(null, "User name already taken", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    printWriter.close();

                } catch (Exception ex) {
                    System.out.print(ex);
                }

            }

        }

        else if (e.getSource() == toggleButton) {
            if (toggleButton.isSelected()) {
                toggleButton.setIcon(on);
                passField.setEchoChar((char) 0);
            } else {
                toggleButton.setIcon(off);
                passField.setEchoChar('*');
            }
        }

        else if (e.getSource() == toggleButton2) {
            if (toggleButton2.isSelected()) {
                toggleButton2.setIcon(on);
                confpassField.setEchoChar((char) 0);
            } else {
                toggleButton2.setIcon(off);
                confpassField.setEchoChar('*');
            }
        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new AdminHome();
        }
    }

}