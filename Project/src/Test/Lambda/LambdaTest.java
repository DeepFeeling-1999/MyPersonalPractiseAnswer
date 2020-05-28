package Test.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {

       /* String []datas = new String[] {"peng","zhao","li"};
        //Comparator<String> comp = (v1, v2) -> Integer.compare(v1.length(), v2.length());
        Arrays.sort(datas, Comparator.comparingInt(String::length));
        Stream.of(datas).forEach(System.out::println);*/


        // 你可以用一个lambda表达式为一个函数接口赋值：
        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
        //然后再赋值给一个Object：
        Object obj = r1;

        //但却不能这样干：
        // Object obj = () -> {System.out.println("Hello Lambda!");};
        // ERROR! Object is not a functional interface!

        //必须显式的转型成一个函数接口才可以：
        Object o = (Runnable) () -> { System.out.println("hi"); }; // correct

        //一个lambda表达式只有在转型成一个函数接口后才能被当做Object使用。所以下面这句也不能编译：
        //System.out.println( () -> {} ); //错误! 目标类型不明
        //必须先转型：

        System.out.println((Runnable) () -> {}); // 正确
    }
}
