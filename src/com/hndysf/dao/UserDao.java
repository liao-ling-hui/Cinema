package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hndysf.entity.User;

public class UserDao extends BaseDao{

	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//根据账号密码进行用户登录
	public User login_name(String name,String password) {
		User u=new User();
		try {
			conn=this.getConn();
			String sql="select * from user where user_name=? and user_password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_password(rs.getString("user_password"));
				u.setUser_sex(rs.getString("user_sex"));
				u.setUser_phone(rs.getString("user_phone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return u;
	}
	
	
	
	//根据手机号密码进行登录
	public User login_phone(String phone,String password) {
		User u=new User();
		try {
			conn=this.getConn();
			String sql="select * from user where user_phone=? and user_password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_password(rs.getString("user_password"));
				u.setUser_sex(rs.getString("user_sex"));
				u.setUser_phone(rs.getString("user_phone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return u;
	}
	
	
	//添加用户
	public int addUser(User user) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="insert into user(user_name,user_password,user_phone) values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_phone());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return count;
	}
	
	
	//通过用户id查询用户基本信息
	public User findUserById(int user_id) {
		User u=new User();
		try {
			conn=this.getConn();
			String sql="select * from user where user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_password(rs.getString("user_password"));
				u.setUser_sex(rs.getString("user_sex"));
				u.setUser_phone(rs.getString("user_phone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return u;
	}
	
	
	//通过id修改密码或性别
	public  int updatePwdOrSexById(String pwd,String sex,int user_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="update `user` set user_password=?,user_sex=? where user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, sex);
			ps.setInt(3, user_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return count;
	}
	
	
	
	//后台功能
	
	//查询所有用户信息
	public List<User> findUser(){
		List<User> list_user=new ArrayList<User>();
		try{
			conn=this.getConn();
			String sql="select * from user";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_password(rs.getString("user_password"));
				u.setUser_phone(rs.getString("user_phone"));
				u.setUser_sex(rs.getString("user_sex"));
				list_user.add(u);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list_user;
	}
	
	
	//插入用户
	public int add_user(User u) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="INSERT INTO  `user`(`user_name`, `user_password`, `user_sex`, `user_phone`) VALUES (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUser_name());
			ps.setString(2, u.getUser_password());
			ps.setString(3, u.getUser_sex());
			ps.setString(4, u.getUser_phone());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//修改用户信息
	public int updateUserInfo(User u) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="update user set user_name=?,user_password=?,user_sex=?,user_phone=? where user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUser_name());
			ps.setString(2, u.getUser_password());
			ps.setString(3, u.getUser_sex());
			ps.setString(4, u.getUser_phone());
			ps.setInt(5, u.getUser_id());
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//通过id删除用户信息
	public void deleteUser(int user_id) {
		int count=0;
		try {
			conn=this.getConn();
			String sql="delete from user where user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//通过手机号模糊查询
	public List<User> findUserByPhone(String user_phone){
		List<User> list=new ArrayList<User>();
		try {
			conn=this.getConn();
			String sql="select * from user where user_phone like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+user_phone+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_password(rs.getString("user_password"));
				u.setUser_phone(rs.getString("user_phone"));
				u.setUser_sex(rs.getString("user_sex"));
				list.add(u);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//判断用户名是否存在
	public User isExist(String user_name) {
		User u=new User();
		try {
			conn=this.getConn();
			String sql="select * from user where user_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_name);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_password(rs.getString("user_password"));
				u.setUser_phone(rs.getString("user_phone"));
				u.setUser_sex(rs.getString("user_sex"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
