package com.neusoft.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bean.Userinfo;
import com.neusoft.service.IUserService;
import com.neusoft.service.UserServiceImp;
import com.neusoft.utils.Md5Utils;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		//1.获取前台参数
//		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email");
		String nickName=request.getParameter("username");
		String password =request.getParameter("pass");
		String confirmPwd=request.getParameter("repass");
		
		//2.判断密码和确认密码是否一致
		//3.一致，调用service接口完成用户注册，service作用调用dao层，
		if(password != null && !password.trim().equals("")&&password.equals(confirmPwd)) {
			IUserService ius=new UserServiceImp();
			Userinfo user=new Userinfo();
			user.setEmail(email);
			user.setNickname(nickName);
			user.setPassword(Md5Utils.md5(password));
			int ret=ius.addUser(user);
			//从定向到登陆界面
			System.out.println("注册了"+ret+"用户");
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}
		//不一致
		else {
			response.sendRedirect(request.getContextPath()+"/jsp/reg.jsp");
		}
		
		
		
		
		
		
		
		
	}

}
