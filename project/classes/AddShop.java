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

public class AddShop implements ActionListener {
    private Container c;
    private JFrame frame;
    private JLabel type;
    private JLabel size;
    private JLabel shopNo;
    private JLabel rent;
    private JLabel place;
    private JLabel max;
    private JLabel imgLabel2;

    private JTextField attach;
    private JTextField typeField;
    private JTextField rentField;
    private JTextField sizeField;
    private JTextField shopField;
    private JTextField placeField;

    private JButton exitButton;
    private JButton attachButton;
    private JButton submitButton;
    private JButton backButton;
    private JButton logoutButton;

    private JPanel panel;

    private Cursor cursor;

    public AddShop() {

        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Add Shop");
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
        panel.setBounds(520, 90, 260, 260);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(49, 111, 112, 50));
        c.add(panel);

        JLabel add = new JLabel("Add Shop Details");
        add.setBounds(360, 0, 200, 30);
        Font addFont = new Font("Times New Roman", Font.BOLD, 22);
        add.setFont(addFont);
        add.setForeground(Color.decode("#8ee0f0"));
        frame.add(add);

        type = new JLabel("Type :");
        type.setBounds(150, 30, 150, 50);
        Font typeFont = new Font("Times New Roman", Font.PLAIN, 20);
        type.setFont(typeFont);
        type.setForeground(Color.decode("#8ee0f0"));
        frame.add(type);

        typeField = new JTextField();
        typeField.setBounds(150, 80, 236, 30);
        Font userfieldFont = new Font("Verdana", Font.PLAIN, 17);
        typeField.setFont(userfieldFont);
        typeField.setOpaque(false);
        typeField.setForeground(new Color(219, 226, 233));
        typeField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        typeField.setBorder(redBorder1);
        frame.add(typeField);

        place = new JLabel("Place :");
        place.setBounds(150, 130, 150, 50);
        Font fullNameFont = new Font("Times New Roman", Font.PLAIN, 20);
        place.setFont(fullNameFont);
        place.setForeground(Color.decode("#8ee0f0"));
        frame.add(place);

        placeField = new JTextField();
        placeField.setBounds(150, 170, 236, 30);
        Font fullFieldFont = new Font("Verdana", Font.PLAIN, 17);
        placeField.setFont(fullFieldFont);
        placeField.setOpaque(false);
        placeField.setForeground(new Color(219, 226, 233));
        placeField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        placeField.setBorder(redBorder);
        frame.add(placeField);

        size = new JLabel("Size :");
        size.setBounds(150, 220, 150, 50);
        Font passwordFont = new Font("Times New Roman", Font.PLAIN, 20);
        size.setFont(passwordFont);
        size.setForeground(Color.decode("#8ee0f0"));
        frame.add(size);

        sizeField = new JTextField();
        sizeField.setBounds(150, 260, 236, 30);
        Font passfieldFont = new Font("Verdana", Font.PLAIN, 17);
        sizeField.setFont(passfieldFont);
        sizeField.setOpaque(false);
        sizeField.setForeground(new Color(219, 226, 233));
        sizeField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        sizeField.setBorder(redBorder3);
        frame.add(sizeField);

        shopNo = new JLabel("Shop No :");
        shopNo.setBounds(150, 310, 200, 50);
        Font cconfpasswordFont = new Font("Times New Roman", Font.PLAIN, 20);
        shopNo.setFont(cconfpasswordFont);
        shopNo.setForeground(Color.decode("#8ee0f0"));
        frame.add(shopNo);

        shopField = new JTextField();
        shopField.setBounds(150, 350, 236, 30);
        Font confpassFieldFont = new Font("Verdana", Font.PLAIN, 17);
        shopField.setFont(confpassFieldFont);
        shopField.setOpaque(false);
        shopField.setForeground(new Color(219, 226, 233));
        shopField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder4 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        shopField.setBorder(redBorder4);
        frame.add(shopField);

        rent = new JLabel("Rent per month :");
        rent.setBounds(150, 400, 150, 50);
        Font emailFont = new Font("Times New Roman", Font.PLAIN, 20);
        rent.setFont(emailFont);
        rent.setForeground(Color.decode("#8ee0f0"));
        frame.add(rent);

        rentField = new JTextField();
        rentField.setBounds(150, 440, 236, 30);
        Font emailFieldFont = new Font("Verdana", Font.PLAIN, 17);
        rentField.setFont(emailFieldFont);
        rentField.setOpaque(false);
        rentField.setForeground(new Color(219, 226, 233));
        rentField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
        rentField.setBorder(redBorder2);
        frame.add(rentField);

        JLabel addPhoto = new JLabel("Add a photo here ");
        addPhoto.setBounds(593, 65, 150, 30);
        Font addPhotoFont = new Font("Times New Roman", Font.BOLD, 17);
        addPhoto.setFont(addPhotoFont);
        addPhoto.setForeground(new Color(49, 111, 112));
        frame.add(addPhoto);

        max = new JLabel("Max Photo Size 260 * 260");
        max.setBounds(656, 345, 150, 30);
        Font maxFont = new Font("Times New Roman", Font.PLAIN, 11);
        max.setFont(maxFont);
        max.setForeground(new Color(49, 111, 112));
        frame.add(max);

        attach = new JTextField();
        attach.setBounds(540, 365, 220, 30);
        Font attachFont = new Font("Verdana", Font.PLAIN, 17);
        attach.setFont(attachFont);
        attach.setOpaque(false);
        attach.setForeground(new Color(219, 226, 233));
        attach.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(49, 111, 112));
        attach.setBorder(redBorder5);
        frame.add(attach);

        attachButton = new JButton("Attachment");
        attachButton.setBounds(540, 395, 100, 30);
        attachButton.setBackground(new Color(49, 111, 112));
        attachButton.setForeground(Color.decode("#8ee0f0"));
        Font attachButtonFont = new Font("Times New Roman", Font.BOLD, 15);
        attachButton.setFont(attachButtonFont);
        attachButton.setCursor(cursor);
        attachButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(attachButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(660, 395, 100, 30);
        submitButton.setBackground(new Color(49, 111, 112));
        submitButton.setForeground(Color.decode("#8ee0f0"));
        Font submitButtonFont = new Font("Times New Roman", Font.BOLD, 15);
        submitButton.setFont(submitButtonFont);
        submitButton.setCursor(cursor);
        submitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(submitButton);

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

        imgLabel2 = new JLabel();
        panel.add(imgLabel2);

        logoutButton.addActionListener(this);
        submitButton.addActionListener(this);
        attachButton.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String type1 = typeField.getText();
        String size1 = sizeField.getText();
        String rent1 = rentField.getText();
        String shop1 = shopField.getText();
        String place1 = placeField.getText();
        String attach1 = attach.getText();

        boolean typeEmpty = type1.isEmpty();
        boolean sizeEmpty = size1.isEmpty();
        boolean rentEmpty = rent1.isEmpty();
        boolean shopEmpty = shop1.isEmpty();
        boolean placeEmpty = place1.isEmpty();
        boolean attachEmpty = attach1.isEmpty();

        if (e.getSource() == submitButton) {
            if (typeEmpty == false && sizeEmpty == false && rentEmpty == false && shopEmpty == false
                    && placeEmpty == false && attachEmpty == false) {
                try {
                    int n = Integer.parseInt(rent1);
                    String line = ".\\files\\all_shops.txt";
                    try {
                        File file = new File(line);
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);
                            printWriter.close();
                        }

                        BufferedReader readFile3 = new BufferedReader(new FileReader(".\\files\\all_shops.txt"));
                        int totalLines3 = 0;
                        while (readFile3.readLine() != null) {
                            totalLines3++;
                        }
                        readFile3.close();

                        boolean flag = true;
                        for (int k = 0; k < totalLines3; k++) {

                            String linek = Files.readAllLines(Paths.get(".\\files\\all_shops.txt")).get(k);
                            if (linek.equals(type1)) {
                                flag = false;
                                break;
                            }

                        }
                        if (flag == true) {
                            String image = "";
                            String p = attach1;
                            char ch;
                            for (int i = attach1.length() - 1; i >= 0; i--) {
                                if (p.charAt(i) == '\\') {
                                    break;
                                } else {
                                    ch = p.charAt(i);
                                    image = ch + image;
                                }
                            }
                            image = "images/" + image;
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);

                            printWriter.println("Shop Details");
                            printWriter.println(type1);
                            printWriter.println(size1);
                            printWriter.println(shop1);
                            printWriter.println(rent1);
                            printWriter.println(place1);
                            printWriter.println(image);
                            printWriter.println();
                            printWriter.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Same type shop already exist", "Error",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        frame.setVisible(false);
                        new AdminHome();

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Rent Field", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }

            } else if (typeEmpty == false && sizeEmpty == false && rentEmpty == false && shopEmpty == false
                    && placeEmpty == false && attachEmpty == true) {
                JOptionPane.showMessageDialog(null, "Please attach a photo", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all the field", "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == attachButton)

        {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                attach.setText(filename);
                imgLabel2.setIcon(new ImageIcon(filename));
                imgLabel2.setBounds(0, 0, 260, 260);

            } catch (Exception ex) {
                return;
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
        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new AdminHome();
        }
    }

}