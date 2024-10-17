package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class Patient_Info extends JFrame {

    JButton back;
    Patient_Info() {
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

        JLabel labelName = new JLabel("All Patient Info - ");
        labelName.setBounds(230, 30, 400, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(labelName);

        //---------------------------------------------------------------------------

        JTable table = new JTable();
        table.setBounds(10, 130, 800, 450);
        table.setBackground(new Color(90, 155, 163, 0));
        table.setForeground(Color.WHITE);
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
        label1.setBounds(10, 100, 100, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        //---------------------------------------------------------------------------

        JLabel label2 = new JLabel("Number");
        label2.setBounds(110, 100, 100, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        //---------------------------------------------------------------------------

        JLabel label3 = new JLabel("Name");
        label3.setBounds(212, 100, 100, 15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        //---------------------------------------------------------------------------

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(310, 100, 100, 15);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        //---------------------------------------------------------------------------

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(410, 100, 100, 15);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        //---------------------------------------------------------------------------

        JLabel label6 = new JLabel("Room");
        label6.setBounds(510, 100, 100, 15);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        //---------------------------------------------------------------------------

        JLabel label7 = new JLabel("Time");
        label7.setBounds(610, 100, 100, 15);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label7);

        //---------------------------------------------------------------------------

        JLabel label8 = new JLabel("Diposite");
        label8.setBounds(710, 100, 100, 15);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label8);

        //---------------------------------------------------------------------------

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

        //---------------------------------------------------------------------------

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Info();
    }
}
