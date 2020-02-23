package CoreJava.Chapter11_Event.PlafFrame;

import javax.swing.*;
import java.awt.*;

public class PlafFrame extends JFrame
{
    //面板
    private JPanel buttonPanel;
    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=300;

    public PlafFrame()
    {
        buttonPanel=new JPanel();

        //获得每一种观感的名字
        UIManager.LookAndFeelInfo[] information=UIManager.getInstalledLookAndFeels();

        //获得类名
        for (UIManager.LookAndFeelInfo temp:information
             ) {
            //在这个自定义方法中把按钮添加到面板中
            makeButton(temp.getName(),temp.getClassName());
        }

        //将面板添加到框架中
        add(buttonPanel);
        pack();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH*3,DEFAULT_HEIGHT*3);
    }

    private void makeButton(String name ,String className)
    {
        //创建一个按钮
        JButton Jbutton=new JButton(name);

        //添加到面板
        buttonPanel.add(Jbutton);

        //用lambda表达式来简化操作
        //可以自动推导出类型为ActionEvent
        Jbutton.addActionListener((event)->{
            try
            {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        });
    }

}
