package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int boardNo = Integer.parseInt(req.getParameter("board_no"));

		BoardDAO dao = new BoardDAO();

		BoardVO board = dao.getBoard(boardNo);

		String loginId = (String) req.getSession().getAttribute("loginId");

		req.setAttribute("board", board);

		if (!board.getWriter().equals(loginId)) {
			
			req.setAttribute("msg", "권한을 확인하세요");
			req.getRequestDispatcher("board/board.tiles").forward(req, resp);

		} else {

			req.getRequestDispatcher("board/modifyBoard.tiles").forward(req, resp);
		}

	}

}
