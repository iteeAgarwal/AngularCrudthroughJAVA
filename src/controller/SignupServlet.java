package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Data;
import dao.SignUpDao;
import service.signupService;
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*super.doPost(req, resp);*/
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pnumber=req.getParameter("pnumber");
		String pass=req.getParameter("pass");
		/*console.log(name);*/
		System.out.println("Name:-"+name+"Email:-"+email+"Phone Number:-"+pnumber+"Password:-"+pass);
		boolean flag=SignUpDao.registration(name,email,pnumber,pass);
		System.out.println("Flag value"+flag);
			String user1=signupService.getAllUser(pnumber);	
			resp.setContentType("application/json");
			//Send the json Result back to angular controller
			resp.getWriter().write(user1);
		
		
	}

}
