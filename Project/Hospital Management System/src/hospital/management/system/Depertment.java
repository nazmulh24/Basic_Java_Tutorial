package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Depertment extends JFrame {

    JTable table;

    Depertment() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        add(panel);

//-----------------------------------------------------

        table = new JTable();
        table.setBounds(0, 40, 700, 300);
        table.setBackground(Color.gray);
        panel.add(table);

        try {

            conn c = new conn();
            String q = "Select * from depertment";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setFont(new Font("Tahoma", Font.BOLD, 15));
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------

        JLabel label = new JLabel("Depertment");
        label.setBounds(145, 11, 105, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label);

        //-----------------------------------------------------

        JLabel label1 = new JLabel("Phone No");
        label1.setBounds(431, 11, 105, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(label1);

        //-----------------------------------------------------

        JButton back = new JButton("BACK");
        back.setBounds(300, 370, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //-----------------------------------------------------

        setUndecorated(true);

        //------------------------------------------------
        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Depertment();
    }
}
