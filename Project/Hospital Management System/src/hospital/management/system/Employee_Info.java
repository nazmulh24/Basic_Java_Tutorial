package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_Info extends JFrame {
    Employee_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        //------------------------------------------------------------

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {

            conn c = new conn();
            String q = "select * from EMP_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //------------------------------------------------------------

        JLabel label1 = new JLabel("Occupation");
        label1.setBounds(12, 11, 90, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //------------------------------------------------------------

        JLabel label2 = new JLabel("Name");
        label2.setBounds(135, 11, 90, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        //------------------------------------------------------------

        JLabel label3 = new JLabel("Age");
        label3.setBounds(257, 11, 90, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        //------------------------------------------------------------

        JLabel label4 = new JLabel("Blood Group");
        label4.setBounds(380, 11, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        //------------------------------------------------------------

        JLabel label5 = new JLabel("Salary");
        label5.setBounds(503, 11, 90, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        //------------------------------------------------------------

        JLabel label6 = new JLabel("NID No");
        label6.setBounds(628, 11, 90, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        //------------------------------------------------------------

        JLabel label7 = new JLabel("Phone No");
        label7.setBounds(748, 11, 90, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        //------------------------------------------------------------

        JLabel label8 = new JLabel("G-mail");
        label8.setBounds(870, 11, 90, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        //------------------------------------------------------------

        JButton back = new JButton("BACK");
        back.setBounds(450, 500, 100, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.gray);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //------------------------------------------------------------

        setUndecorated(true);

        //------------------------------------------------------------
        setSize(1000, 600);
        setLocation(300, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_Info();
    }
}
