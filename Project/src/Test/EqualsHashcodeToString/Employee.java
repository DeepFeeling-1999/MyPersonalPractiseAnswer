package Test.EqualsHashcodeToString;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int mouth, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, mouth, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject) {
        //如果引用同一个对象
        if (this == otherObject) {
            return true;
        }
        //如果为空
        if (otherObject == null) {
            return false;
        }
        //子类拥有自己相等的概念，则用getClass检测是否是同一个类
        if (getClass() != otherObject.getClass()) {
            //如果由父类决定是否是同一个类的概念则用
            return false;
        }
        // instanceof 来检测两个参数是否可以转换

        //现在可以确定实参是一个非空同类对象
        Employee other = (Employee) otherObject;

        //测试域，考虑到name和hireDay可能为空
        // 调用的是Objects.equals
        return Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    @Override
    public int hashCode() {
        //Objects中的方法
        return Objects.hash(hireDay + name + salary);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name +
                ", salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}


