package ThinkingInJava.Practise201_250.Practise233;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class t16
{
    static void test(String[]st)
    {
        Set<Character> se = new HashSet<>();
        Collections.addAll(se, 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

        int amount = 0;
        for (String s : st)
        {
            for (Character c : s.toCharArray())
            {
                if (se.contains(c))
                    amount++;
            }
        }
        System.out.println("Amount = "+amount);
    }
        public static void main(String[]args){
            String[]st={"aAAkkk","eeelll"};
            test(st);
        }

}
