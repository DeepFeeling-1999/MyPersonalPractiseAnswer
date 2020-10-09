package A.p2;

class CBox {
    private int length = -1;
    private int width = -1;
    private int height = -1;

    public int volume(int l, int w, int h) {
        return l * w * h;
    }

    public int surfaceArea(int l, int w, int h) {
        return l * w * 2 + l * h * 2 + w * h * 2;
    }
}

class CBall {
    private double Pi = 3.14;
    private double radius = -1;

    public double get_surfaceArea() {
        return 4 * Pi * radius * radius;
    }

    public double get_volume() {
        return 4 / 3 * Pi * radius * radius;
    }

    public void setRadius(double r){
        radius=r;
    }
}

public class t2 {
    public static void main(String[]args){
        CBall cBall=new CBall();
        cBall.setRadius(6.66);

        System.out.println("球的表面积是 "+cBall.get_surfaceArea());
        System.out.println("球的体积是 "+cBall.get_volume());

    }
}
