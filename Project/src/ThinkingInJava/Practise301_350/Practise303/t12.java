package ThinkingInJava.Practise301_350.Practise303;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t12 {
    public static void main(String[] args) {
        String st = "AAA sada AAAsdada dadAAA 6asdad ";
        String myRegex = "(^[^A-Z]|\\s[^A-Z])\\w+";

        Pattern p = Pattern.compile(myRegex);
        Matcher m = p.matcher(st);

        Set<String> s = new TreeSet<>();
        while (m.find()) s.add(m.group());

        if (m.lookingAt()) {
            System.out.println("lookingAt " + m.start() + " end " + m.end());
        }
        if (m.matches()) {
            System.out.println("matcher " + m.start() + " end " + m.end());
        }

        System.out.println(s);
    }
}
