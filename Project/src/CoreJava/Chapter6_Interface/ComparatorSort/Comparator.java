package CoreJava.Chapter6_Interface.ComparatorSort;

/**
 *  Comparator 是一个专用的比较器，在集合外部实现的排序，
 *当这个对象不支持自比较或者自比较函数不能满足你的要求时，
 *你可以写一个比较器来完成两个对象之间大小的比较。
 */
interface Comparator<String>{
    int compare(String first,String second);
}