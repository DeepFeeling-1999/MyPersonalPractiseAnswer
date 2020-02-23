package CoreJava.Chapter6_Interface.InnerClass.CreatInnerClass;

/**
 * 创建内部类对象
 * 通过外部类对象来创建
 * 或者通过外部类对象的方法来创建
 */
public class CreatInnerClassTest
{
    public static void main(String[]args)
    {
        //第一种方式：
        Outer outer = new Outer();

        //必须通过Outer对象来创建
        Outer.Inner inner = outer.new Inner();

        //第二种方式，通过outer中函数来创建
        Outer.Inner inner1 = outer.getInnerInstance();
    }
}
class Outer
{
    private Inner inner = null;
    public Outer()
    {

    }

    public Inner getInnerInstance()
    {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    class Inner
    {
        public Inner()
        {

        }
    }
}
