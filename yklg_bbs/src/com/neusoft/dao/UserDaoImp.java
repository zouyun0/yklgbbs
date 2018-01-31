package com.neusoft.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.neusoft.bean.Userinfo;
import com.neusoft.utils.DBUtil;


public class UserDaoImp implements IUserDao{

	public int addUser(Userinfo user) {
		// 连接数据库
		Connection conn=null;
		PreparedStatement ps=null;
		int num=0;
		
			try {
				conn= DBUtil.getInstance().getConnection();
				String sql="insert into tab_bbs_userinfo(email,nickname,password)values(?,?,?)";
				conn.setAutoCommit(false);
				ps=conn.prepareStatement(sql);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getNickname());
				ps.setString(3, user.getPassword());
				
				num=ps.executeUpdate();
				conn.commit();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.getInstance().close(conn);
				DBUtil.getInstance().close(ps);
				
			}
			
			
		
		return num;
	}

	@Override//查询用户
	public Userinfo findUser(String email, String password) {
		// 连接数据库
		Userinfo user=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn= DBUtil.getInstance().getConnection();
			String sql="select * from tab_bbs_userinfo where email=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()) {
				user=new Userinfo();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setCity(rs.getString("city"));
				user.setSex(rs.getInt("sex"));
				user.setHeadUrl(rs.getString("head_url"));
				user.setPassword(rs.getString("password"));
				user.setSignContent(rs.getString("sign_content"));
				user.setKissNum(rs.getInt("kiss_num"));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(conn);
			DBUtil.getInstance().close(ps);
			DBUtil.getInstance().close(rs);
		}
		return user;
	}

}
