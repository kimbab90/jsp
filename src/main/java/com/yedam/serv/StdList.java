package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

/**
 * Servlet implementation class StdListServ
 */
@WebServlet("/stdList")
public class StdList extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(req, resp);

		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.search(new Student());

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		for (Student std : list) {
			out.print("<p><a href='removeStd?student_no="+ std.getStudentNo() + "'" + std.getStudentNo() + "</a> / " + std.getStudentName() + "</p>");
		}
	}

}
