package A.p4;


/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class exam02 {
    private abstract static class CCircle {
        private  static double pi = 3.14;
        private static double radius=2;

        abstract public  void show();
    }
    public static void main(String args[]) {
        CCircle cir1, cir2;
        cir1 = new CCircle() {
            @Override
            public void show() {
                System.out.println("area=" + CCircle.pi * CCircle.radius * CCircle.radius );
            }
        };
        cir1.show();
        cir2 = cir1;
        cir2.show();
    }
}

