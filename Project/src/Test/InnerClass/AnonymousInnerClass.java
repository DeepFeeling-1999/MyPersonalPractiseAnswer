package Test.InnerClass;

interface InnerInterface{
    void fun();
}
//匿名内部类实现接口
class test1{
    public  InnerInterface AnonymousInnerClass(){
        return new  InnerInterface() {
            //此处的匿名内部类实现了InnerInterface接口
            @Override
            public void fun() {
                System.out.println("Anonymous Inner Class");
            }
        };
    }
}

//匿名内部类继承
class temp2{
    String st;
    public temp2(){
        this.st="temp2";
    }
    public void Fun() {
        System.out.println("temp2 Class");
    }
}
class temp22{
    public temp2 temp2Fun(){
        //此处匿名内部类继承了temp2类，并覆盖了Fun()方法
        return new temp2(){
            @Override
            public void Fun() {
                System.out.println("temp2Fun anonymous Class");
            }
        };
    }
}

public class AnonymousInnerClass{
    public static void main(String[]args){
        (new test1()).AnonymousInnerClass().fun();

        new temp22().temp2Fun().Fun();
    }
}