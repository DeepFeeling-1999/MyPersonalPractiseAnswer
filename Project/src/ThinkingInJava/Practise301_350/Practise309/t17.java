package ThinkingInJava.Practise301_350.Practise309;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t17 {
    public static void main(String[] args) {
        String st = "//aaaa /* asdasda*/ \nccccccccccc cccccccc  //sadasdad \n/*asdasd\nadadadada\nadsad*/\n";
        String myRegex = "(//.+)|(/\\*.+)|(.+\\*/)";
        //"(//\\s.+)|(/\\*\\s+.+)|(\\*\\s+.+)"

        Pattern p = Pattern.compile(myRegex);
        Matcher m = p.matcher(st);

        while (m.find()) System.out.println(m.group());
    }
}
