package CoreJava.Chapter5_Extends.Extends_Employee;

public class ExtendsTest {
    public static void main(String[] args){
        Manager boss=new Manager
                ("aaa", 33333,1999,12,24);
        boss.setBonus(5000);
        System.out.println(boss.getName());
        Employee[] staff=new Employee[3];

        staff[0]=boss;
        staff[1]=new Employee("bbb",111,11,1,1);
        staff[2]=new Employee("ccc",222,22,2,2);

        for (Employee temp:
             staff) {
            System.out.println("name = "+temp.getName()+",salary"+temp.getSalary());
            //System.out.println(temp.toString());

        }

    }
}
