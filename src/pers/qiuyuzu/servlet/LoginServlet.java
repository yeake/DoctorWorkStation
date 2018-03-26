package pers.qiuyuzu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiuyuzu.dao.JdbcOperation;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = JdbcOperation.getUserInfo(username);
		if(user.getUsername()!=null && user.getPassword()!=null){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				//用户登陆成功,在session中存一个登陆标记
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/TimeListServlet");
				//request.getRequestDispatcher("/TimeListServlet").forward(request, response);
				return;
			}
			
			response.setHeader( "refresh", "3;url='/DoctorWorkStation/login.html'" );
		out.write( "密码错误！三秒后跳转回登陆页..." );
			return;
		}
		response.setHeader( "refresh", "3;url='/DoctorWorkStation/login.html'" );
		out.write( "用户不存在！三秒后跳转回登录页..." );
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
