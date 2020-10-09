package A.p1;

public class t1 {
    public static void fun1() {
        for (int i = 100; i < 1000; i++) {
            int num1 = i / 100, num2 = (i % 100) / 10, num3 = (i % 10);

            if (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3) == i) {
                System.out.println(i);
            }
        }
    }

    public static void fun2() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "×" + j + "=" + i * j + " ");
            }
            System.out.println();
        }

    }

    public static void fun3(int[][] myArray) {
        int min = Integer.MAX_VALUE;
        int ti = -1, tj = -1;

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                if(myArray[i][j]<min){
                    ti=i;
                    tj=j;
                    min=myArray[i][j];
                }
            }
        }
        System.out.println("最小值是 "+myArray[ti][tj]+"  坐标是 "+ti+" , "+tj);
    }

    public static void main(String[] args) {
        int [][]array={
                {1,3,5,4,7},
                {2,7,3,9,7},
                {-6,8,7,9,5}
        };

        fun1();
        System.out.println();
        fun2();
        System.out.println();
        fun3(array);

    }
}
