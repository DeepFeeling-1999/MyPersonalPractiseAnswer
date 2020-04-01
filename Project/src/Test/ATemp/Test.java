package Test.ATemp;

import ThinkingInJava.Practise150_199.Practise159.t11;

public class Test
{
    private static int count=0;
    class Student{
        int count=0;

        public void fun(){
            this.count++;
            Test.count++;

        Test.this.count++;
        }
    }
    public static void main(String[] args)
    {
    }

}