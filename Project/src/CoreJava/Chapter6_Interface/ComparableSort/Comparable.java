package CoreJava.Chapter6_Interface.ComparableSort;

/**
 * Comparable 是在集合内部定义的方法实现的排序，
 * Comparable 是一个对象本身就已经支持自比较所需要实现的接口
 */

public interface Comparable<Employee>{
    int compareTo(Employee other);
}

