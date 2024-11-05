package com.studentprogram.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentprogram.studentinfo.StudentDAO;
import com.studentprogram.studentinfo.StudentVO;

/**
 * Servlet implementation class InsertStudentServlet
 */

@WebServlet("/insert.do")
public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String stdnum = request.getParameter("stdnum");
		String major = request.getParameter("major");
		String phonenum = request.getParameter("phonenum");
		
		
		StudentVO vo = new StudentVO();
		StudentDAO dao = new StudentDAO();
		
		vo.setName(name);
		vo.setMajor(major);
		vo.setPhonenum(phonenum);
		vo.setStdnum(stdnum);
		
		dao.insertStudent(vo);
		
		response.sendRedirect("/");
		
	}

}
