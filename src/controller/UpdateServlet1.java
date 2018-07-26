package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.SignUpDao;
/**
 * Servlet implementation class UpdateServlet1
 */
public class UpdateServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		System.out.println("Updation Name"+name);
		String pnumber=request.getParameter("pnumber");
		String email=request.getParameter("email");
		int i=SignUpDao.update(name,pnumber,email);
		System.out.println(i);
		
	}
}
