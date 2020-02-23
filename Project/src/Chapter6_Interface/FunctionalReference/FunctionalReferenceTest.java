package Chapter6_Interface.FunctionalReference;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * 函数式接口
 * 只有一个抽象方法的接口，可以提供一个lambda表达式。这种接口称为函数式接口
 */
public class FunctionalReferenceTest {
    public static void main(String[]args){
        Timer t=new Timer(1000,(ActionEvent event)->{
            System.out.println("The time is "+new Date());
        });

        t.start();      //启动计时器
        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示一个包含一条消息和OK的对话框，位于parent组件的中央，
        //若parent为null，则显示在屏幕中央

        System.exit(0);
    }
}
