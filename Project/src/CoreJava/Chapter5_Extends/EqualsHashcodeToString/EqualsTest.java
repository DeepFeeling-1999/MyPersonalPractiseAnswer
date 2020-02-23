package CoreJava.Chapter5_Extends.EqualsHashcodeToString;

public class EqualsTest {
    public static void main(String []args){
        Employee test1=new Employee("Alice Adams",75000,1999,11,11);
        Employee test2=test1;
        Employee test3=new Employee("Alice Adams",75000,1999,11,11);
        Employee bob=new Employee("Bob",50000,1988,10,10);

        System.out.println("test1==test2: "+(test1==test2));
        System.out.println("test1==test3: "+(test1==test3));
        System.out.println("test1.equals(test2): "+(test1.equals(test2)));
        System.out.println("test1.equals(test3): "+(test1.equals(test3)));
        System.out.println("test1.equals(bob): "+(test1.equals(bob)));
        System.out.println("bob.toString "+bob);

        Manager boss1=new Manager("aaa",80000,1999,11,11);
        Manager boss2=new Manager("aaa",80000,1999,11,11);

        boss2.setBonus(5000);
        System.out.println("boss2.toString():"+boss2);
        System.out.println("boss1.equals(boss2):"+boss1.equals(boss2));

        System.out.println("test1.hashCode():"+test1.hashCode());
        System.out.println("test3.hashCode():"+test3.hashCode());

        System.out.println("boss1.hashCode():"+boss1.hashCode());
        System.out.println("boss2.hashCode():"+boss2.hashCode());
    }
}
