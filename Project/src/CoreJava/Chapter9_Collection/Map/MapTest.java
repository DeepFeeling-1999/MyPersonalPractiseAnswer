package CoreJava.Chapter9_Collection.Map;

import java.util.HashMap;
import java.util.Map;
/**
 * 映射
 * map 地图，有映射的意思
 * 映射用来存放键值对
 * HashMap和TreeMap都实现了Map接口
 * 散列实现稍快，但不按排列顺序
 */
public class MapTest
{
    public static void main(String[] args)
    {
        //用字符串作为键，值为Employee对象
        //HashMap实现了Map接口
        Map<String,Employee> staff=new HashMap<>();

        staff.put("222",new Employee("zzz"));
        staff.put("111",new Employee("bbb"));
        staff.put("333",new Employee("aaa"));
        staff.put("666",new Employee("zzz"));
        staff.put("555",new Employee("bbb"));
        staff.put("777",new Employee("aaa"));

        //调用toString方法
        System.out.println(staff);

        //删除
        staff.remove("555");

        //替换新值
        staff.put("777",new Employee("replace"));

        //根据键值来查找
        System.out.println(staff.get("777"));

        //遍历所有，用lambda表达式
        staff.forEach((key,value)->
        {
            System.out.println("Key="+key+" , value ="+value);
        });
    }
}
