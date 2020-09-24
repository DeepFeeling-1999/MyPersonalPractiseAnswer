package CoreJava.Chapter6_Interface.Clone;

public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 1111);
            original.setHireDay(1111, 11, 1);

            Employee copy = original.clone();
            copy.raiseSalary(100);
            copy.setHireDay(2222, 2, 22);

            System.out.println("original= " + original);
            System.out.println("copy= " + copy);
        }

        //捕获异常
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
