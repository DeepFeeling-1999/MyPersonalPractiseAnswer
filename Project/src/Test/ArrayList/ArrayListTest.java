package Test.ArrayList;

import CoreJava.Chapter5_Extends.EqualsHashcodeToString.Employee;

import java.util.ArrayList;

/**
 * @author dell
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        //预估可能的容量，后面可以继续扩容
        staff.ensureCapacity(6);
        System.out.println("The array list size is " + staff.size());

        staff.add(new Employee("A", 1111, 1111, 1, 1));
        staff.add(new Employee("bbb", 2222, 2222, 2, 2));
        staff.add(new Employee("ccc", 3333, 3333, 3, 3));

        //将储存区域大小调整至当前所需，垃圾回收器将回收多余内存
        staff.trimToSize();
        System.out.println("The array list size is " + staff.size());

        staff.add(new Employee("ddd", 4444, 4444, 4, 4));
        //使用trimToSize后继续增加将花时间再次移动块

        System.out.println("The array list size is " + staff.size());

        Employee[] ar = new Employee[staff.size()];
        staff.toArray(ar);

        for (Employee temp : staff) {
            System.out.println("name = " + temp.getName());
        }
        for (Employee temp : ar) {
            System.out.println("name = " + temp.getName());
        }
    }
}

