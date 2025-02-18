package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {

	public List<Student> search(Student std) {
		// TODO Auto-generated method stub

		List<Student> stdList = new ArrayList<>();

		String query = "select * from tbl_student" + " where student_name = nvl(?, student_name)"
				+ " order by student_no";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, std.getStudentName());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				stdList.add(new Student(rs.getString("student_no"), rs.getString("student_name"), rs.getString("phone"),
						rs.getString("address")));
			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stdList;
	}

	public boolean addStd(Student std) {
		// TODO Auto-generated method stub

		String query = "insert into tbl_student values (?, ?, ?, ?)";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, std.getStudentNo());
			pstmt.setString(2, std.getStudentName());
			pstmt.setString(3, std.getPhone());
			pstmt.setString(4, std.getAddress());

			int r = pstmt.executeUpdate();

			conn.close();

			if (r > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
