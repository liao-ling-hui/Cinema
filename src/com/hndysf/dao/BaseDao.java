package com.hndysf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {
	private Connection conn=null;  
	private PreparedStatement pstat=null;
	private ResultSet rs=null;
	
	
		public Connection getConn() throws SQLException {
			ComboPooledDataSource ds=new ComboPooledDataSource();
			conn=ds.getConnection();
			return conn;
		}
		
		
	
		
		public void closeAll() {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstat!=null) {
				try {
					pstat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
}
