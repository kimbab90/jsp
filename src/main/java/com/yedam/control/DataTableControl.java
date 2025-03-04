package com.yedam.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.vo.ReplyVO;

public class DataTableControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("application/json;charset=utf-8");
		
		String boardNo = req.getParameter("board_no");

		List<ReplyVO> list = DataSource.getReplyMapper().replyListAll(Integer.parseInt(boardNo));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Map<String, Object> data = new HashMap<>();
			
		List<List<String>> dataAll = new ArrayList<>();
		
		for (ReplyVO reply: list) {
			
			List<String> dataList = new ArrayList<>();
			
			dataList.add(String.valueOf(reply.getReplyNo()));
			dataList.add(reply.getReply());
			dataList.add(reply.getReplyer());
			dataList.add(String.valueOf(reply.getReplyDate()));
			
			dataAll.add(dataList);
		}
		
		data.put("data", dataAll);
		
		resp.getWriter().print(gson.toJson(data));
		
	}

}
