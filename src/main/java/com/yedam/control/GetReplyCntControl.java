package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DataSource;

public class GetReplyCntControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String boardNo = req.getParameter("board_no");

//		ReplyDAO dao = new ReplyDAO();
//		ReplyMapper mapper = DataSource.getReplyMapper();
		
		int totalCnt = DataSource.getReplyMapper().replyCount(Integer.parseInt(boardNo));

		resp.getWriter().print("{\"totalCnt\" : " + totalCnt + " }");

	}

}
