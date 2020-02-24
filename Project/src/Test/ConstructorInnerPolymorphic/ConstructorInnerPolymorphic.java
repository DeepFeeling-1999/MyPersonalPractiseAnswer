package Test.ConstructorInnerPolymorphic;

class superClass{
    int superNum=1;
    void draw(){
        System.out.println("super class draw + superNum = "+superNum);
    }
    public superClass(){
        System.out.println("Super class constructor + superNum = "+superNum);
        draw();
    }
}
class subClass extends superClass{
    int subNum=2;
    void draw(){
        System.out.println("Subclass draw+ subNum = "+subNum);
    }
    public subClass(){
        System.out.println("Superclass constructor + subNum = "+subNum);
        draw();
    }
}
public class ConstructorInnerPolymorphic {
    public static void main(String[]args){
        new subClass();
    }
}
