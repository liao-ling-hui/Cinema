package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hndysf.entity.Admin;

public class AdminDao extends BaseDao {
	private Connection conn=null;  
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	//通过账号和密码登录
	public Admin loginAdmin(String name,String password) {
		Admin admin=new Admin();
		try {
			conn=this.getConn();
			String sql="select * from admin where name=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
