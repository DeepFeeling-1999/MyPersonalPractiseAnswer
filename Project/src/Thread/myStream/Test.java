package Thread.myStream;


import SomeInstance.User;

import java.util.Arrays;
import java.util.List;

/**
 * 集合讲的是数据，流讲的是计算
 * Stream不会存储元素，不改变源对象，生成一个新的stream
 * 而且是延迟执行，等到需要结果的时候才执行
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(11, 11, "A");
        User u2 = new User(22, 22, "B");
        User u3 = new User(33, 33, "C");
        User u4 = new User(44, 44, "D");
        User u5 = new User(55, 55, "E");

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream()
                .filter(u -> u.getId() % 2 == 0)
                .filter(u -> {return u.getAge() > 24;})
                .map(m->{return m.getName().toUpperCase();})
                .sorted((t1,t2)->{return t2.compareTo(t1);})
                .limit(1)
                .forEach(System.out::println);

    }
}
