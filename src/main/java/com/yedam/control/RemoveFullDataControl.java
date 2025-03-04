package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;

public class RemoveFullDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		String title = req.getParameter("title");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		Map<String, Object> result = new HashMap<>();
		
		if (DataSource.getReplyMapper().deleteFullData(title, startDate, endDate) == 1) {
			result.put("retCode", "OK");
		} else {
			result.put("retCode", "NG");
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
	}

}
