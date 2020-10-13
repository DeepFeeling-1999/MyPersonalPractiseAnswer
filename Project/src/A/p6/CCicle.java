package A.p6;

/**
 * 半径大于100
 */
class RadiusToolLarge extends Exception {
    private String message;

    public RadiusToolLarge(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RadiusToolLarge{" + "message='" + message + '\'' + '}';
    }
}

/**
 * 半径小于0
 */
class RadiusIsNegative extends Exception {
    private String message;

    public RadiusIsNegative(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RadiusIsNegative{" + "message='" + message + '\'' + '}';
    }
}

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class CCicle {
    private int radius;

    public CCicle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double area() {
        return 4 * 3.14 * radius;
    }

    public static void main(String[] args) throws RadiusToolLarge {
        int radius = -9;
        try {
            CCicle cCicle = new CCicle(radius);
            if (radius > 100) {
                throw new RadiusToolLarge("半径为 " + radius);
            } else if (radius < 0) {
                throw new RadiusIsNegative("半径为 " + radius);
            }
        } catch (RadiusToolLarge | RadiusIsNegative radiusToolLarge) {
            System.out.println("抛出异常 ，异常信息如下 ：\n" + radiusToolLarge.toString());
        }
    }
}
