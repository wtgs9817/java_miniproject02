package com.studentprogram.studentinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentprogram.common.JDBCUtil;

public class StudentDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	private static String STUDENT_INSERT ="insert into student values(?,?,?,?)";
	private static String ALLSTUDENT_SELECT ="select * from student";
	private static String STUDENT_SELECT ="select * from student where stdnum= ? ";
	private static String STUDENT_UPDATE = "update student set name=?, phonenum=?  where stdnum = ?";
	
	
	//학생등록
	public void insertStudent(StudentVO vo) {
		// TODO Auto-generated method stub
		
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STUDENT_INSERT);
			
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getStdnum());
			stmt.setString(3, vo.getMajor());
			stmt.setString(4, vo.getPhonenum());
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception0
			e.printStackTrace();
		}
		
		finally {
			JDBCUtil.close(stmt, conn);
		}
	}


	public List<StudentVO> getAllStudentList() {
		// TODO Auto-generated method stub
		List<StudentVO> stdList = new ArrayList<StudentVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ALLSTUDENT_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				
				vo.setName(rs.getString("NAME"));
				vo.setStdnum(rs.getString("STDNUM"));
				vo.setMajor(rs.getString("MAJOR"));
				vo.setPhonenum(rs.getString("PHONENUM"));
				
				stdList.add(vo);				
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return stdList;
	}

	//학생찾기
	public List<StudentVO> getStudent(StudentVO vo) {
		// TODO Auto-generated method stub
		List<StudentVO> stdList = new ArrayList<StudentVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STUDENT_SELECT);
			
			stmt.setString(1, vo.getStdnum());
			
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				StudentVO stdVO = new StudentVO();
				
				stdVO.setName(rs.getString("NAME"));
				stdVO.setStdnum(rs.getString("STDNUM"));
				stdVO.setMajor(rs.getString("MAJOR"));
				stdVO.setPhonenum(rs.getString("PHONENUM"));
				
				stdList.add(stdVO);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		

		return stdList;
	}


	public void updateStudent(StudentVO vo) {
		// TODO Auto-generated method stub
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(STUDENT_UPDATE);
			
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getPhonenum());
			stmt.setString(3, vo.getStdnum());
			
			stmt.executeUpdate();
									
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			JDBCUtil.close(stmt, conn);
		}
		
		
	}
	
	

}
