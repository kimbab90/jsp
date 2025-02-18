package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

/**
 * Servlet implementation class addStd
 */
@WebServlet("/addStd")
public class AddStd extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String studentNo = req.getParameter("student_no");	
		String studentName = req.getParameter("student_name");	
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		StudentDAO dao = new StudentDAO();
		
		if (dao.addStd(new Student(studentNo, studentName, phone, address))) {
			out.print("등록성공");
//			resp.sendRedirect("stdList");
		} else {
			out.print("등록실패");
		}
	}
}
