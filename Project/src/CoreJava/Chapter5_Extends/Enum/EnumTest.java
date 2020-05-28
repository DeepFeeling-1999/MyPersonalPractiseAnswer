package CoreJava.Chapter5_Extends.Enum;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner inTemp = new Scanner(System.in);

        System.out.print("SMALL MEDIUM LARGE EXTRA_LARGE");
        String input = inTemp.next().toUpperCase();
    }

    enum Size {


        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        private String abbreviation;
    }
}
