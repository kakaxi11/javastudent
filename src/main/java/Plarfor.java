import java.sql.*;

public class Plarfor {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            // 加载数据库驱动类
            //class.name返回与给定的字符串名称相关联类或接口的Class对象
            Class.forName("com.mysql.jdbc.Driver");
            //获取开始时间
            long start = System.currentTimeMillis();

//            使用JDBC时，我们先了解什么是Connection。Connection代表一个JDBC连接，
//            它相当于Java程序到数据库的连接（通常是TCP连接）。打开一个Connection时，
//            需要准备URL、用户名和口令，才能成功连接到数据库。
            // 建立连接

//            假设数据库运行在本机localhost，端口使用标准的3306，数据库名称是school，那么URL如下：
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                    "root", "72876526Xx");
//            核心代码是DriverManager提供的静态方法getConnection()。
//            DriverManager会自动扫描classpath，找到所有的JDBC驱动，然后根据我们传入的URL自动挑选一个合适的驱动。
//
            //获取结束时间方便计算链接耗时
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

//            sql语句不要使用这种拼接形式，恶意sql，使用prepareStatement就可以解决恶意sql的问题
//            String sql = "select * from tb_name where name= '"+varname+"' and passwd='"+varpasswd+"'";



//            插入
//            对数据库的操作主要由下面这条sql决定
            String sql = "insert into student(id,name,age) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            // 第二个，必须调用PreparedStatement的setX()系列方法，对指定的占位符设置实际的值
            ps.setInt(1, 4);
            ps.setString(2, "ximeileiz");
            ps.setInt(3, 20);
            // Statement.executeUpdate()方法，就可以用来执行insert、update、delete语句
            // 返回类型是个int值，也就是SQL语句影响的行数
            // 第三个，执行SQL语句时，直接使用executeUpdate()即可，不用传入任何参数
            int rtn = ps.executeUpdate();

            System.out.println("SQL语句影响了【" + rtn + "】行。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 最后一定要记得在finally代码块中，尽快在执行完SQL语句之后，就释放数据库连接
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


//删除
//    String sql = "delete from student where id=?";
//            ps = conn.prepareStatement(sql);
//                 //注意这里要用setObject因为上面是where查询。
//                    ps.setObject(1, 2);
//                    // Statement.executeUpdate()方法，就可以用来执行insert、update、delete语句
//                    // 返回类型是个int值，也就是SQL语句影响的行数
//                    // 第三个，执行SQL语句时，直接使用executeUpdate()即可，不用传入任何参数
//                    int rtn = ps.executeUpdate();










//上面是prestatement的插入

//下面是查询，但使用的是statement


            // 创建Statement对象
//            stmt = conn.createStatement();
//            // 执行SQL语句
//            rs = stmt.executeQuery("select * from student");
//            System.out.println("id\tname\tage\tsex");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
//                        + "\t" + rs.getInt(3) + "\t" + rs.getInt(4));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
////                    因为JDBC连接是一种昂贵的资源，所以使用后要及时释放。
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
//
//
