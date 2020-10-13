package A.p5;

abstract class AEmployee {
    private String fistName;
    private String lastName;

    public AEmployee(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "AEmployee{" + "fistName='" + fistName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    abstract double earnings();
}

final class CBoss extends AEmployee {
    double weeklySalary;

    public CBoss(String fistName, String lastName, double weeklySalary) {
        super(fistName, lastName);
        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "CBoss{" + "weeklySalary=" + weeklySalary + '}';
    }
}

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class t5 {
    public static void main(String[] args) {
        AEmployee aEmployee = new CBoss("aaa", "aaa", 666);
        System.out.println("boss信息 " + aEmployee);
        System.out.println("boss每周薪水 " + aEmployee.earnings());
    }
}
