package CoreJava.Chapter6_Interface.ComparableSort;
import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);             //要求实现了Comparable接口

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}

/**
 * 关键字implement表示实现某个接口
 */
class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }

    public String getName() {
        return name; }
    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     *  Comparable接口的compareTo方法 ，是在集合内部定义的方法实现的排序，
     *  实现接口时，必须把接口声明为public
     */
    public int compareTo(Employee other) {
        return Double.compare(salary,other.salary);
    }
}
