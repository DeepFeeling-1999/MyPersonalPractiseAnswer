package Chapter10_JFrame.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTest
{
    public static void main(String[]args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new TestFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class TestFrame extends JFrame
{
    public TestFrame()
    {
        add(new FontComponent());
        pack();
    }
}
class FontComponent extends JComponent
{
    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=200;

    @Override
    public void paintComponent(Graphics gra)
    {
        Graphics2D graphics2d=(Graphics2D) gra;

        String message="Hello world!";

        //创建一个新字体对象
        Font font=new Font("Serif",Font.BOLD,36);

        //设置当前字体
        graphics2d.setFont(font);

        //调用Graphics2D类中的getRenderContext方法获得FontRenderContext类对象
        FontRenderContext fontRenderContext=graphics2d.getFontRenderContext();

        //getStringBounds将返回包围字符串的矩形
        Rectangle2D bounds=font.getStringBounds(message,fontRenderContext);

        //用getWidth()获得组件宽度，用bounds.getWidth()获得字符串的宽度
        double x=(getWidth()-bounds.getWidth())/2;
        double y=(getHeight()-bounds.getHeight())/2;

        //计算基线
        double ascent=-bounds.getY();
        double baseY=y+ascent;

        //绘制消息
        graphics2d.drawString(message,(int)x,(int)baseY);
        graphics2d.setPaint(Color.LIGHT_GRAY);

        //绘制基线
        graphics2d.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));

        //绘制封闭矩形
        graphics2d.draw(new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight()));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}

