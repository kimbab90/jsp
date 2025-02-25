package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String memberId = req.getParameter("member_id");
		String passwd = req.getParameter("passwd");
		String memberName = req.getParameter("member_name");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO member = new MemberVO();
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		member.setMemberName(memberName);
		member.setResponsibility("User");
		
		if (dao.insertMember(member)) {
			// {"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			// {"retCode": "NG"}
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}

	}

}
