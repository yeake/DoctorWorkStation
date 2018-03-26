package pers.qiuyuzu.dao;

import java.sql.*;

import org.junit.Test;

import pers.qiuyuzu.servlet.User;
public class JdbcOperation {
	
	@Test
	public static User getUserInfo(String username){
		User user = new User(null,null);
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from user where username = '"+username+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
//				System.out.println("id="+rs.getObject("id"));
//				System.out.println("username="+rs.getObject("username"));
//				System.out.println("password="+rs.getObject("password"));
				user.setUsername((String) rs.getObject("username"));
				user.setPassword((String) rs.getObject("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return user;
	}
	
	public static boolean addUser(User user){
		boolean bool = false;
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			if(isExisted(user.getUsername())) {
				String sql = "insert into user(username,password) values ('"+user.getUsername()+"','"+user.getPassword()+"')";
				int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println(user.getUsername()+"注册成功!");
				bool = true;
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return bool;
	}
	
	@Test
	public static boolean isExisted(String username){
		boolean bool = true;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from user where username = '"+username+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				bool = false;
				System.out.println(username+"已存在！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return bool;
	}
}
