package Test.ATemp.BookSystem;


import java.sql.*;
import java.util.Scanner;

/**
 * @author DeepFeeling
 */
public class BookFunction {
    private static Scanner SC = new Scanner(System.in);
    private static CallableStatement myCallableStatement = null;
    private static ResultSet myResultSet = null;
    private static ResultSetMetaData myResultSetMetaData = null;

    public static int menu() {
        System.out.println("请选择你想要进行的操作：");
        System.out.println("1)增加图书       2）借阅图书");
        System.out.println("3)删除图书       4）查找图书");
        System.out.println("5)修改图书       6）展示所有图书");
        System.out.println("7)退出");

        return SC.nextInt();
    }


    public static void addBook(Connection myConnection) throws SQLException {
        int bNumber, bTotal;
        String bName;
        System.out.println("请输入你想要增加的书籍名称：");
        bName = SC.next();

        System.out.println("请输入你想要增加的书籍编号：");
        bNumber = SC.nextInt();

        System.out.println("请输入你想要增加的书籍总数：");
        bTotal = SC.nextInt();

        myCallableStatement = (CallableStatement) myConnection.prepareCall("call addBook(?,?,?,?)");
        myCallableStatement.setInt(1, bNumber);
        myCallableStatement.setString(2, bName);
        myCallableStatement.setInt(3, bTotal);
        myCallableStatement.setInt(4, bTotal);
        myCallableStatement.execute();

        System.out.println("增加书籍  " + bName + "  完成");
        show(myConnection, "call showBook()");
    }

    public static void borrowBook(Connection myConnection) throws SQLException {
        int rNumber;
        String bName;
        System.out.println("请输入你想要借阅的书籍名称：");
        bName = SC.next();

        System.out.println("请输入你的读者编号：");
        rNumber = SC.nextInt();

        myCallableStatement = (CallableStatement) myConnection.prepareCall("call borrowBook(?,?)");
        myCallableStatement.setString(1, bName);
        myCallableStatement.setInt(2, rNumber);
        myCallableStatement.execute();

        System.out.println("借阅 " + bName + " 成功");
        System.out.println("借阅信息如下： ");
        show(myConnection, "call showBorrowSystem()");
    }

    public static void deleteBook(Connection myConnection) throws SQLException {
        String bName;
        System.out.println("请输入你想要删除的书籍名称：");
        bName = SC.next();

        myCallableStatement = (CallableStatement) myConnection.prepareCall("call deleteBook(?)");
        myCallableStatement.setString(1, bName);
        myCallableStatement.execute();

        System.out.println("当前图书信息如下： ");
        show(myConnection, "call showBook()");
    }

    public static void seekBook(Connection myConnection) throws SQLException {
        int bNumber;
        System.out.println("请输入你想要查找的书籍编号：");
        bNumber = SC.nextInt();

        try {
            //创建存储过程对象
            myCallableStatement = (CallableStatement) myConnection.prepareCall("call seekBook(?)");
            //设置参数
            myCallableStatement.setInt(1,bNumber);
            //查询结果集
            myResultSet = myCallableStatement.executeQuery();
            myResultSetMetaData = (ResultSetMetaData) myResultSet.getMetaData();
            //获得列数
            int columnCount = myResultSetMetaData.getColumnCount();

            System.out.println("查询 " + bNumber + " 号书籍成功");
            System.out.println("当前图书信息如下： ");

            //输出列名
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-33s", myResultSetMetaData.getColumnName(i));
            }

            System.out.println();
            //输出具体每行内容
            while (myResultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-33s", myResultSet.getString(i));
                }
                System.out.println();
            }
            System.out.println("************************************\n\n");
        } catch (SQLException mySqlException) {
            mySqlException.printStackTrace();
        } finally {
            myCallableStatement.close();
            myResultSet.close();
        }
    }

    public static void modifyBook(Connection myConnection) throws SQLException {
        int bNumber, bookExisting;
        System.out.println("请输入你想要修改的书籍编号：");
        bNumber = SC.nextInt();
        System.out.println("请输入书籍现存数量：");
        bookExisting = SC.nextInt();

        myCallableStatement = (CallableStatement) myConnection.prepareCall("call updateBook(?,?)");
        myCallableStatement.setInt(1, bNumber);
        myCallableStatement.setInt(2, bookExisting);
        myCallableStatement.execute();

        System.out.println("修改 " + bNumber + " 号书籍成功");
        System.out.println("当前图书信息如下： ");
        show(myConnection, "call showBook()");
    }

    public static void show(Connection myConnection, String call) throws SQLException {


        try {
            //创建存储过程对象
            myCallableStatement = (CallableStatement) myConnection.prepareCall(call);
            myResultSet = myCallableStatement.executeQuery();
            myResultSetMetaData = (ResultSetMetaData) myResultSet.getMetaData();
            int columnCount = myResultSetMetaData.getColumnCount();
            /*mysql查询语句
            String sql = "SELECT * FROM bookinf";
            PreparedStatement prst = myConnection.prepareStatement(sql);*/

            //输出列名
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-33s", myResultSetMetaData.getColumnName(i));
            }

            System.out.println();
            while (myResultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-33s", myResultSet.getString(i));
                }
                System.out.println();
            }
            System.out.println("************************************\n\n");
        } catch (SQLException mySqlException) {
            mySqlException.printStackTrace();
        } finally {
            myCallableStatement.close();
            myResultSet.close();
        }

    }
}
