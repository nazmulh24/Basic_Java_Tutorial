package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    JButton back, search;

    SearchRoom() {
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


        //------------------------------------------------------------

        JLabel labelName = new JLabel("Search For Room");
        labelName.setBounds(230, 50, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(labelName);

        //--------------------------------------------------------------------

        JLabel status = new JLabel("Status : ");
        status.setBounds(250, 450, 120, 20);
        status.setFont(new Font("Tahoma", Font.BOLD, 17));
        status.setForeground(Color.WHITE);
        panel.add(status);

        //--------------------------------------------------------------------

        choice = new Choice();
        choice.setBounds(400, 450, 140, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        //--------------------------------------------------------------------

        table = new JTable();
        table.setBounds(100, 160, 650, 250);
        table.setBackground(new Color(90, 155, 163));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
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
        room.setBounds(100, 130, 150, 20);
        room.setFont(new Font("Tahoma", Font.BOLD, 15));
        room.setForeground(Color.WHITE);
        panel.add(room);

        //--------------------------------------------------------------------

        JLabel available = new JLabel("Availability");
        available.setBounds(264, 130, 150, 20);
        available.setFont(new Font("Tahoma", Font.BOLD, 15));
        available.setForeground(Color.WHITE);
        panel.add(available);

        //--------------------------------------------------------------------

        JLabel price = new JLabel("Price");
        price.setBounds(425, 130, 150, 20);
        price.setFont(new Font("Tahoma", Font.BOLD, 15));
        price.setForeground(Color.WHITE);
        panel.add(price);

        //--------------------------------------------------------------------

        JLabel r_type = new JLabel("Bed Type");
        r_type.setBounds(590, 130, 150, 30);
        r_type.setFont(new Font("Tahoma", Font.BOLD, 15));
        r_type.setForeground(Color.WHITE);
        panel.add(r_type);

        //--------------------------------------------------------------------

        search = new JButton("Search");
        search.setBounds(600, 600, 120, 40);
        search.setFont(new Font("Tahoma", Font.BOLD, 20));
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

        back = new JButton(("Back"));
        back.setBounds(470, 600, 100, 40);
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
        new SearchRoom();
    }
}
