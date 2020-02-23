package CoreJava.Chapter11_Event.PlafFrame;

import javax.swing.*;
import java.awt.*;

public class PlafFrameTest {
    public static void main(String []args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame =new PlafFrame();
            frame.setTitle("PlafFrameTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
