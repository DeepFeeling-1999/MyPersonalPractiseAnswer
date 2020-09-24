package Test.ATemp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Solution<T> {
    /**
     * @param currentDate 当前日期
     * @return 过去七周的日期集合
     * 每周范围都是一个String
     */
    public static List<String> getLastSevenWeek(Calendar currentDate) {
        //当前日期往前推七周
        currentDate.add(Calendar.DATE, -49);

        List<String> myList = new ArrayList<>();
        //设置日期格式
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 1; i <= 7; i++) {
            //每周的String结果
            StringBuilder weekResult = new StringBuilder();

            weekResult.append("\"");
            //由日期转换为String
            String dateString = myFormat.format(currentDate.getTime());
            weekResult.append(dateString);

            weekResult.append(",");
            //当前日期往后推一周
            currentDate.add(Calendar.DATE, 7);
            dateString = myFormat.format(currentDate.getTime());
            weekResult.append(dateString);
            weekResult.append("\"");

            myList.add(weekResult.toString());
        }
        return myList;
    }

    public static void main(String[] args) {
        //获得当前日期
        Calendar currentDate = Calendar.getInstance();

        System.out.println(getLastSevenWeek(currentDate));
    }
}
