package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;
import Model.member;

public class deleteController extends HttpServlet{
	
	public deleteController() { super(); }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		request.setCharacterEncoding("utf-8");
		
		String ids = request.getParameter("id");
		int id=0;
		member m=null;
		boolean status=false;
		
		
		if(ids !=null) {
			id = Integer.parseInt(ids);
		}
		
		m = (member) new memberDao().queryId(id);
		
		if(m!=null && id!=0) {
			
			status = new memberDao().delete(id);
			  
			if(status==true) {
				response.sendRedirect("finish.jsp");
			}
			
			response.sendRedirect("fail.html");
			 
		}else {
			response.sendError(0);
			response.sendRedirect("fail.html");
		}
		
	}

}
