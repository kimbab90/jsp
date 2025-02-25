package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/json;charset=utf-8");

		String boardNo = req.getParameter("board_no");

		ReplyDAO dao = new ReplyDAO();

		List<ReplyVO> list = dao.replyList(Integer.parseInt(boardNo));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		resp.getWriter().print(gson.toJson(list));

	}

}
