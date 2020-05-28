package Test.ConstructorInnerPolymorphic;

/**
 * 简述：
 * 构造器内部也有多态性，因此可能调用了未初始化的对象
 */
class superClass {
    int superNum = 1;

    void draw() {
        System.out.println("super class draw + superNum = " + superNum);
    }

    public superClass() {
        System.out.println("Super class constructor + superNum = " + superNum);
        draw(); //在构造子类时，超类中动态绑定了子类方法，而此时子类尚未初始化
    }
}

class subClass extends superClass {
    int subNum = 2;

    void draw() {
        System.out.println("Subclass draw+ subNum = " + subNum);
    }

    public subClass() {
        System.out.println("Superclass constructor + subNum = " + subNum);
        draw();
    }
}

public class ConstructorInnerPolymorphic {
    public static void main(String[] args) {
        new subClass();
    }
}
