package A.f1;

import java.util.*;

/**
 * 学生类
 */
class student {
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

public class f1 {
    public static void fun1() {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i <= 9; i++) {
            array[i] = random.nextInt(10);
        }
        System.out.println("这十个随机数是 " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("排序后是 " + Arrays.toString(array));
    }

    /**
     * 生成不重复随机数
     * @return 返回这十个数的数组
     */
    public static int[] fun2() {
        Random random = new Random();
        int[] array = new int[10], tempArray = new int[10];
        HashSet<Integer> mySet = new HashSet<>();

        for (int i = 0; i <= 9; i++) {
            int temp = random.nextInt(10);
            //利用HashSet性质，不重复的数才能加进去
            while (!mySet.add(temp)) {
                temp = random.nextInt(100);
            }
            array[i] = temp;
        }
        tempArray = Arrays.copyOf(array, 10);

        System.out.println("这十个不重复随机数是 " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("排序后是 " + Arrays.toString(array));

        return tempArray;
    }

    public void fun3() {
        //100个学生
        student[] array = new student[100];
        //抽取的十个
        student[] amountGradeArray = new student[10];
        //十个随机序号
        int[] numArray = fun2();

        //生成100个学生
        for (int i = 0; i < 100; i++) {
            array[i] = new student(i, i, "名字" + i, i, i, i, i, i);
        }

        System.out.println("这十个学生信息如下");
        for (int i = 0; i < 10; i++) {
            System.out.println(array[numArray[i]]);
            amountGradeArray[i] = array[numArray[i]];
        }

        System.out.println("根据总成绩排序后如下");

        //自定义比较器来使用自定义类排序
        Arrays.sort(amountGradeArray, Comparator.comparingInt(student::getAmount));
        for (int i = 0; i < 10; i++) {
            System.out.println(amountGradeArray[i]);
        }
    }

    public static void main(String[] args) {
        fun1();
        System.out.println();
        fun2();
        System.out.println();
        new f1().fun3();
    }
}
