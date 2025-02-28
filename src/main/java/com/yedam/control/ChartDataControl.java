package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;

public class ChartDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		ReplyDAO dao = new ReplyDAO();
		
		List<Map<String, Object>> list = DataSource.getReplyMapper().chartData();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
//		System.out.println(gson.toJson(list));
		
		resp.getWriter().print(gson.toJson(list));
	}

}
