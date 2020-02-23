package CoreJava.Z_Personal.C_5.Abstract;

public class AbstractTest {
    public static void main(String[]args)
    {
        son test1=new son();
        abstractT test2=new son();

        System.out.println(test1.getName());
        System.out.println(test2.getName());
    }
}
abstract class abstractT
{
    private String name;

    public abstract String getName();
}

class son extends abstractT
{
    public String getName()
    {
        return "aaa";
    }
}
