package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.ReplyVO;

public class ReplyDAO extends DAO {

	public List<ReplyVO> replyList(int boardNo) {

		List<ReplyVO> list = new ArrayList<>();

		String query = "select * from tbl_reply where board_no = ? order by reply_no";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReplyVO reply = new ReplyVO();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReply(rs.getString("reply"));
				reply.setReplyer(rs.getString("replyer"));
				reply.setReplyDate(rs.getDate("reply_date"));
				reply.setBoardNo(rs.getInt("board_no"));

				list.add(reply);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}

	public ReplyVO selectReply(int replyNo) {

		String query = "select * from tbl_reply where reply_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, replyNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				ReplyVO reply = new ReplyVO();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReply(rs.getString("reply"));
				reply.setReplyer(rs.getString("replyer"));
				reply.setReplyDate(rs.getDate("replye_date"));
				reply.setBoardNo(rs.getInt("board_no"));

				return reply;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return null;
	}

	public boolean insertReply(ReplyVO reply) {

		String query1 = "select reply_seq.nextval from dual";
		String query2 = "insert into tbl_reply values (?, ?, ?, ?, sysdate)";

		try {
			pstmt = getConnect().prepareStatement(query1);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				reply.setReplyNo(rs.getInt(1));

				pstmt = getConnect().prepareStatement(query2);
				pstmt.setInt(1, reply.getReplyNo());
				pstmt.setString(2, reply.getReply());
				pstmt.setString(3, reply.getReplyer());
				pstmt.setInt(4, reply.getBoardNo());
				
				int r = pstmt.executeUpdate();

				if (r > 0) {
					return true;
				}
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	public boolean deleteReply(int replyNo) {

		String query = "delete from tbl_reply where reply_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, replyNo);

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