package com.yedam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {

	private int startPage;
	private int endPage;
	private int currentPage;
	private int maxPage;
	private boolean prev, next;

	public PageVO(int page, int totalCnt) {
		currentPage = page;
		endPage = (int) Math.ceil(currentPage / 10.0) * 10;
		startPage = endPage - 9;

		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		endPage = endPage > realEnd ? realEnd : endPage;
		maxPage = realEnd;
		
		prev = startPage == 1 ? false : true;
		next = endPage == realEnd ? false : true;
	}
}
