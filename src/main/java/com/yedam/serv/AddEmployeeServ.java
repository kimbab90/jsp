package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

/**
 * Servlet implementation class AddEmployeeServ
 */
@WebServlet("/addEmp")
public class AddEmployeeServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String empNo = req.getParameter("emp_no");
		String empName = req.getParameter("emp_name");
		String telNo = req.getParameter("tel_no");

		EmpDAO dao = new EmpDAO();

		resp.setContentType("text/html;charset=utf-8");

		if (dao.register(new Employee(Integer.parseInt(empNo), empName, telNo))) {
//			resp.sendRedirect("sample");

			resp.getWriter().print("등록성공");
		} else {
			resp.getWriter().print("등록실패");
		}
	}
}
