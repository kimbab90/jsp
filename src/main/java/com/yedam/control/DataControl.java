package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class DataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("application/json;charset=utf-8");

		MemberDAO dao = new MemberDAO();

		List<MemberVO> members = dao.members();

		String json = "[";

		for (int i = 0; i < members.size(); i++) {

			
			json += "{ \"memberId\" : \"" + members.get(i).getMemberId() + "\""; 
			json += ", \"passwd\" : \"" + members.get(i).getPasswd() + "\"";
			json += ", \"memberName\" : \"" + members.get(i).getMemberName()+ "\"";
			json += ", \"responsibility\" : \"" + members.get(i).getResponsibility() + "\"}";

			if (i + 1 < members.size()) {
				json += ", ";
			} 
		}

		json += "]";

		resp.getWriter().print(json);

	}

}
