package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

public class BoardDAO extends DAO {
	
	public int getTotalCnt(SearchVO search) {
		
		String query = "select count(1) total_cnt from tbl_board ";
		
		if ("T".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' ";
		} else if ("W".equals(search.getSearchCondition())) {
			query += "where writer like '%'||?||'%' ";
		} else if ("TW".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' or writer like '%'||?||'%' ";
		}

		try {
			pstmt = getConnect().prepareStatement(query);
			int cnt = 1;
			if ("T".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("W".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("TW".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
				pstmt.setString(cnt++, search.getKeyword());
			}
			
			rs = pstmt.executeQuery();

			if (rs.next()) {

//				return rs.getInt("total_cnt");
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return 0;
	}

	public void updateViewCnt(int boardNo) {

		String query = "update tbl_board set view_cnt = view_cnt + 1 where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public BoardVO getBoard(int boardNo) {

		String query = "select * from tbl_board where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(boardNo);
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setImg(rs.getString("img"));

				return board;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return null;
	}

	public List<BoardVO> selectBoard(SearchVO search) {

		List<BoardVO> list = new ArrayList<>();

		String query = "select * "
				+ "from (select rownum rn, tbl_a.* "
				+ "from (select * "
				+ "from tbl_board ";
		
		if ("T".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' ";
		} else if ("W".equals(search.getSearchCondition())) {
			query += "where writer like '%'||?||'%' ";
		} else if ("TW".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' or writer like '%'||?||'%' ";
		}
		
		query += "order by board_no desc) tbl_a) tbl_b "
				+ "where tbl_b.rn > ((? - 1) * 5) and tbl_b.rn < ((? * 5) + 1)";
				
		//int cnt = 1, cnt++, if 로 처리?
		try {
			pstmt = getConnect().prepareStatement(query);
			int cnt = 1;
			if ("T".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("W".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("TW".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
				pstmt.setString(cnt++, search.getKeyword());			
			}
			pstmt.setInt(cnt++, search.getPageNo());
			pstmt.setInt(cnt++, search.getPageNo());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_Date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setImg(rs.getString("img"));
				
				list.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}

	public boolean insertBoard(BoardVO board) {

		String query = "insert into tbl_board (board_no, title, content, writer, img) "
				+ "values (board_seq.nextval, ?, ?, ?, ?)";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getImg());

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	public boolean updateBoard(BoardVO board) {

		String query = "update tbl_board set title = ?, "
				+ "content = ?, "
				+ "img = nvl(?, img) "
				+ "where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getImg());
			pstmt.setInt(4, board.getBoardNo());

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
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
		} finally {
			disConnect();
		}

		return false;
	}

}
