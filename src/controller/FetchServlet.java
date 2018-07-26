package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignUpDao;
import util.JsonUtill;

public class FetchServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pnumber=req.getParameter("pnumber");
		System.out.println(pnumber);
		List data=SignUpDao.getAlldata(pnumber);
		String fecthData=JsonUtill.convertJavaToJson(data);
		resp.setContentType("application/json");
		//Send the json Result back to angular controller
		resp.getWriter().write(fecthData);
		System.out.println("Hey Fetch Data"+fecthData);
	}
}
