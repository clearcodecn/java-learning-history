package cn.clearcode.jdbc;

import java.sql.*;

public class Main {

    public static void main(String args[]) {
        findAllAndPrint();
    }

    static void findAllAndPrint(){
        Connection connection = DButil.open();
        String sql = "select id,user,password from users";

        try {
            // 创建不带参数的数据库访问接口
            Statement statement = connection.createStatement();
            // 执行，并且返回结果集
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                System.out.print("id:" + rs.getInt(1) + ",user:" + rs.getString(2) + "pass:" + rs.getString("password") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection);
        }
    }

}
