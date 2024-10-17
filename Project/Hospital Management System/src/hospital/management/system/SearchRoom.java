package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;

    SearchRoom() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        //--------------------------------------------------------------------

        JLabel label1 = new JLabel("Search For Room");
        label1.setBounds(250, 10, 180, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //--------------------------------------------------------------------

        JLabel status = new JLabel("Status : ");
        status.setBounds(50, 70, 120, 20);
        status.setFont(new Font("Tahoma", Font.BOLD, 15));
        status.setForeground(Color.WHITE);
        panel.add(status);

        //--------------------------------------------------------------------

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        //--------------------------------------------------------------------

        table = new JTable();
        table.setBounds(0, 170, 730, 250);
        table.setBackground(new Color(90, 155, 160));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------

        JLabel room = new JLabel("Room No");
        room.setBounds(25, 140, 150, 20);
        room.setFont(new Font("Tahoma", Font.BOLD, 15));
        room.setForeground(Color.WHITE);
        panel.add(room);

        //--------------------------------------------------------------------

        JLabel available = new JLabel("Availability");
        available.setBounds(200, 140, 150, 20);
        available.setFont(new Font("Tahoma", Font.BOLD, 15));
        available.setForeground(Color.WHITE);
        panel.add(available);

        //--------------------------------------------------------------------

        JLabel price = new JLabel("Price");
        price.setBounds(400, 140, 150, 20);
        price.setFont(new Font("Tahoma", Font.BOLD, 15));
        price.setForeground(Color.WHITE);
        panel.add(price);

        //--------------------------------------------------------------------

        JLabel r_type = new JLabel("Bed Type");
        r_type.setBounds(600, 140, 150, 30);
        r_type.setFont(new Font("Tahoma", Font.BOLD, 15));
        r_type.setForeground(Color.WHITE);
        panel.add(r_type);

        //--------------------------------------------------------------------

        JButton search = new JButton("Search");
        search.setBounds(150, 430, 120, 30);
        search.setBackground(new Color(90, 155, 160));
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //--------------------------------------------------------------------

        JButton back = new JButton("Back");
        back.setBounds(400, 430, 120, 30);
        back.setBackground(new Color(90, 155, 160));
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
        setSize(700, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
