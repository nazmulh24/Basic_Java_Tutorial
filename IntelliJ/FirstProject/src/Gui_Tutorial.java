import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Tutorial implements ActionListener {

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public Gui_Tutorial() {

        frame = new JFrame();

        JButton button = new JButton("Click Here!");
        button.addActionListener(this);


        label = new JLabel("Number of Clicks : 0");


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);    //--> line-> 11
        panel.add(label);    //--> line-> 15


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("...Our GUI...");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Gui_Tutorial();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of Clicks : "+ count);
    }
}
