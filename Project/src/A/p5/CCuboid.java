package A.p5;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class CCuboid extends Object implements IShape {
    private int x;
    private int y;
    private int z;

    public CCuboid(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "CCuboid{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public int surfaceArea() {
        return x * y * 2 + x * z * 2 + y * z * 2;
    }

    @Override
    public int volume() {
        return x * y * z;
    }

    @Override
    public String getName() {
        return "长方体";
    }

    public static void main(String[] args) {
        IShape iShape=new CCuboid(4,5,6);

        System.out.println("长方体信息 "+iShape);
        System.out.println("长方体体积 "+iShape.volume());
        System.out.println("长方体表面积 "+iShape.surfaceArea());
    }

}
