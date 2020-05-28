package CoreJava.Chapter5_Extends.EqualsHashcodeToString;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int mouth, int day) {
        super(name, salary, year, mouth, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject))      //调用超类equals函数
        {
            return false;
        }

        Manager other = (Manager) otherObject; //比较过超类equals，即实参为manager类型
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    public String toString() {
        final String s = super.toString() + ("[bonus=" + bonus + "]");
        return s;
    }
}
