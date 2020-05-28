package Test.ATemp.BookSystem;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author DeepFeeling
 */
public class BookFunction {
    private static final Scanner SC=new Scanner(System.in);
    private static CallableStatement myCallableStatement = null;
    private static ResultSet myResultSet = null;
    private static ResultSetMetaData myResultSetMetaData=null;

    public static int menu(){
        System.out.println("请选择你想要进行的操作：");
        System.out.println("1)增加图书       2）借阅图书");
        System.out.println("3)删除图书       4）查找图书");
        System.out.println("5)修改图书       6）展示所有图书");
        System.out.println("7)退出");

        return SC.nextInt();
    }


    public static void addBook(Connection myConnection){

    }
    public static void borrowBook(Connection myConnection){

    }
    public static void deleteBook(Connection myConnection){

    }
    public static void seekBook(Connection myConnection){

    }
    public static void modifyBook(Connection myConnection){

    }
    public static void showBook(Connection myConnection) throws SQLException {


        try {
            //创建存储过程对象
            myCallableStatement = (CallableStatement) myConnection.prepareCall("call showBook()");
            myResultSet = myCallableStatement.executeQuery();
            myResultSetMetaData= (ResultSetMetaData) myResultSet.getMetaData();
            int columnCount=myResultSetMetaData.getColumnCount();
            /*mysql查询语句
            String sql = "SELECT * FROM bookinf";
            PreparedStatement prst = myConnection.prepareStatement(sql);*/

            //输出列名
            for(int i=1;i<=columnCount;i++){
                System.out.printf("%-30s",myResultSetMetaData.getColumnName(i));
            }

            System.out.println();
            while (myResultSet.next()) {
                for(int i=1;i<=columnCount;i++){
                    System.out.printf("%-30s" ,myResultSet.getString(i));
                }
                System.out.println();
            }
            System.out.println("************************************\n\n");
        }catch (SQLException mySqlException){
            mySqlException.printStackTrace();
        }finally {
            myCallableStatement.close();
            myResultSet.close();
        }

    }
}
