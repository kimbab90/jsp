package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

// was : init service destroy

public class SampleServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init(config);

		System.out.println("init called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(req, resp);

		System.out.println("service called");

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.search(new Employee());

		for (Employee emp : list) {
			out.print("<p><a href='empInfo?emp_no=" + emp.getEmpNo() + "'>" + emp.getEmpNo() + "</a> / " + emp.getEmpName() + "</p>");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		super.destroy();

		System.out.println("destroy called");
	}
}
