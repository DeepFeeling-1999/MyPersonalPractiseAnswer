package CoreJava.Chapter9_Collection.Shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args)
    {
        List<Integer> numbers=new ArrayList<>();

        for(int i=1;i<=9;i++)
            numbers.add(i);

        //随机的打乱列表中的元素
        Collections.shuffle(numbers);

        //返回给定位置范围内的元素列表视图
        List<Integer> result=numbers.subList(0,6);
        Collections.sort(result);

        System.out.println(result);

    }
}

