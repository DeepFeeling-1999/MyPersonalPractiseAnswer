package ThinkingInJava.Practise213;

class Egg2
{
    protected class yolk
    {
        public yolk()
        {
            System.out.println("Egg2.yolk");
        }

        public void f()
        {
            System.out.println("Egg2.yolk.f()");
        }
    }

    private yolk y = new yolk();

    public Egg2()
    {
        System.out.println("new Egg2()");
    }

    public void insertYolk(yolk yy)
    {
        y = yy;
    }

    public void g()
    {
        y.f();
    }
}

public class BigEgg2 extends Egg2
{
    public class yolk extends Egg2.yolk
    {
        public yolk()
        {
            System.out.println("BigEgg2.yolk()");
        }

        public void f()
        {
            System.out.println("BigEgg2 yolk.f()");
        }
    }

    public BigEgg2()
    {
        insertYolk(new yolk());
    }

    public static void main(String[] args)
    {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }

}
