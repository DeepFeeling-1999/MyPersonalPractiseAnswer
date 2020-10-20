package A;


class Super{

}
class Sub extends Super{

}
/**
 * @author Deep-Feeling-1999
 * @create 2020/10/16
 */
public class aaa {
    public static void main(String[] args) {
        Super s=new Super();
        Super sub=new Sub();
        System.out.println(s.getClass()==sub.getClass().getSuperclass());
        System.out.println(sub.getClass());

    }
}
