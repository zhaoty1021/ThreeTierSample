package org.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.student.entity.Student;

public class StudentDao {
	private final String URL="jdbc:mysql://localhost:3306/userlist?serverTimezone=GMT%2B8&useSSL=false&autoReconnect=true";
	private final String USERNAME = "root";
	private final String PASSWORD = "1025338403";
	
	public boolean isExist(int id) {
		return queryStudentById(id)==null?false:true;
	}
	public Student queryStudentById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student student=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql="select * from student where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				int unumber=rs.getInt("id");
				String uname=rs.getString("studentname");
				student=new Student(unumber, uname);
			}
			return student;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean addStudent(Student student) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql="insert into student values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			int count=ps.executeUpdate();
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
