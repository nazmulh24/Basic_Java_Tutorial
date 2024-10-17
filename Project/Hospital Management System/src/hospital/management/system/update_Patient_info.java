package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class update_Patient_info extends JFrame {
    update_Patient_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        //--------------------------------------------------------------------

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        //------------------------------------------------------------------

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(130, 10, 250, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //--------------------------------------------------------------------

        JLabel label2 = new JLabel("Name");
        label2.setBounds(25, 60, 50, 17);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(220, 60,100, 25);
        panel.add(choice);

        try {

            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------

        JLabel label3 = new JLabel("Room No");
        label3.setBounds(25, 120, 80, 17);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField = new JTextField("");
        textField.setBounds(220, 120, 140, 20);
        panel.add(textField);

        //--------------------------------------------------------------------

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(25, 170, 100, 17);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField1 = new JTextField("");
        textField1.setBounds(220, 170, 160, 20);
        panel.add(textField1);

        //--------------------------------------------------------------------

        JLabel label5 = new JLabel("Amount Paid");
        label5.setBounds(25, 200, 80, 17);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField2 = new JTextField("");
        textField2.setBounds(220, 200, 140, 20);
        panel.add(textField2);

        //--------------------------------------------------------------------

        JLabel label6 = new JLabel("Pending Ammount ");
        label6.setBounds(25, 240, 80, 17);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField3 = new JTextField("");
        textField3.setBounds(220, 240, 140, 20);
        panel.add(textField3);

        //--------------------------------------------------------------------

        JButton check = new JButton("CHECK");
        check.setBounds(300, 370, 100, 40);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = choice.getSelectedItem();
                String q = "select * from patient_Info where Name = '"+id+"'";

                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField.setText(resultSet.getString("Room_Number"));
                        textField1.setText(resultSet.getString("Time"));
                        textField2.setText(resultSet.getString("Deposite"));

                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from Room where room_no = '"+textField.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price)-Integer.parseInt(textField2.getText());
                        textField3.setText(""+amountPaid);

                    }

                }catch(Exception E){
                    E.printStackTrace();
                }

            }
        });

//--------------------------------------------------------------------

        JButton upda = new JButton("UPDATE");
        upda.setBounds(100, 370, 100, 40);
        upda.setBackground(Color.BLACK);
        upda.setForeground(Color.WHITE);
        panel.add(upda);

        upda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                String q = choice.getSelectedItem();
                String room = textField.getText();
                String time = textField1.getText();
                String amount = textField2.getText();
                try {
                    c.statement.executeUpdate("update patient_Info set Room_number = '"+room+"',Time = '"+time+"',Deposite = '"+amount+"' where name = '"+q+"'");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Update Successfully");
                setVisible(false);
            }
        });

        //--------------------------------------------------------------------

        JButton back = new JButton("BACK");
        back.setBounds(500, 370, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //--------------------------------------------------------------------

        setUndecorated(true);

        //-----------------------------------------------------------------
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_Patient_info();
    }
}
