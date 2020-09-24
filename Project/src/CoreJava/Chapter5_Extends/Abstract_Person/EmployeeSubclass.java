package CoreJava.Chapter5_Extends.Abstract_Person;

import java.time.LocalDate;

/**
 * @author dell
 */
public class EmployeeSubclass extends PersonAbstract {
    private double salary;
    private LocalDate hireDay;

    public EmployeeSubclass(String name, double salary, int year, int mounth, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, mounth, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("am employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
