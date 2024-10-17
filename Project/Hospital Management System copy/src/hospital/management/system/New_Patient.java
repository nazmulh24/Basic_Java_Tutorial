package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2, r3;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    public New_Patient() {

        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 804, 694, 20, 20));

        JPanel panel = new JPanel() {
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
                return new Dimension(804, 694);
            }
        };
        panel.setLayout(null);
        setContentPane(panel);


        try {
            // Set Nimbus look and feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception btn) {
            btn.printStackTrace();
        }

        //--------------------------------------------------------------
        JLabel labelName = new JLabel("New Patient Form -");
        labelName.setBounds(220, 50, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(labelName);

        //--------------------------------------------------------------

        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(200, 150, 200, 25);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"NID card", "Passport number"});
        comboBox.setBounds(400, 150, 230, 25);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 17));
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground((Color.WHITE));
        panel.add(comboBox);

        //--------------------------------------------------------------

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(200, 200, 200, 25);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(400, 200, 230, 30);
        panel.add(textFieldNumber);
//--------------------------------------------------------------

        JLabel labelName1 = new JLabel("Name : ");
        labelName1.setBounds(200, 250, 200, 25);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(400, 250, 230, 30);
        panel.add(textName);
//--------------------------------------------------------------

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(200, 300, 230, 25);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        //--------------------------------------------------------------

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 16));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(395, 300, 80, 20);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 16));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(470, 300, 100, 20);
        panel.add(r2);
        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Tahoma", Font.BOLD, 16));
        r3.setForeground(Color.WHITE);
        r3.setBackground(new Color(109, 164, 170));
        r3.setBounds(560, 300, 80, 20);
        panel.add(r3);

        //--------------------------------------------------------------

        JLabel labelDisease = new JLabel("Disease : ");
        labelDisease.setBounds(200, 350, 200, 25);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(400, 350, 230, 30);
        panel.add(textFieldDisease);

//---------------------------------------------------------------

        JLabel labelRoom = new JLabel("Room : ");
        labelRoom.setBounds(200, 400, 200, 22);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        //---------------------------------------------------------------

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("Room_No"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(400, 400, 228, 25);
        c1.setFont(new Font("Tahoma", Font.BOLD, 17));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

        //--------------------------------------------------------------

        JLabel labelDeposite = new JLabel("Deposite : ");
        labelDeposite.setBounds(200, 450, 250, 25);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(400, 450, 230, 30);
        panel.add(textFieldDeposite);

        //---------------------------------------------------------------

        JLabel labelDate = new JLabel("Time : ");
        labelDate.setBounds(200, 500, 250, 25);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(400, 500, 500, 25);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 17));
        panel.add(date);

//--------------------------------------------------------------

        b1 = new JButton(("ADD"));
        b1.setBounds(600, 600, 100, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton(("Back"));
        b2.setBounds(450, 600, 100, 40);
        b2.setFont(new Font("Tahoma", Font.BOLD, 20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);

//--------------------------------------------------------------

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new New_Patient();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            } else if (r3.isSelected()) {
                radioBTN = "Others";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                String q = "insert into patient_info values ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";

                String q1 = "Update room set Availability = 'Occupied' where Room_No = " + s6;

                c.statement.executeUpdate((q));
                c.statement.executeUpdate((q1));
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
        }

    }
}
