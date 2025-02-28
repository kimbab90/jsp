package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DataSource;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String replyNo = req.getParameter("reply_no");

//		ReplyDAO dao = new ReplyDAO();
//		ReplyMapper mapper = DataSource.getReplyMapper();

		if (DataSource.getReplyMapper().deleteReply(Integer.parseInt(replyNo)) == 1) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	}

}
