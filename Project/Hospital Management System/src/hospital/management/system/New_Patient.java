package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 510);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);
        //--------------------------------------------------------------
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);
        //--------------------------------------------------------------
        JLabel labelName = new JLabel("New Patient Form -");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);
        //--------------------------------------------------------------
        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(40, 75, 200, 15);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"NID card", "Passport number"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground((Color.WHITE));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(comboBox);

        //--------------------------------------------------------------

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(40, 111, 200, 15);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);
//--------------------------------------------------------------

        JLabel labelName1 = new JLabel("Name : ");
        labelName1.setBounds(40, 151, 200, 15);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);
//--------------------------------------------------------------

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(40, 191, 200, 15);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        //--------------------------------------------------------------

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 15));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(271, 191, 80, 20);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 15));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(350, 191, 80, 20);
        panel.add(r2);
        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Tahoma", Font.BOLD, 15));
        r3.setForeground(Color.WHITE);
        r3.setBackground(new Color(109, 164, 170));
        r3.setBounds(430, 191, 80, 20);
        panel.add(r3);

        //--------------------------------------------------------------

        JLabel labelDisease = new JLabel("Disease : ");
        labelDisease.setBounds(40, 231, 200, 15);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

//---------------------------------------------------------------

        JLabel labelRoom = new JLabel("Room : ");
        labelRoom.setBounds(40, 271, 200, 15);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
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

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 15));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

//---------------------------------------------------------------

        JLabel labelDate = new JLabel("Time : ");
        labelDate.setBounds(40, 315, 200, 15);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 315, 300, 15);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(date);

        //--------------------------------------------------------------

        JLabel labelDeposite = new JLabel("Deposite : ");
        labelDeposite.setBounds(40, 360, 200, 15);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 360, 150, 20);
        panel.add(textFieldDeposite);

//--------------------------------------------------------------

        b1 = new JButton(("ADD"));
        b1.setBounds(100, 430, 100, 40);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton(("Back"));
        b2.setBounds(250, 430, 100, 40);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);

//--------------------------------------------------------------


        setUndecorated(true);

//--------------------------------------------------------------
        setSize(700, 600);
        setLayout(null);
        setLocation(300, 250);
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
