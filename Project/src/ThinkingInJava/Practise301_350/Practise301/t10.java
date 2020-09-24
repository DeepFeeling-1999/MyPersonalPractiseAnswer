package ThinkingInJava.Practise301_350.Practise301;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t10 {
    /*public static void main(String[]args){
        String st=args[0];

        for(String MyRegex:args){
            System.out.println("*****************************");
            Pattern p=Pattern.compile(MyRegex);
            Matcher m=p.matcher(st);

            System.out.println(st);
            System.out.println("Regex : "+MyRegex);
            while(m.find()){
                System.out.println("result : "+m.group());
            }
            System.out.println("*****************************");
        }

    }*/


    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
        for (String arg : args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            if (!m.find()) {
                System.out.println("No match found for " + "\"" + arg + "\"");
            }
            m.reset();
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at position " + m.start() + ((m.end() - m.start() < 2) ? "" : ("-" + (m.end() - 1))));
            }
        }
    }
}
