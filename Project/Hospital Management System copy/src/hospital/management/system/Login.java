package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    private JTextField textField;
    private JPasswordField jPasswordField;
    private JButton loginButton, exitButton;

    public Login() {

        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 300, 500, 50, 50));

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
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 500);
            }
        };
        panel.setLayout(null);
        setContentPane(panel);

        JLabel hospitalLabel = new JLabel("Health & Hope Hopital");
        hospitalLabel.setBounds(35, 25, 250, 30);
        hospitalLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        hospitalLabel.setForeground(Color.BLACK);
        panel.add(hospitalLabel);

        JLabel welcomeLabel = new JLabel("Welcome Back!");
        welcomeLabel.setBounds(80, 160, 180, 30);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.BLACK);
        panel.add(welcomeLabel);

        JLabel loginLabel = new JLabel("Login to your existing account");
        loginLabel.setBounds(45, 185, 250, 30);
        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        loginLabel.setForeground(Color.BLACK);
        panel.add(loginLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35, 240, 100, 30);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        usernameLabel.setForeground(Color.BLACK);
        panel.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(35, 310, 100, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        passwordLabel.setForeground(Color.BLACK);
        panel.add(passwordLabel);

        textField = new JTextField();
        textField.setBounds(35, 270, 230, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        panel.add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(35, 340, 230, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 179, 0));
        panel.add(jPasswordField);

        ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image scaledLoginIcon = loginIcon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledLoginIcon);
        JLabel loginIconLabel = new JLabel(scaledIcon);
        loginIconLabel.setBounds(110, 70, 80, 80);
        panel.add(loginIconLabel);


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


        loginButton = new JButton("Login");
        loginButton.setBounds(45, 400, 90, 35);
        loginButton.setFont(new Font("Serif", Font.BOLD, 20));
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(160, 400, 90, 35);
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        exitButton.setBackground(Color.BLUE);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = new String(jPasswordField.getPassword());

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
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}

