package ThinkingInJava.Practise180;

interface superInterface{
    void superFun();
}
interface temp2 extends superInterface{
    void tem2Fun();
}
interface temp3 extends superInterface{
    void temp3Fun();
}

interface subInterface extends temp2,temp3{
    void subFun();
}

class testInterface{

}
public class t13 {
}
