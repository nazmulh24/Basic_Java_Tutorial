package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance(){

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
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //------------------------------------------------------------

        JLabel label1 = new JLabel("Model Name");
        label1.setBounds(12, 11, 100, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //------------------------------------------------------------

        JLabel label2 = new JLabel(" ID Number ");
        label2.setBounds(200, 11, 100, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        //------------------------------------------------------------

        JLabel label3 = new JLabel("Driver Name");
        label3.setBounds(400, 11, 100, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        //------------------------------------------------------------

        JLabel label4 = new JLabel("Availability");
        label4.setBounds(600, 11, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        //------------------------------------------------------------

        JLabel label5 = new JLabel("Location");
        label5.setBounds(800, 11, 100, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        //------------------------------------------------------------

        JButton back = new JButton("BACK");
        back.setBounds(400, 500, 100, 40);
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
        //--------------------------------------------------------------------

        setUndecorated(true);

        //---------------------------------------------------------------------------
        setSize(1000, 600);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
