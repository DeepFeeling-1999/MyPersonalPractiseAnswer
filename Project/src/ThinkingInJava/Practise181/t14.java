package ThinkingInJava.Practise181;

interface temp1{
    void temp1Fun();
}
interface temp2 {
    void temp2Fun();
}
interface temp3 {
    void temp3Fun();
}
interface subInterface extends temp1,temp2,temp3{
    void subFun();
}

class superClass{
    public void superFun(){
        System.out.println("superFun");
    }
}
class testInterface extends superClass implements subInterface {
    public void temp1Fun(){
        System.out.println("testInterface temp1Fun");
    }
    public void temp2Fun(){
        System.out.println("testInterface temp2Fun");
    }
    public void temp3Fun(){
        System.out.println("testInterface temp3Fun");
    }
    public void subFun(){
        System.out.println("testInterface subFun");
    }
}
public class t14 {
    public static void mainFun1(temp1 t1){
        t1.temp1Fun();
    }
    public static void mainFun2(temp2 t2){
        t2.temp2Fun();
    }
    public static void mainFun3(temp3 t3){
        t3.temp3Fun();
    }
    public static void mainSubInterfaceFun(subInterface s1){
        s1.subFun();
        s1.temp1Fun();
    }

    public static void main(String []args){
        mainFun1(new testInterface());
        mainFun2(new testInterface());
        mainFun3(new testInterface());
        mainSubInterfaceFun(new testInterface());
    }
}
