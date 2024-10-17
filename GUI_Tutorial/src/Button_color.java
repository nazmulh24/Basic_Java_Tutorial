
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_color extends JFrame {
    Button_color() {

        try {
            // Set Nimbus look and feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    //-------------------------------------------------------------------------------------------

        JButton button = new JButton("Exit");
        button.setBounds(200, 100, 100, 35);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.GREEN);
        button.setForeground(Color.BLUE);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    //-------------------------------------------------------------------------------------------

        setSize(500, 300);
        setLocationRelativeTo(null); // Center the frame
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Button_color();
    }
}
