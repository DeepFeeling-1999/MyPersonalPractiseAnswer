package Test.String;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/22
 */
public class Test {
    public static void main(String[] args) {
        String a = "helloword";
        final String b = "hello";
        String d = "hello";
        String c = b + "word";
        String e = d + "word";
        String f = "hello" + "word";
        String g = new String("helloword");
        String h = new String("helloword");


        System.out.println(a == c);
        //常量，直接编译时优化为 String c="hello"+"word";

        System.out.println(a == e);
        //编译时不能优化，所以不同

        System.out.println(a == f);
        //等价于a==c

        System.out.println(g == h);
        //堆上，两个不同对象
        System.out.println("**********************");

        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        //因为在jdk7之后，常量池移动到堆中，而且此处是第一次遇到这个字符串
        //所以在此处只需要在常量池里记录一下首次出现的实例引用就行了
        //然后返回这个引用，所以是同一个

        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
        //此处因为“java”不是第一次出现，所以返回的是之前就已经保存在堆里的字符串常量池里的对象引用



        System.out.println("**********************");
        //String t="aaa";
        String a1 = new StringBuilder("a").append("aa").toString();

        //此时常量池里只有一个“aaaaaa”,没有“aaa”
        String b1 = "aaa" + "aaa";

        //所以对a1对象调用intern时，是第一次见到，又因为jdk7的常量池在堆，
        // 所以直接把a1的引用丢到堆上的常量池里，所以返回的就是a1
        String c1 = a1.intern();

        if (a1 == c1) {
            System.out.println("=");
        }

    }
}
