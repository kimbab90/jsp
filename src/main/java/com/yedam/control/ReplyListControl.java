package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");

		String boardNo = req.getParameter("board_no");
		String pageNo = req.getParameter("page_no");
		pageNo = pageNo == null ? "1" : pageNo;

//		ReplyDAO dao = new ReplyDAO();
//		ReplyMapper mapper = DataSource.getReplyMapper();

		List<ReplyVO> list = DataSource.getReplyMapper().replyList(Integer.parseInt(boardNo), Integer.parseInt(pageNo));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		resp.getWriter().print(gson.toJson(list));

	}

}
