package com.yedam.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private int empNo;
	private String empName;
	private String telNo;
	private Date hireDate;
	private int salary;

	public Employee(int empNo, String empName, String telNo) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.telNo = telNo;
		this.hireDate = new Date();
		this.salary = 250;
	}

	public Employee(int empNo, String empName, String telNo, String hireDate, int salary) {
		this(empNo, empName, telNo);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			this.hireDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.salary = salary;
	}

	public String empInfo() {
		return "" + empNo + "  " + empName + "  " + telNo + "  " + salary;
	}

}
