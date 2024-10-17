package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        //--------------------------------------------------------------------

        JLabel label1 = new JLabel("Check Out");
        label1.setBounds(150, 20, 150, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        //--------------------------------------------------------------------

        JLabel label2 = new JLabel("Patient ID");
        label2.setBounds(50, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
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

        JLabel label3 = new JLabel("Room No");
        label3.setBounds(50, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel RNo = new JLabel("");
        RNo.setBounds(200, 130, 150, 20);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        //--------------------------------------------------------------------

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(50, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel inTime = new JLabel("");
        inTime.setBounds(200, 180, 150, 20);
        inTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        inTime.setForeground(Color.WHITE);
        panel.add(inTime);

        //--------------------------------------------------------------------

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(50, 230, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();

        JLabel outTime = new JLabel("" + date);
        outTime.setBounds(200, 230, 230, 20);
        outTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        outTime.setForeground(Color.WHITE);
        panel.add(outTime);

        //--------------------------------------------------------------------

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(130, 330, 130, 40);
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

        JButton check = new JButton("Check");
        check.setBounds(280, 330, 130, 40);
        check.setBackground(Color.gray);
        check.setForeground(Color.WHITE);
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

        JButton back = new JButton("BACK");
        back.setBounds(450, 330, 120, 40);
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
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
