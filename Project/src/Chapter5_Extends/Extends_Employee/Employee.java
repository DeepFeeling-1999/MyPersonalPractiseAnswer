package Chapter5_Extends.Extends_Employee;

import java.time.*;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(){
        this.name="aaa";
        this.hireDay=LocalDate.of(111,1,1);
        this.salary=333;
    }
    public Employee(String name,double salary,int year,int mouth,int day){
        this.name=name;
        this.salary=salary;
        hireDay=LocalDate.of(year,mouth,day);
    }

    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public LocalDate getHireDay(){
       return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }

    public static void main(String[]args){
        Employee test=new Employee("aaaaaa",111,111,12,3);
        System.out.println(test.getName());
    }
}


