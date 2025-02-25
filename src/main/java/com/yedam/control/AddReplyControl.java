package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String boardNo = req.getParameter("board_no");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");

		ReplyVO vo = new ReplyVO();
		vo.setBoardNo(Integer.parseInt(boardNo));
		vo.setReply(reply);
		vo.setReplyer(replyer);

		ReplyDAO dao = new ReplyDAO();

		Map<String, Object> result = new HashMap<>();
		Gson gson = new GsonBuilder().create();

		if (dao.insertReply(vo)) {
			result.put("retCode", "OK");
			result.put("retVal", vo);
		} else {
			result.put("retCode", "NG");
		}

		resp.getWriter().print(gson.toJson(result));
	}

}
