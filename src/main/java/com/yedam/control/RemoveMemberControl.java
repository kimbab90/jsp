package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;

public class RemoveMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String memberId = req.getParameter("member_id");
		
		MemberDAO dao = new MemberDAO();
		
		if (dao.deleteMember(memberId)) {
			//{"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			//{"retCode": "NG"}
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}

	}

}
