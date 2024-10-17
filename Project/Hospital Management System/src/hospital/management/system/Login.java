package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton back_, exit_;


    Login() {

        JLabel label1 = new JLabel("ABC HOSPITAL LTD.");
        label1.setBounds(70, 30, 250, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 17));
        label1.setForeground(Color.BLACK);
        add(label1);

        JLabel label2 = new JLabel("Welcome Back!");
        label2.setBounds(80, 160, 180, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);
        add(label2);

        JLabel label3 = new JLabel("Login to your existing account");
        label3.setBounds(45, 185, 250, 30);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.BLACK);
        add(label3);

        JLabel u_name = new JLabel("Username : ");
        u_name.setBounds(35, 240, 100, 30);
        u_name.setFont(new Font("Tahoma", Font.BOLD, 16));
        u_name.setForeground(Color.BLACK);
        add(u_name);

//------------------------------------------------------------------

        JLabel password = new JLabel("Password : ");
        password.setBounds(35, 310, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);
//------------------------------------------------------------------
        textField = new JTextField();
        textField.setBounds(35, 270, 230, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        add(textField);
//------------------------------------------------------------------
        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(35, 340, 230, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 179, 0));
        add(jPasswordField);
//------------------------------------------------------------------
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(110, 70, 80, 80);
        add(label);

        //------------------------------------------------------------------

        try {
            // Set Nimbus look and feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception btn) {
            btn.printStackTrace();
        }

        //------------------------------------------------------------------

        back_ = new JButton("Login");
        back_.setBounds(45, 400, 90, 35);
        back_.setFont(new Font("serif", Font.BOLD, 20));
        back_.setBackground(Color.BLUE);
        back_.setForeground(Color.WHITE);
        back_.addActionListener(this);
        add(back_);

        //------------------------------------------------------------------
        exit_ = new JButton("Exit!");
        exit_.setBounds(160, 400, 90, 35);
        exit_.setFont(new Font("serif", Font.BOLD, 20));
        exit_.setBackground(Color.BLUE);
        exit_.setForeground(Color.WHITE);
        exit_.addActionListener(this);
        add(exit_);


//------------------------------------------------------------------
        setUndecorated(true);

//        getContentPane().setBackground(new Color(200, 230, 215));

        setSize(300, 500);   //--> Size of login window...
        setLocationRelativeTo(null);   //--> Open automatically Center in Screen...
        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q = "select * from login where ID = '" + user + "' and PW = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect! Try again.");
                }


            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            System.exit(1000);
        }

    }
}

