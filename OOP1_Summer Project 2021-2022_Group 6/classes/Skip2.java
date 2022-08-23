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

public class Skip2 {

    public Skip2() {
        try {

            File oldFile2 = new File(".\\files\\all_shops.txt");
            oldFile2.delete();

            String tempfile = ".\\files\\all_shops.txt";
            File oldFile = new File(".\\files\\temp2.txt");
            File newFile = new File(".\\files\\all_shops.txt");
            int l = 0;
            String currentline;

            FileWriter fileWriter2 = new FileWriter(tempfile, false);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

            FileReader fr = new FileReader(".\\files\\temp2.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentline = br.readLine()) != null) {

                printWriter2.println(currentline);
            }
            printWriter2.flush();
            printWriter2.close();
            fr.close();
            br.close();
            bufferedWriter2.close();
            fileWriter2.close();
            oldFile.delete();
            new Skip();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
