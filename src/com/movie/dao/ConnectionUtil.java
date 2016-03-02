package com.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

  public Connection openConnection() {
  
	  String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://localhost/movie";
      String username = "root";     //修改为你自己用户名
      String password = "s1u9s9a2n";      //修改为你自己密码
  Connection conn = null;
  try {
   // Class.forName加载驱动
   Class.forName(driver);
   // DriverManager获得连接
   conn = DriverManager.getConnection(url,
     username, password);
   return conn;
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }
}