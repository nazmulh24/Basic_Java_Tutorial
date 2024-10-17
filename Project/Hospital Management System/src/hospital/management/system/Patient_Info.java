package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_Info extends JFrame {
    Patient_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 155, 163));
        panel.setLayout(null);
        add(panel);
//---------------------------------------------------------------------------

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(90, 155, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(table);

        try {

            conn c = new conn();
            String q = "select * from Patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

//---------------------------------------------------------------------------

        JLabel label1 = new JLabel("ID Type");
        label1.setBounds(25, 15, 100, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        //---------------------------------------------------------------------------

        JLabel label2 = new JLabel("Number");
        label2.setBounds(135, 15, 100, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        //---------------------------------------------------------------------------

        JLabel label3 = new JLabel("Name");
        label3.setBounds(245, 15, 100, 15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        //---------------------------------------------------------------------------

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(355, 15, 100, 15);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        //---------------------------------------------------------------------------

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(460, 15, 100, 15);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        //---------------------------------------------------------------------------

        JLabel label6 = new JLabel("Room");
        label6.setBounds(590, 15, 100, 15);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        //---------------------------------------------------------------------------

        JLabel label7 = new JLabel("Time");
        label7.setBounds(690, 15, 100, 15);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label7);

        //---------------------------------------------------------------------------

        JLabel label8 = new JLabel("Diposite");
        label8.setBounds(800, 15, 100, 15);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label8);

        //---------------------------------------------------------------------------

        JButton back = new JButton("BACK");
        back.setBounds(400, 510, 120, 40);
        back.setBackground(Color.gray);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //---------------------------------------------------------------------------

        setUndecorated(true);

//---------------------------------------------------------------------------

        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Info();
    }
}
