package com.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchVO {

	private int pageNo;
	private String searchCondition;
	private String keyword;
}
