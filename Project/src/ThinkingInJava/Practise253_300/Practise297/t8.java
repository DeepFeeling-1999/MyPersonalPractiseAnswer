package ThinkingInJava.Practise253_300.Practise297;

import java.util.Arrays;

public class t8
{
    public static String test="aaa66bbcb ccc ddd eee fff";

    public static void main(String[] args) {
       String []ar=test.split("[b]");
     // System.out.println(test.replaceAll("[aeiouAEIOU]","_"));
        for(String st:ar){
            System.out.println(st);
        }
    }
}
