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

public class FullDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("application/json;charset=utf-8");
		
		List<Map<String, Object>> list = DataSource.getReplyMapper().fullData();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		resp.getWriter().print(gson.toJson(list));
	}

}
