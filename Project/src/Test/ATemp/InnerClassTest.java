package Test.ATemp;

import java.util.Scanner;

class temp1{
    int num1;
    int num2;
}
public class InnerClassTest {
    public static void main(String[] args) {
        int i=1,j=0; //j换行符个数
        StringBuilder builder = new StringBuilder(); //可变长度字符串

        //汉字的Unicode码的范围：\u4e00~\u9fa5
        for(char c='\u4e00';c<='\u9fa5';c++){
            builder.append(c);

            if(i%30==0){
                builder.append("\n");
                j++;
            }

            i++;
        }

        System.out.println(builder.length()-j); //汉字数
        System.out.println(builder.toString());
    }
}