package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	Connection getConnect() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	};

	public List<Employee> search(Employee emp) {
		// TODO Auto-generated method stub

		List<Employee> empList = new ArrayList<>();

		String query = "select * from tbl_employees where emp_name = nvl(?, emp_name) order by emp_no";

		try {
			PreparedStatement stmt = getConnect().prepareStatement(query);
			stmt.setString(1, emp.getEmpName());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmpNo(rs.getInt("emp_no"));
				emp1.setEmpName(rs.getString("emp_name"));
				emp1.setTelNo(rs.getString("tel_no"));
				emp1.setHireDate(rs.getDate("hire_date"));
				emp1.setSalary(rs.getInt("salary"));

				empList.add(emp1);
			}

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
			PreparedStatement stmt = getConnect().prepareStatement(query);
			stmt.setInt(1, emp.getEmpNo());
			stmt.setString(2, emp.getEmpName());
			stmt.setString(3, emp.getTelNo());
			stmt.setString(4, sdf.format(emp.getHireDate()));
			stmt.setInt(5, emp.getSalary());

			int r = stmt.executeUpdate();

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
			PreparedStatement stmt = getConnect().prepareStatement(query);
			stmt.setInt(1, empNo);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setTelNo(rs.getString("tel_no"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));

				return emp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
