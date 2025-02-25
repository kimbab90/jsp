package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getMethod().equals("GET")) {

			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {

			String memberId = req.getParameter("member_id");
			String passwd = req.getParameter("passwd");

			MemberDAO dao = new MemberDAO();

			MemberVO member = dao.login(memberId, passwd);

			if (member != null) {
				if ("User".equals(member.getResponsibility())) {
					HttpSession session = req.getSession();
					session.setAttribute("loginId", memberId);
					resp.sendRedirect("boardList.do");

				} else if ("Admin".equals(member.getResponsibility())) {
					HttpSession session = req.getSession();
					session.setAttribute("loginId", memberId);
					resp.sendRedirect("memberList.do");

				}
			} else {

			}
		}
	}
}
