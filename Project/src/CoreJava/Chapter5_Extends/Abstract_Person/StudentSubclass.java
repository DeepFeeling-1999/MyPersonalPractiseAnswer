package CoreJava.Chapter5_Extends.Abstract_Person;

public class StudentSubclass extends PersonAbstract {
    private String major;

    public StudentSubclass(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoing in " + major;
    }
}
