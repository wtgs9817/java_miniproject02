package com.studentprogram.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentprogram.studentinfo.StudentDAO;
import com.studentprogram.studentinfo.StudentVO;

/**
 * Servlet implementation class updateStudentServlet
 */
@WebServlet("/updateStudent.do")
public class updateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentVO vo = new StudentVO();
		StudentDAO dao = new StudentDAO();
		PrintWriter out = response.getWriter();
		
		String stdNum = request.getParameter("stdnum");
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String phoneNum = request.getParameter("phonenum");
		
		vo.setName(name);
		vo.setStdnum(stdNum);
		vo.setMajor(major);
		vo.setPhonenum(phoneNum);
		
		dao.updateStudent(vo);
		
		response.sendRedirect("/");
		
	}




}
