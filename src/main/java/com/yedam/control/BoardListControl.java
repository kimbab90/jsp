package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("boardListControl");
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectBoard();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("boardList.jsp").forward(req, resp);
	}
}
