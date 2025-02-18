package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.Control;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();

	}

	@Override
	public void init() throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		map.put("/addBoard.do", new AddBoardControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("front controller called");

		String uri = req.getRequestURI();
//		System.out.println(uri);
		String context = req.getContextPath();
//		System.out.println(context);
		String page = uri.substring(context.length());
//		System.out.println(page);

		Control ctl = map.get(page);
		ctl.exec(req, resp);
	}

}
