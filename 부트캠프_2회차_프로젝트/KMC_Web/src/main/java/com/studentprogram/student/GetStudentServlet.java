package com.studentprogram.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentprogram.studentinfo.StudentDAO;
import com.studentprogram.studentinfo.StudentVO;

/**
 * Servlet implementation class GetStudentServlet
 */

@WebServlet("/getStudent.do")
public class GetStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String stdNum = request.getParameter("stdnum");
		
		
		StudentVO vo = new StudentVO();
		StudentDAO dao = new StudentDAO();
		PrintWriter out = response.getWriter();
		
		vo.setStdnum(stdNum);
		List<StudentVO> stdList = dao.getStudent(vo);
		
		out.println("<html>");
		
		

		out.println("<head>");
		out.println("<title>studentInfo</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<center>");
		
		out.println("<h1>학생정보</h1>");
		
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		
		out.println("<tr>");
		out.println("<th bgcolor='orange' width='100'>이름</th>");
		out.println("<th bgcolor='orange' width='200'>학번</th>");
		out.println("<th bgcolor='orange' width='150'>학과</th>");
		out.println("<th bgcolor='orange' width='150'>전화번호</th>");
		out.println("</tr>");
		
		 
		
		for (StudentVO stdVO : stdList) {
			out.println("<tr>");
			out.println("<td>" + stdVO.getName()  + "</td>");
			out.println("<td>" + stdVO.getStdnum()  + "</td>");
			out.println("<td>" + stdVO.getMajor()  + "</td>");
			out.println("<td>" + stdVO.getPhonenum()  + "</td>");
			out.println("</tr>");
		}
	
		
		out.println("</table>");
		
		
		
		
		out.println("<a href='/'>처음으로</a>");
		out.println("<a href='updateStudent.html'>정보수정</a>");
			
		out.println("</form>");
		
		out.println("</center>");
		
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		
	}

}
