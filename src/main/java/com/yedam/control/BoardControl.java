package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int boardNo = Integer.parseInt(req.getParameter("board_no"));
		
		BoardDAO dao = new BoardDAO();

		dao.updateViewCnt(boardNo);
		
		BoardVO board = dao.getBoard(boardNo);
		
		req.setAttribute("board", board);
	
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
	}

}
