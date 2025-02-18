package com.yedam.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Employee;

public class EmpDAO extends DAO {

	public List<Employee> search(Employee emp) {
		// TODO Auto-generated method stub

		List<Employee> empList = new ArrayList<>();

		String query = "select * from tbl_employees where emp_name = nvl(?, emp_name) order by emp_no";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, emp.getEmpName());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmpNo(rs.getInt("emp_no"));
				emp1.setEmpName(rs.getString("emp_name"));
				emp1.setTelNo(rs.getString("tel_no"));
				emp1.setHireDate(rs.getDate("hire_date"));
				emp1.setSalary(rs.getInt("salary"));

				empList.add(emp1);
			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	public boolean register(Employee emp) {
		// TODO Auto-generated method stub

		String query = "insert into tbl_employees values (?, ?, ?, ?, ?)";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getTelNo());
			pstmt.setString(4, sdf.format(emp.getHireDate()));
			pstmt.setInt(5, emp.getSalary());

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

	public Employee selectEmp(int empNo) {

		String query = "select * from tbl_employees where emp_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, empNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setTelNo(rs.getString("tel_no"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));

				conn.close();

				return emp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
