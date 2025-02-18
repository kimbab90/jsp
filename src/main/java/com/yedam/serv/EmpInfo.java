package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

/**
 * Servlet implementation class EmpInfo
 */
@WebServlet("/empInfo")
public class EmpInfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("text/html;charset=utf-8");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String empNo = req.getParameter("emp_no");

		EmpDAO dao = new EmpDAO();
		Employee emp = dao.selectEmp(Integer.parseInt(empNo));

		PrintWriter out = resp.getWriter();
		out.print("<table style='border: 1px black solid'>");

		if (emp != null) {
			out.print("<tr><th>사번</th><td>" + emp.getEmpNo() + "</td></tr>");
			out.print("<tr><th>이름</th><td>" + emp.getEmpName() + "</td></tr>");
			out.print("<tr><th>연락처</th><td>" + emp.getTelNo() + "</td></tr>");
			out.print("<tr><th>급여</th><td>" + emp.getSalary() + "</td></tr>");
			out.print("<tr><th>입사일자</th><td>" + sdf.format(emp.getHireDate()) + "</td></tr>");
		} else {
			out.print("<tr><td>???</td></tr>");
		}

		out.print("</table>");
		out.print("<a href='sample'>목록으로</a>");
	}
}
