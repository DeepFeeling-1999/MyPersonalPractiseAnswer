package CoreJava.Chapter5_Extends.Abstract_Person;

public class PersonTest {
    public static void main(String[] args) {
        PersonAbstract[] people = new PersonAbstract[2];

        people[0] = new EmployeeSubclass("A", 50000, 111, 1, 1);
        people[1] = new StudentSubclass("bbb", "Computer science");

        //抽象类引用，可以引用非抽象子类对象
        for (PersonAbstract temp : people) {
            System.out.println(temp.getName() + ", " + temp.getDescription());
        }
    }
}
