package Test.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author dell
 */
public class FilePathTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner temp_in = new Scanner((new FileInputStream("src\\ideaResources//t3.txt")),
                                      String.valueOf(StandardCharsets.UTF_8)
        );

        //  用  \\  -----  //   ------  /  都行
        PrintWriter temp_out = new PrintWriter("src/ideaResources\\out_test.txt");

        while (temp_in.hasNext()) {
            temp_out.println(temp_in.next());
        }

        temp_in.close();
        temp_out.close();
    }
}