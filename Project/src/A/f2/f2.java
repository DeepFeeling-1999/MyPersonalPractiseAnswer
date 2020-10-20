package A.f2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 学生类
 */
class student implements Serializable {
    private int id;
    private int number;
    private String name;
    private int grade1 = -1;
    private int grade2 = -1;
    private int grade3 = -1;
    private int grade4 = -1;
    private int grade5 = -1;

    private int amount = -1;

    public student(int id, int number, String name, int grade1, int grade2, int grade3, int grade4, int grade5) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.grade4 = grade4;
        this.grade5 = grade5;

        this.amount = grade1 + grade2 + grade3 + grade4 + grade5;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", number=" + number + ", name='" + name + '\'' + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5 + ", amount=" + amount + '}';
    }

    public int getAmount() {
        return amount;
    }
}

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/19
 */
public class f2 {
    private static student[] array = new student[100];
    private static final Random random = new Random();
    private FileOutputStream outputStream = new FileOutputStream("src\\ideaResources\\score.txt");
    private ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

    public f2() throws IOException {}

    /**
     * 生成100个学生并写入score.txt
     */
    public void fun1() throws IOException {
        //生成100个学生
        for (int i = 0; i < 100; i++) {
            //只设一门成绩是随机值，都一样的，五门的话太长了，碍眼
            array[i] = new student(i, i, "名字" + i, random.nextInt(100), i, i, i, i);
            System.out.println(array[i]);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(array[i]);
        }

        //Arrays.sort(array, Comparator.comparingInt(student::getAmount));
        //for (int i = 0; i < 10; i++) {
        //    System.out.println(array[i]);
        //}
    }

    public static void main(String[] args) throws IOException {

        new f2().fun1();
    }
}
