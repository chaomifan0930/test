package com.sc;

import java.sql.Connection;
import java.sql.DriverManager;


public class Test {
	
	//开始实现代码重用
	static Connection conn =null;
	
	static String driver="oracle.jdbc.driver.OracleDriver";
	static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static String name="CRM1";
	static String pass="scit_190506_crm1";
	
	public static void main(String[] args) {
		try {
			//1.注册驱动
			Class.forName(driver);
			System.out.println("注册驱动类成功");
			conn=DriverManager.getConnection(url, name, pass);
		    System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败");
		}
	}
}
	