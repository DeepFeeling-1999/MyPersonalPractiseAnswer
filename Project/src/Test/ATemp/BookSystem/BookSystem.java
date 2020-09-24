package Test.ATemp.BookSystem;

import java.sql.*;

/**
 * @author dell
 * DRIVER_NAME---mysql驱动包名
 * URL--- 数据库连接地址,注意是数据库名，不是用户名
 * USER_NAME--- 用户名
 */
public class BookSystem {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bookmanagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "337+d7+d";

    public static void main(String[] args) {
        Connection myConnection = null;

        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            myConnection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            int choice;
            while ((choice = BookFunction.menu()) != 7) {
                switch (choice) {
                    case 1: BookFunction.addBook(myConnection);
                        break;
                    case 2: BookFunction.borrowBook(myConnection);
                        break;
                    case 3: BookFunction.deleteBook(myConnection);
                        break;
                    case 4: BookFunction.seekBook(myConnection);
                        break;
                    case 5: BookFunction.modifyBook(myConnection);
                        break;
                    case 6: BookFunction.show(myConnection,"call showBook()");
                        break;

                    default: System.out.println("请输入1-7！");
                }
            }
            System.out.println("拜拜!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (myConnection != null) {
                try {
                    myConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/*
public class BookSystem {


    /*
     * 获取数据库连接
     *
     * @return Connection对象
     */
/*
    public Connection getConnection() {
        Connection conn = null;   //数据库连接
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动，注册到驱动管理器

            /*数据库链接地址*/
/*
            String url = "jdbc:mysql://localhost:3306/company?useSSL=false";
            //String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "337+d7+d";
            /*创建Connection链接*/
/*
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;  //返回数据库连接

    }*/
/*
    /**
     * 通过存储过程查询数据
     *
     * @return List<Book>
     */
/*
    public void showBook() {
        Connection myConnection = getConnection();  //创建数据库连接
        try {
            //调用存储过程
            CallableStatement cs = myConnection.prepareCall("{call showBook()}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 主函数 调用存储过程(测试使用)
     *
     * @param args
     */
/*
    public static void main(String[] args) {

        BookSystem B = new BookSystem();
        B.showBook();
        //System.out.println(fb.findAll());

    }
}
*/