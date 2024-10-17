package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    public Test(){
        setUndecorated(true);
//        setBackground(Color.BLUE);
        setBounds(600, 200, 400, 600);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }

}
