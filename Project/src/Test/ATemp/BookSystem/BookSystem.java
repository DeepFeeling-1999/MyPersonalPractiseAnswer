package Test.ATemp.BookSystem;


import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSystem {
    /***
     本文使用的数据库名称为user,账号密码均为root,
     数据库含表userinfo,
     该表有三个字段，id(INT),userinfo(VARCHAR),password(VARCHAR)
     读者可根据数据库的实际情况对语句进行修改
     ***/
    public static void main(String[] args) {
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1,加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接
            //此处按照实际的数据库名称和账号密码进行修改
            //格式为jdbc:mysql://127.0.0.1:3306/数据库名称?useSSL=true&characterEncoding=utf-8&user=账号名&password=密码
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=true&characterEncoding=utf-8&user=root&password=root");
            System.out.println("创建连接成功");
            //3.写sql
            //根据数据库实际的表名写SQL语句
            String sql="select * from userinfo";
            //4.得到statement对象执行sql
            statement = ((java.sql.Connection) connection).prepareStatement(sql);
            //5.得到结果集
            rs = statement.executeQuery();
            //6.处理结果集
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.关闭
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("关闭成功");
        }
    }
}


/*
public class BookSystem {


    /**
     * 获取数据库连接
     *
     * @return Connection对象
     *//*
    public Connection getConnection() {
        Connection conn = null;   //数据库连接
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动，注册到驱动管理器

            /*数据库链接地址*//*
            String url = "jdbc:mysql://localhost:3306/company?useSSL=false";
            //String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "337+d7+d";
            /*创建Connection链接*//*
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
     *//*
    public static void main(String[] args) {

        BookSystem B = new BookSystem();
        B.showBook();
        //System.out.println(fb.findAll());

    }
}
*/