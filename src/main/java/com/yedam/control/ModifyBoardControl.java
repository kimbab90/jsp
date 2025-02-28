package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.DataSource;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		//이미지 갱신 시 기존 이미지 처리
		
		String saveDir = req.getServletContext().getRealPath("images");
		MultipartRequest mr = new MultipartRequest(req, saveDir, 1024*1024*5, "utf-8",new DefaultFileRenamePolicy());
		
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(mr.getParameter("board_no")));
		board.setTitle(mr.getParameter("title"));
		board.setContent(mr.getParameter("content"));
		board.setImg(mr.getFilesystemName("img"));
		
//		BoardMapper mapper = DataSource.getBoardMapper();
		
		if (DataSource.getBoardMapper().updateBoard(board) == 1) {
			resp.sendRedirect("boardList.do");
		} else {
			
		}
	}
}
