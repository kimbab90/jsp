package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.MemberVO;

public class MemberDAO extends DAO {

	public MemberVO login(String memberId, String passwd) {

		String query = "select * from tbl_member where member_id = ? and passwd = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, passwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				MemberVO member = new MemberVO();
				member.setMemberId(rs.getString("member_id"));
				member.setPasswd(rs.getString("passwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));

				return member;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return null;

	}

	public List<MemberVO> members() {

		List<MemberVO> members = new ArrayList<>();

		String query = "select * from tbl_member order by responsibility, member_id";

		try {
			pstmt = getConnect().prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO member = new MemberVO();
				member.setMemberId(rs.getString("member_id"));
				member.setPasswd(rs.getString("passwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));

				members.add(member);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return members;

	}

	public boolean deleteMember(String memberId) {

		String query = "delete from tbl_member where member_id = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, memberId);

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

	public boolean insertMember(MemberVO member) {

		String query = "insert into tbl_member values (?, ?, ?, ?)";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getResponsibility());

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
