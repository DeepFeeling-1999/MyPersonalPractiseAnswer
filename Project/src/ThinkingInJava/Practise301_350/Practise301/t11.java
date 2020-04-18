package ThinkingInJava.Practise301_350.Practise301;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t11
{
    public static void main(String[]args){
        String myRegex="(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        //(?i)允许模式匹配不考虑大小写  以aeiou中的一个字母开头或者
        // 一个或多个空格开头加aeiou其中一个字母  加多个词字符再以aeiou结尾的词

        //   简单说就是以元音字母开头，或者空白加元音开头，并以元音结尾的单词
        //   \\b是词边界
        String st="Arline ate eight apples and one orange while Anita hadn't any";

        Pattern p=Pattern.compile(myRegex);
        Matcher m=p.matcher(st);

        while(m.find()){
            System.out.println(m.group());
        }

    }
}
