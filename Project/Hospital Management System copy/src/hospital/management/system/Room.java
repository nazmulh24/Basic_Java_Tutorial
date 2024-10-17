package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    JButton back;

    Room() {
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

//-----------------------------------------------------

        table = new JTable();
        table.setBounds(100, 130, 700, 450);
        table.setBackground(new Color(90, 155, 163, 0));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {

            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------
        JLabel labelName = new JLabel("Room Type -");
        labelName.setBounds(280, 30, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(labelName);

        //-----------------------------------------------------

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(100, 100, 140, 20);
        label1.setFont(new Font("Tahome", Font.BOLD, 17));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

//-----------------------------------------------------

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(275, 100, 130, 20);
        label2.setFont(new Font("Tahome", Font.BOLD, 17));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

//-----------------------------------------------------

        JLabel label3 = new JLabel("Price");
        label3.setBounds(450, 100, 100, 20);
        label3.setFont(new Font("Tahome", Font.BOLD, 17));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

//-----------------------------------------------------

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(625, 100, 100, 20);
        label4.setFont(new Font("Tahome", Font.BOLD, 17));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

//-----------------------------------------------------

        back = new JButton(("Back"));
        back.setBounds(620, 600, 100, 40);
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

//-----------------------------------------------------

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
