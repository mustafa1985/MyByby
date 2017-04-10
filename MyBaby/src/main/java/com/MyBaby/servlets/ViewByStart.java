package com.MyBaby.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyBaby.bean.Baby;
import com.MyBaby.dao.BabyDao;
@WebServlet("/ViewByStart")
public class ViewByStart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String start=request.getParameter("start");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Baby by "+start.toUpperCase()+"</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewBabyNameByReligion?religion=India' class='btn btn-primary' role='button'>India</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Middle East' class='btn btn-primary' role='button'>Middle East</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Asia' class='btn btn-primary' role='button'>Asia</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Europe' class='btn btn-primary' role='button'>Europe</a> ");
		request.getRequestDispatcher("atoz.html").include(request, response);
		
		out.println("<h1>View Baby Names by "+start.toUpperCase()+"</h1>");
		List<Baby> list=BabyDao.getRecordsByStart(start);
		
		out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Meaning</th><th>Sex</th><th>Region</th></tr>");
		for(Baby b:list){
			out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getMeaning()+"</td><td>"+b.getSex()+"</td><td>"+b.getReligion()+"</td></tr>");
		}
		out.println("</table>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
