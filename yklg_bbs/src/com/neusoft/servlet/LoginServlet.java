package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bean.Userinfo;
import com.neusoft.service.IUserService;
import com.neusoft.service.UserServiceImp;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台参数
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		//连接数据库判断Email，password不为空
		
		
		if(email != null && !email.trim().equals("")&&password != null && !password.trim().equals("")) {
		
				IUserService usi=new UserServiceImp();
				Userinfo user=usi.findUser(email, password);//查询到的对象
				if(user!=null) {
					request.getSession().setAttribute("logininof", user);
				//从定向到主页
				response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
				}else {
					response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
				}
				
			
		}else {//email不能为空
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}
		
	}

}
