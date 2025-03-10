package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;
	private String img;

}
