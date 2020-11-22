package ThinkingInJava.p11_Collection.Practise225;

import java.util.*;

public class t5 {
    public static List<Integer> ListOfRandInteger(int length, int n) {
        Random rand = new Random(47);
        List<Integer> li = new ArrayList<Integer>();

        for (int i = 0; i < length; i++)
            li.add(rand.nextInt(n));
        return li;
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> li = ListOfRandInteger(7, 10);

        System.out.println("1:" + li);
        Integer temp = 666;
        li.add(temp);    //自动装箱
        System.out.println("2:" + li);

        //判断是否包含
        System.out.println("3: contains " + li.contains(temp));
        li.remove(temp);
        System.out.println("4: remove " + li);

        temp = li.get(1);
        System.out.println("5: get(1) " + temp + " indexOf " + li.indexOf(temp));

        System.out.println("");
        //抽取子集,可以理解为的是原本的引用
        List<Integer> sub = li.subList(1, 5);
        System.out.println("6: subList " + sub);

        //判断是否包含此子集
        System.out.println("7: containsAll " + li.containsAll(sub));

        //对sub进行shuffle会更改原本
        Collections.shuffle(sub, rand);
        System.out.println("8.1: Collections shuffle " + sub);
        System.out.println("8.2: Collections shuffle " + li);

        System.out.println("");
        List<Integer> copy = new ArrayList<Integer>(li);
        System.out.println("9.0: copy " + copy);

        //用asList抽取子集，是单个单个抽取，而不是subLIst的区间抽取
        sub = Arrays.asList(li.get(0), li.get(5));
        System.out.println("9.1: subList " + sub);

        //retainsAll 是取交集操作
        System.out.println("9.2: retainsAll " + copy.retainAll(sub));
        System.out.println("9.3: copy retainsAll " + copy);

        copy = new ArrayList<Integer>(li);
        System.out.println("10.0: copy " + copy);
        //移除下标为2
        copy.remove(2);
        System.out.println("10.1: remove(2) " + copy);
        System.out.println("10.2: subList " + sub);

        //会移除子序列中的所有值，包括重复
        copy.removeAll(sub);
        System.out.println("10.3: removeAll(sub) " + copy);

        System.out.println("");
        copy.addAll(1, sub);
        System.out.println("11: addAll(sub) " + copy);

        System.out.println("");
        System.out.println("12.0: isEmpty() " + li.isEmpty());
        //清空
        copy = new ArrayList<Integer>(li);
        li.clear();
        System.out.println("12.0: clear()后  isEmpty() " + li.isEmpty());

        System.out.println("13.0: copy " + copy);
        Object[] o = copy.toArray();
        System.out.println("13.1: copy.toArray() o[1]= " + o[1]);

    }
}
