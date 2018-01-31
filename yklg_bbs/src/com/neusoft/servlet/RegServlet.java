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
		//1.��ȡǰ̨����
//		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email");
		String nickName=request.getParameter("username");
		String password =request.getParameter("pass");
		String confirmPwd=request.getParameter("repass");
		
		//2.�ж������ȷ�������Ƿ�һ��
		//3.һ�£�����service�ӿ�����û�ע�ᣬservice���õ���dao�㣬
		if(password != null && !password.trim().equals("")&&password.equals(confirmPwd)) {
			IUserService ius=new UserServiceImp();
			Userinfo user=new Userinfo();
			user.setEmail(email);
			user.setNickname(nickName);
			user.setPassword(Md5Utils.md5(password));
			int ret=ius.addUser(user);
			//�Ӷ��򵽵�½����
			System.out.println("ע����"+ret+"�û�");
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}
		//��һ��
		else {
			response.sendRedirect(request.getContextPath()+"/jsp/reg.jsp");
		}
		
		
		
		
		
		
		
		
	}

}
