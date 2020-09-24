package CoreJava.Chapter10_JFrame.MyRectangle2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MyRectangle2DTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame test = new TestFrame();
            test.setTitle("MY");
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.setVisible(true);
        });
    }
}

class TestFrame extends JFrame {
    public TestFrame() {
        add(new TestComponent());
        pack();
    }
}

class TestComponent extends JComponent {

    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WEIGHT = 600;

    @Override
    public void paintComponent(Graphics test) {
        Rectangle2D t = new Rectangle2D.Double(150, 150, 300, 300);
        ((Graphics2D) test).draw(t);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WEIGHT, DEFAULT_HEIGHT);
    }
}
