package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;
import Model.member;

public class updateController extends HttpServlet{
	
	public updateController() { super(); }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
	request.setCharacterEncoding("utf-8");
		
		String ids = request.getParameter("id");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		int id=0;
		member m=null;
		boolean status=false;
		
		
		if(ids !=null) {
			id = Integer.parseInt(ids);
		}
		
		m = (member) new memberDao().queryId(id);
		
		if(m!=null) {
			
			m.setName(name);
			m.setUsername(username);
			m.setPassword(password);
			m.setPhone(phone);
			m.setEmail(email);
			
			status = new memberDao().update(m);
			
			if(status) {
				response.sendRedirect("finish.jsp");
			}else {
				response.sendRedirect("fail.html");
			}
		}else {
			response.sendRedirect("fail.html");
		}
		
		
	}
	
}
