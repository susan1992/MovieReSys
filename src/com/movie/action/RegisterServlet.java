package com.movie.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.uDAO;
import com.movie.dao.DAOFactory;
import com.movie.domain.User;

public class RegisterServlet extends HttpServlet {
 
  
 public void doPost(HttpServletRequest request,HttpServletResponse response)
 throws ServletException,IOException{
  String email=request.getParameter("email");
  String pwd=request.getParameter("pwd");
  User user=new User();
  user.setEmail(email);
  user.setPwd(pwd);
  uDAO udao=DAOFactory.getUserDAOInstance();
  udao.save(user);
  PrintWriter out=response.getWriter();
  //out.println("Hello World Servlet james");
  System.out.println("email |"+email);;
  //实现页面的跳转
  if(email!=null){
   
	  out.print("注册成功！请关闭注册窗口:)");

     }else{
  request.getRequestDispatcher("/failure.jsp").forward(request, response);
  
 }

}}