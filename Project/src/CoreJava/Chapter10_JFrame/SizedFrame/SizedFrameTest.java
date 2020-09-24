package CoreJava.Chapter10_JFrame.SizedFrame;

import javax.swing.*;
import java.awt.*;

public class SizedFrameTest {
    public static void main(String[] args) {
        //暂时看作启动一个swing程序的代码
        EventQueue.invokeLater(() -> {
            JFrame frame = new SizedFrame();

            //设置Title属性
            frame.setTitle("sizedFrame");

            //定义一个用户关闭这个框架时的响应动作，此处是默认操作
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //起初是不可见的，可以在显示之前添加组件
            frame.setVisible(true);

            /*
               初始化语句结束后，main退出，main退出并没有终止程序
               终止的只是主线程，而“事件分派线程”处于激活状态，
               直到关闭框架或用System.exit方法终止
             */
        });
    }
}

class SizedFrame extends JFrame {
    public SizedFrame() {

        //调用Toolkit类的静态方法getDefaultToolkit获得一个Toolkit对象
        //Toolkit类包含很多与本地系统打交道的方法
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screen = kit.getScreenSize();

        int screenHeight = screen.height;
        int screenWidth = screen.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        //使用工具箱加载图片
        Image im = new ImageIcon("src\\ideaResources\\JFrameTest.gif").getImage();

        //设置框架的图标属性  icon 图标
        setIconImage(im);
    }
}