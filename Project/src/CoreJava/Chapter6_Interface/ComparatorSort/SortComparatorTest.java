package CoreJava.Chapter6_Interface.ComparatorSort;

import java.util.Arrays;
import java.util.Comparator;

public class SortComparatorTest {
    public static void main(String[] args) {
        String[] friends = {"aaa", "bb", "ccc"};        //数组

        Arrays.sort(friends, new LengthComparator());
        //使用一个比较器

        for (String temp : friends) {
            System.out.println(temp);
        }
    }
}

//comparator接口，在集合外定义一个专用的比较器
class LengthComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}
