package CoreJava.Chapter7_Exception.FileFormatException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileFormatExceptionTest {
    public static void main(String[] args) throws resourcesTest {
        int i = 0;

        /**
         * 带资源的try，退出时会自动调用   close()方法
         * 即可防止try抛出一个异常，而close方法也抛出一个异常
         * 此时会抑制close抛出的异常。
         * 若对这些异常感兴趣，可以调用addSuppressed方法增加到原来的异常，
         * 然后用getSuppressed方法得到从close方法抛出并被抑制的异常列表
         */
        try (Scanner temp_in = new Scanner((new FileInputStream("src\\ideaResources//t3.txt")),
                                           String.valueOf(StandardCharsets.UTF_8)
        ); PrintWriter temp_out = new PrintWriter("src/ideaResources\\out_test.txt")) {
            if (i == 1) {
                throw new resourcesTest("A");
            }
            while (temp_in.hasNext()) temp_out.println(temp_in.next());
        } catch (FileNotFoundException e) {
            System.out.println("File not found !");
            System.exit(666);
        } catch (resourcesTest e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("finally");
        }
    }
}

class resourcesTest extends IOException {
    public resourcesTest() {}

    public resourcesTest(String gripe) {
        super(gripe);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}