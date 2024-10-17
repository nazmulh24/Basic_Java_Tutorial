package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {


        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(3, 3, 284, 700);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        //--------------------------------------------------------------

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(290, 3, 813, 700);
        panel2.setBackground(new Color(109, 164, 170));
        add(panel2);

        //--------------------------------------------------------------

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(50, 40, 200, 200);
        panel1.add(label);

        //--------------------------------------------------------------

        JButton bt1 = new JButton("Add new Patient");
        bt1.setBounds(30, 245, 220, 37);
        bt1.setFont(new Font("Arial", Font.BOLD, 17));
        bt1.setBackground(new Color(246, 215, 118));
        panel1.add(bt1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new New_Patient();
            }
        });
        //--------------------------------------------------------------
        JButton bt2 = new JButton("Room");
        bt2.setBounds(30, 288, 220, 37);
        bt2.setFont(new Font("Arial", Font.BOLD, 17));
        bt2.setBackground(new Color(246, 215, 118));
        panel1.add(bt2);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });
        //--------------------------------------------------------------
        JButton bt3 = new JButton("Depertment");
        bt3.setBounds(30, 331, 220, 37);
        bt3.setFont(new Font("Arial", Font.BOLD, 17));
        bt3.setBackground(new Color(246, 215, 118));
        panel1.add(bt3);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Depertment();
            }
        });
        //--------------------------------------------------------------
        JButton bt4 = new JButton("All Employee Info.");
        bt4.setBounds(30, 374, 220, 37);
        bt4.setFont(new Font("Arial", Font.BOLD, 17));
        bt4.setBackground(new Color(246, 215, 118));
        panel1.add(bt4);
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_Info();
            }
        });
        //--------------------------------------------------------------
        JButton bt5 = new JButton("Patient Info.");
        bt5.setBounds(30, 417, 220, 37);
        bt5.setFont(new Font("Arial", Font.BOLD, 17));
        bt5.setBackground(new Color(246, 215, 118));
        panel1.add(bt5);
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Info();
            }
        });
        //--------------------------------------------------------------
        JButton bt6 = new JButton("Patient Discharge");
        bt6.setBounds(30, 460, 220, 37);
        bt6.setFont(new Font("Arial", Font.BOLD, 17));
        bt6.setBackground(new Color(246, 215, 118));
        panel1.add(bt6);
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Discharge();
            }
        });
        //--------------------------------------------------------------
        JButton bt7 = new JButton("Update Patient Details");
        bt7.setBounds(30, 503, 220, 37);
        bt7.setFont(new Font("Arial", Font.BOLD, 17));
        bt7.setBackground(new Color(246, 215, 118));
        panel1.add(bt7);
        bt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_Patient_info();
            }
        });
        //--------------------------------------------------------------
        JButton bt8 = new JButton("Ambulance");
        bt8.setBounds(30, 546, 220, 37);
        bt8.setFont(new Font("Arial", Font.BOLD, 17));
        bt8.setBackground(new Color(246, 215, 118));
        panel1.add(bt8);
        bt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });
        //--------------------------------------------------------------
        JButton bt9 = new JButton("Search Room");
        bt9.setBounds(30, 589, 220, 37);
        bt9.setFont(new Font("Arial", Font.BOLD, 17));
        bt9.setBackground(new Color(246, 215, 118));
        panel1.add(bt9);
        bt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });
        //--------------------------------------------------------------
        JButton bt10 = new JButton("Log Out");
        bt10.setBounds(90, 645, 100, 35);
        bt10.setBackground(new Color(246, 215, 118));
        panel1.add(bt10);
        bt10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        //--------------------------------------------------------------

        setUndecorated(true);

        setSize(1106, 706);
        getContentPane().setBackground(Color.GREEN);
        setLocationRelativeTo(null);   //--> Open automatically Center in Screen...
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }

}
