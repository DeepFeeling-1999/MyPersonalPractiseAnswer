package Test.OverrideOverload;

import java.util.ArrayList;
import java.util.List;

class F{
    protected Number fun(int l){
        System.out.println("F   String fun(int a)");
        return 6;
    }

}

class S extends F{
    @Override
    public Integer fun(int l){
        return 6;
    }


}



/**
 * @author Deep-Feeling-1999
 * @create 2021/2/19
 */
public class Test {
    public static void main(String[]args){

    }

}
