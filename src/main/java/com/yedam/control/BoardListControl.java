package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.PageVO;
import com.yedam.vo.SearchVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String pageNo = req.getParameter("page_no");
		pageNo = pageNo == null ? "1" : pageNo;
		
		String sc = req.getParameter("search_condition");
		String kw = req.getParameter("keyword");
		sc = sc == null ? "" : sc;
		kw = kw == null ? "" : kw;

		BoardDAO dao = new BoardDAO();
		SearchVO search = new SearchVO(Integer.parseInt(pageNo), sc, kw);

		List<BoardVO> list = dao.selectBoard(search);
		
		req.setAttribute("list", list);
		
		int totalCnt = dao.getTotalCnt(search);
		
		PageVO paging = new PageVO(Integer.parseInt(pageNo), totalCnt);
		
		req.setAttribute("paging", paging);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
	}
}
