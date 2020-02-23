package CoreJava.Chapter10_JFrame.MyImage;

import javax.swing.*;
import java.awt.*;

public class ImageTest {
    public static void main(String[]args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new MyImageTest();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MyImageTest extends JFrame {
    public MyImageTest()
    {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent
{
    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=300;

    private Image im;

    public ImageComponent()
    {
        im=new ImageIcon("src//ideaResources\\JFrameTest.gif").getImage();
    }

    @Override
    public void paintComponent(Graphics gra)
    {
        int copyWidth=im.getWidth(this);
        int copyHeight=im.getHeight(this);

        /**
         * 绘制一幅非比例图像，这个调用可能会在图像还没有绘制完毕就返回
         * @param x 左x上角坐标
         * @param y 左y上角坐标
         * @param observer 绘制进程中以通告为目的的对象，可能为null
         */
        gra.drawImage(im,0,0,null);

        for (int i = 0; i*copyWidth <= getWidth() ; i++)
        {
            for(int j=0;j*copyHeight<=getHeight();j++)
                if(i+j>0)
                    gra.copyArea(0,0,copyWidth,copyHeight,i*copyWidth,j*copyHeight);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}