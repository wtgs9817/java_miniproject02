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
 * Servlet implementation class GetAllStudentServlet
 */
@WebServlet("/getAll.do")
public class GetAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentVO vo = new StudentVO();
		StudentDAO dao = new StudentDAO();
		PrintWriter out = response.getWriter();
		
		List<StudentVO> stdList = dao.getAllStudentList();
		
		out.println("<html>");
		
		

		out.println("<head>");
		out.println("<title>studentInfo</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<center>");
		
		out.println("<h1>학생정보</h1>");
		out.println(" <form action='getStudent.do' method='post' >  ");
		out.println("학번검색 : <input type='text' name='stdnum'> </input>");
		out.println("<input type='submit' value='전송'> </input>");
		out.println("</form>");
		
		
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
		
		
		out.println("<br>");
		out.println("<a href='/'>처음으로</a>");
		
		
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		
		
		
		
	}

}
