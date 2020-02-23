package Chapter11_Event.ButtonFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrameTest extends JFrame
{
    //面板
    private JPanel buttonPanel;

    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=300;

    public ButtonFrameTest()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //创建按钮
        JButton yellowButton=new JButton("Yellow");
        JButton blueButton=new JButton("Blue");
        JButton redButton=new JButton("Red");

        //创建面板
        buttonPanel=new JPanel();

        //按钮添加到面板中
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //将面板添加到框架中
        add(buttonPanel);

        //创建按钮事件
        ColorAction yellowAction=new ColorAction(Color.YELLOW);
        ColorAction blueAction=new ColorAction(Color.BLUE);
        ColorAction redAction=new ColorAction(Color.RED);

        //添加事件监听器
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    private class ColorAction implements ActionListener
    {
        private Color backgroundColor;

        public ColorAction(Color c)
        {
            backgroundColor=c;
        }

        //每当鼠标点击的时候就会自动调用这个方法
        public void actionPerformed(ActionEvent event)
        {
            //需要设置面板的背景属性，所以将这个类设为内部类
            buttonPanel.setBackground(backgroundColor);
        }
    }
}
