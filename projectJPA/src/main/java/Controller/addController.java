package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.member;
import Dao.memberDao;

public class addController extends HttpServlet{
	
	public addController(){ super(); }
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		member m = new member(name, username, password, address, email);
		
		new memberDao().add(m);
		
		response.sendRedirect("finish.jsp");
		
	}
	
}
