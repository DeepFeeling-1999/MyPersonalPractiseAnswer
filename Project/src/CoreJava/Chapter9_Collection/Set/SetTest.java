package CoreJava.Chapter9_Collection.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Set是没有重复元素的元素集合
 *
 * set有“集”的意思
 * set的add方法会先在集中查找要添加的对象，如果不存在再添加
 */
public class SetTest {
    public static void main(String[] args)
    {
        // Hash实现了Set接口
        Set<String>words=new HashSet<>();
        long totalTime=0;

        try(Scanner temp_in=new Scanner(System.in))
        {
            //用ctrl+d 结束，原因不明，暂时猜测和Java中stream设计有关，后面再学
            while(temp_in.hasNext())
            {
                String word =temp_in.next();
                long callTime =System.currentTimeMillis();      //TimeMills  时间毫秒
                words.add(word);

                callTime=System.currentTimeMillis()-callTime;
                totalTime+=callTime;
            }
        }

        //返回一个用于访问集合中每个元素的迭代器
        Iterator<String>iter=words.iterator();

        for(int i=1;i<20&&iter.hasNext();i++)
            System.out.println(iter.next());

        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}

