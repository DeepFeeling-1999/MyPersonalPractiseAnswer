package A.p4;

class CDate {
    private final int year;
    private final int month;
    private final int day;

    public CDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 判断是否是闰年
     */
    boolean judge(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     *判断这个月的天数，年份使用调用类的年份计
     */
    int daysInMonth(int month) {
        switch (month) {
            case 2: return (28+(judge(this.year) ?1:0));
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            default: return -1;
        }
    }

    /**
     * 计算某年某月的天数
     */
    int daysInMonth(int year,int month) {
        switch (month) {
            case 2: return (28+(judge(year) ?1:0));
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            default: return -1;
        }
    }

    int howManyDays() {
        int result=0;

        //计算整月的天数，如四月则加上1/2/3月的天数
        switch (month-1){
            case 11:result+=30;
            case 10:result+=31;
            case 9:result+=30;
            case 8:result+=31;
            case 7:result+=31;
            case 6:result+=30;
            case 5:result+=31;
            case 4:result+=30;
            case 3:result+=31;
            case 2:result+=(28+(judge(year) ?1:0));
            case 1:result+=31;break;

            default:break;
        }

        //加上当前月份的天数
        return result+day;
    }
}

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class t4 {

    public static void main(String[]args){
        CDate cDate=new CDate(2008,4,8);

        System.out.println("四月的天数  "+cDate.daysInMonth(4));
        System.out.println("二月的天数  "+cDate.daysInMonth(2));
        System.out.println("***********************\n");

        System.out.println("2019年二月的天数  "+cDate.daysInMonth(2019,2));
        System.out.println("2020年二月的天数  "+cDate.daysInMonth(2020,2));
        System.out.println("***********************\n");

        System.out.println("2008年4月8是第  "+cDate.howManyDays());
        System.out.println("2007年4月8是第  "+(new CDate(2007,4,8)).howManyDays());
        System.out.println("***********************\n");
    }
}
