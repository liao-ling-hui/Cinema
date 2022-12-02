package com.hndysf.service;

import com.hndysf.dao.AdminDao;
import com.hndysf.entity.Admin;

public class AdminService {
	private AdminDao adao=new AdminDao();
	

	//通过账号和密码登录
	public Admin loginAdmin(String name,String password) {
		Admin admin=new Admin();
		try {
			admin=adao.loginAdmin(name, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

}
