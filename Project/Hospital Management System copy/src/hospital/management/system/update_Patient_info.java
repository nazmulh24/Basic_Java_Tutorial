package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class update_Patient_info extends JFrame {

    JButton back, check, upda;
    update_Patient_info(){
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

        //------------------------------------------------------------------

        JLabel label1 = new JLabel("Update Patient Details -");
        label1.setBounds(180, 30, 500, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 40));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //--------------------------------------------------------------------

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(200, 200, 80, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 17));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(390, 200,250, 25);
        choice.setFont(new Font("Tahoma", Font.BOLD, 15));
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

        JLabel label3 = new JLabel("Room No : ");
        label3.setBounds(200, 250, 120, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 17));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField = new JTextField("");
        textField.setBounds(390, 250, 250, 25);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(textField);

        //--------------------------------------------------------------------

        JLabel label4 = new JLabel("In Time : ");
        label4.setBounds(200, 300, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 17));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField1 = new JTextField("");
        textField1.setBounds(390, 300, 250, 25);
        textField1.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(textField1);

        //--------------------------------------------------------------------

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(200, 350, 120, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 17));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField2 = new JTextField("");
        textField2.setBounds(390, 350, 250, 25);
        textField2.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(textField2);

        //--------------------------------------------------------------------

        JLabel label6 = new JLabel("Pending Ammount :");
        label6.setBounds(200, 400, 170, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 17));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField3 = new JTextField("");
        textField3.setBounds(390, 400, 250, 25);
        textField3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(textField3);

        //--------------------------------------------------------------------

        check = new JButton("Check");
        check.setBounds(480, 600, 100, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 20));
        check.setForeground(Color.WHITE);
        check.setBackground(Color.gray);
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

        upda = new JButton("UPDATE");
        upda.setBounds(600, 600, 130, 40);
        upda.setFont(new Font("Tahoma", Font.BOLD, 20));
        upda.setBackground(Color.gray);
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

        back = new JButton(("Back"));
        back.setBounds(360, 600, 100, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //--------------------------------------------------------------------

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_Patient_info();
    }
}
