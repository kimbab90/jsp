package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.DataSource;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		String saveDir = req.getServletContext().getRealPath("images");
		MultipartRequest mr = new MultipartRequest(req, saveDir, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
		BoardVO board = new BoardVO();

		board.setTitle(mr.getParameter("title"));
		board.setContent(mr.getParameter("content"));
		board.setWriter(mr.getParameter("writer"));
		board.setImg(mr.getFilesystemName("img"));
		
		if (DataSource.getBoardMapper().insertBoard(board) == 1) {
			resp.sendRedirect("boardList.do");
		} else {
			
		}
	}
}
