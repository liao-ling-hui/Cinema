package com.hndysf.service;

import java.util.ArrayList;
import java.util.List;

import com.hndysf.dao.UserDao;
import com.hndysf.entity.User;
import com.hndysf.exception.LoginException;
import com.hndysf.exception.RegisterException;

public class UserService {

	private UserDao uDao=new UserDao();
	
	//用户名登录
	public User login_name(String name,String password) {
		User u=new User();
		try {
			u=uDao.login_name(name, password);
			if(u==null) {
				throw new LoginException("登录账号异常");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	//手机号登录
	public User login_phone(String phone,String password) {
		User u=new User();
		try {
			u=uDao.login_phone(phone, password);
			if(u==null) {
				throw new LoginException("登录手机号异常！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	//添加用户
	public int addUser(User u) {
		int count=0;
		try {
			count=uDao.addUser(u);
			if(count<0) {
				throw new RegisterException("注册异常！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	//通过用户id查询用户基本信息
		public User findUserById(int user_id) {
			User u=new User();
			try {
				u=uDao.findUserById(user_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return u;
		}
		
		
		
		//通过id修改密码或性别
		public  int updatePwdOrSexById(String pwd,String sex,int user_id) {
			int count=0;
			try {
				count=uDao.updatePwdOrSexById(pwd, sex, user_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		
		//后台功能模块
		
		//查询所有用户信息
		public List<User> findUser(){
			List<User> list_user=new ArrayList<User>();
			try{
				list_user=uDao.findUser();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list_user;
		}
		
		
		//插入用户
		public int add_user(User u) {
			int count=0;
			try {
				count=uDao.add_user(u);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		//修改用户信息
		public int updateUserInfo(User u) {
			int count=0;
			try {
				count=uDao.updateUserInfo(u);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		
		
		//通过id删除用户信息
		public void deleteUser(int user_id) {
			
			try {
				uDao.deleteUser(user_id);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		//通过手机号模糊查询
		public List<User> findUserByPhone(String user_phone){
			List<User> list=new ArrayList<User>();
			try {
				list=uDao.findUserByPhone(user_phone);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		
		//判断用户名是否存在
		public User isExist(String user_name) {
			User u=new User();
			try {
				u=uDao.isExist(user_name);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return u;
		}
}
