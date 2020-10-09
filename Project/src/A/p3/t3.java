package A.p3;

class CPoint {
    private int x;
    private int y;

    public CPoint() {
        x = y = -1;
    }

    public CPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPoint(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "CPoint{" + "x=" + x + ", y=" + y + '}';
    }
}
class CCirle extends CPoint{
    private double radius;

    public CCirle() {
        this.radius = -1;
    }

    public CCirle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void setPoint(int a, int b) {
        super.setPoint(a, b);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
public class t3 {}
