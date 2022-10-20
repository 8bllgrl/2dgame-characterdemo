import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args) {

        MyPanel panel = new MyPanel();
        JFrame frame = new JFrame();

        frame.setResizable(false);
        frame.add(panel);
        frame.setTitle("2D Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        frame.setPreferredSize(new Dimension(950,740));
        frame.setSize(950,740);
        frame.setLocationRelativeTo(null);





        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }
}
