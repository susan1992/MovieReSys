package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

import com.movie.domain.User;
import com.movie.dao.uDAO;
import com.movie.dao.ConnectionUtil;

public class UserDaoImpl implements uDAO{
 //实现接口UerDAO
	public final static String TABLE_NAME = "users";
	public final static String ID_COLUMN = "id";
	public final static String NAME_COLUMN = "name";
	public final static String EMAIL_COLUMN = "email";
 public void save(User user) {
	  ConnectionUtil cu=new ConnectionUtil();//初始化连接的数据库
	  Connection conn=cu.openConnection();
		
	  String sql = "insert into "
				+ TABLE_NAME + " ( "
				+ ID_COLUMN + ", "
				+ NAME_COLUMN + ", "
				+ EMAIL_COLUMN 
				+ ") values (?, ?, ?)";
  try {
	  int ret_id=0;
	  PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery("SELECT MAX(id) FROM users"); 
      if (rs.next())ret_id = rs.getInt(1);
    ps.setInt(1, ret_id+1);
	ps.setString(2, user.getName());
	ps.setString(3, user.getEmail());
	ps.addBatch();
    ps.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
  }finally{
  }
 }
 }