package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {

    JButton back, check, discharge;
    Patient_Discharge() {
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

        //--------------------------------------------------------------------

        JLabel label1 = new JLabel("Check Out -");
        label1.setBounds(300, 50, 400, 50);
        label1.setFont(new Font("Tahoma", Font.BOLD, 40));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //--------------------------------------------------------------------

        JLabel label2 = new JLabel("Patient ID :");
        label2.setBounds(180, 250, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 17));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(330, 250, 200, 25);
        panel.add(choice);

        try {

            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------

        JLabel label3 = new JLabel("Room No : ");
        label3.setBounds(180, 300, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 17));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel RNo = new JLabel("");
        RNo.setBounds(330, 300, 150, 20);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 17));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        //--------------------------------------------------------------------

        JLabel label4 = new JLabel("In Time : ");
        label4.setBounds(180, 350, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 17));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel inTime = new JLabel("");
        inTime.setBounds(330, 350, 270, 20);
        inTime.setFont(new Font("Tahoma", Font.BOLD, 17));
        inTime.setForeground(Color.WHITE);
        panel.add(inTime);

        //--------------------------------------------------------------------

        JLabel label5 = new JLabel("Out Time :");
        label5.setBounds(180, 400, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 17));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();

        JLabel outTime = new JLabel("" + date);
        outTime.setBounds(330, 400, 270, 20);
        outTime.setFont(new Font("Tahoma", Font.BOLD, 17));
        outTime.setForeground(Color.WHITE);
        panel.add(outTime);

        //--------------------------------------------------------------------

        discharge = new JButton("Discharge");
        discharge.setBounds(600, 600, 130, 40);
        discharge.setFont(new Font("Tahoma", Font.BOLD, 20));
        discharge.setBackground(Color.gray);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    c.statement.executeUpdate("delete from Patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //--------------------------------------------------------------

        check = new JButton("Check");
        check.setBounds(480, 600, 100, 40);
        check.setFont(new Font("Tahoma", Font.BOLD, 20));
        check.setForeground(Color.WHITE);
        check.setBackground(Color.gray);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {

                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_info where number = '" + choice.getSelectedItem() + "'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room_number"));
                        inTime.setText(resultSet.getString("Time"));
                    }

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

//---------------------------------------------------------------------

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
        new Patient_Discharge();
    }
}
