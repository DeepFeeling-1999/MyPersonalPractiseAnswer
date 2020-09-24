package Test.Initialization;

class temp1 {
    private int temp1_num1;
    private int temp1_num2 = 2;

    temp1() {
        System.out.println("temp1 initialization");
    }

    {
        System.out.println("Initialization block of temp1");
    }

    static {
        System.out.println("static initialization block of temp1");
    }

    private int temp1_num3 = 3;
    private static int temp1_num4 = 4;
}

class temp2 extends temp1 {
    private int temp2_num1;
    private final int temp2_num2 = 2;

    temp2() {
        System.out.println("temp2 initialization");
    }

    {
        System.out.println("Initialization block of temp2");
    }

    private static int temp2_num4 = 4;

    static {
        System.out.println("static initialization block of temp2");
    }

    private int temp2_num3 = 3;

}

public class Initialization extends temp2 {
    private int main_num1;
    private int main_num2 = 2;

    Initialization() {
        System.out.println("temp2 initialization");
    }

    public static void main(String[] args) {
        new Initialization();
    }

    {
        System.out.println("Initialization block of main");
    }

    static {
        System.out.println("static initialization block of main");
    }

    private int main_num3 = 3;
    private static int main_num4 = 4;

}
