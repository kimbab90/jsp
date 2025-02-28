package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DataSource;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int boardNo = Integer.parseInt(req.getParameter("board_no"));
				
//		BoardMapper mapper = DataSource.getBoardMapper();
		
		if (DataSource.getBoardMapper().deleteBoard(boardNo) == 1) {
			resp.sendRedirect("boardList.do");
		} else {
			
		}
	}

}
