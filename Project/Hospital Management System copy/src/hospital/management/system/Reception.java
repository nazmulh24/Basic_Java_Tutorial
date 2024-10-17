package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Reception extends JFrame {

    Reception() {

        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 284, 700, 20, 20));

        JPanel panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                Color color1 = new Color(51, 204, 255);
                Color color2 = new Color(255, 153, 204);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 500);
            }
        };
        panel1.setLayout(null);
        setContentPane(panel1);


        //--------------------------------------------------------------

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(290, 3, 813, 706);
        panel2.setBackground(new Color(109, 164, 170));
        add(panel2);

        //--------------------------------------------------------------

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/aa.png"));
        Image image = i1.getImage().getScaledInstance(270, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(50, 40, 200, 200);
        panel1.add(label);

        //--------------------------------------------------------------

        JButton bt1 = new JButton("Add new Patient");
        bt1.setBounds(30, 245, 220, 37);
        bt1.setFont(new Font("Arial", Font.BOLD, 17));
        bt1.setBackground(new Color(243, 157, 90));
        panel1.add(bt1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                New_Patient newPatient = new New_Patient();
                newPatient.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt2 = new JButton("Room");
        bt2.setBounds(30, 288, 220, 37);
        bt2.setFont(new Font("Arial", Font.BOLD, 17));
        bt2.setBackground(new Color(243, 157, 90));
        panel1.add(bt2);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Room room = new Room();
                room.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt3 = new JButton("Depertment");
        bt3.setBounds(30, 331, 220, 37);
        bt3.setFont(new Font("Arial", Font.BOLD, 17));
        bt3.setBackground(new Color(243, 157, 90));
        panel1.add(bt3);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Depertment depertment = new Depertment();
                depertment.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt4 = new JButton("All Employee Info.");
        bt4.setBounds(30, 374, 220, 37);
        bt4.setFont(new Font("Arial", Font.BOLD, 17));
        bt4.setBackground(new Color(243, 157, 90));
        panel1.add(bt4);
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee_Info empl_info = new Employee_Info();
                empl_info.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt5 = new JButton("Patient Info.");
        bt5.setBounds(30, 417, 220, 37);
        bt5.setFont(new Font("Arial", Font.BOLD, 17));
        bt5.setBackground(new Color(243, 157, 90));
        panel1.add(bt5);
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Patient_Info patient_info = new Patient_Info();
                patient_info.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt6 = new JButton("Patient Discharge");
        bt6.setBounds(30, 460, 220, 37);
        bt6.setFont(new Font("Arial", Font.BOLD, 17));
        bt6.setBackground(new Color(243, 157, 90));
        panel1.add(bt6);
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Patient_Discharge patient_dis = new Patient_Discharge();
                patient_dis.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt7 = new JButton("Update Patient Details");
        bt7.setBounds(30, 503, 220, 37);
        bt7.setFont(new Font("Arial", Font.BOLD, 17));
        bt7.setBackground(new Color(243, 157, 90));
        panel1.add(bt7);
        bt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_Patient_info update_P_info = new update_Patient_info();
                update_P_info.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });

        //--------------------------------------------------------------
        JButton bt8 = new JButton("Ambulance");
        bt8.setBounds(30, 546, 220, 37);
        bt8.setFont(new Font("Arial", Font.BOLD, 17));
        bt8.setBackground(new Color(243, 157, 90));
        panel1.add(bt8);
        bt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ambulance ambulance = new Ambulance();
                ambulance.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt9 = new JButton("Search Room");
        bt9.setBounds(30, 589, 220, 37);
        bt9.setFont(new Font("Arial", Font.BOLD, 17));
        bt9.setBackground(new Color(243, 157, 90));
        panel1.add(bt9);
        bt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchRoom search_r = new SearchRoom();
                search_r.setLocation(panel2.getLocationOnScreen().x+5, panel2.getLocationOnScreen().y+5);
            }
        });
        //--------------------------------------------------------------
        JButton bt10 = new JButton("Log Out");
        bt10.setBounds(90, 645, 100, 35);
        bt10.setBackground(new Color(243, 157, 90));
        panel1.add(bt10);
        bt10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        //--------------------------------------------------------------

        setSize(1106, 706);
//        getContentPane().setBackground(Color.GREEN);
        setLocationRelativeTo(null);   //--> Open automatically Center in Screen...
        setLayout(null);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Reception();
    }

}


