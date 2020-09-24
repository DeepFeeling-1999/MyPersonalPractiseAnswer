package Test.Clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Cloneable接口属于标记接口，里面没有定义clone方法
 * 这个方法是从Object继承的
 * 如果对象请求一个克隆，而没有实现这个接口，就会生成一个受查异常
 */
public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }


    /**
     * 如果对象没有实现Cloneable接口则会抛出CloneNotSupportedException异常
     */
    @Override
    public Employee clone() throws CloneNotSupportedException {
        // 调用 Object.clone()
        Employee cloned = (Employee) super.clone();

        //建立深克隆，克隆对象中可变域
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        //实例域转变示例
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
