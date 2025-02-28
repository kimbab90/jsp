package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DataSource;
import com.yedam.common.PageVO;
import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;

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

		SearchVO search = new SearchVO(Integer.parseInt(pageNo), sc, kw);
		
//		BoardMapper mapper = DataSource.getBoardMapper();
	
		List<BoardVO> list =  DataSource.getBoardMapper().selectBoard(search);
		
		req.setAttribute("list", list);
		
		int totalCnt = DataSource.getBoardMapper().getTotalCnt(search);
		
		PageVO paging = new PageVO(Integer.parseInt(pageNo), totalCnt);
		
		req.setAttribute("paging", paging);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
	}
}
