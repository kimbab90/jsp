package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

	public List<BoardVO> selectBoard() {

		List<BoardVO> list = new ArrayList<>();

		String query = "select * from tbl_board order by board_no";

		try {
			pstmt = getConnect().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new BoardVO(rs.getInt("board_no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer"),
						rs.getDate("write_Date"),
						rs.getInt("view_cnt")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertBoard(BoardVO board) {

		String query = "insert into tbl_board (board_no, title, content, writer) "
		+ "values (board_seq, ?, ?, ?)";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateBoard(BoardVO board) {

		String query = "updat tbl_board set title = ?, content = ?, write_date = sysdate "
		+ "where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBoard(int boardNo) {

		String query = "delete from tbl_board where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
