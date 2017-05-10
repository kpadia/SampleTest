package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;


import com.tcs.ilp.bean.UserBean;
import com.tcs.ilp.utility.ConnectionManager;

public class RegisterImpl {

	public String registerUser(UserBean ub){
		
		
		String username = ub.getUsername();
		String password = ub.getPassword();
		String name = ub.getName();
		String usertype = ub.getUserType();
		String email = ub.getEmail();
		String contact = ub.getContact();
		
		
		System.out.println("userName = "+username);
		ConnectionManager connManager = new ConnectionManager();		
		
		
			
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		try {
			
			try {
				conn = connManager.getConnection();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
				
			String stmt = "INSERT INTO TCK_USERS (USER_ID, PASSWORD, USER_NAME, NAME, USER_TYPE, EMAIL_ID, CONTACT_NO, CREATED_BY, CREATED_DATE) VALUES (nextval('USER_ID_seq'), ?, ?, ?, ?, ?, ?, ?, ?)";
	     
	        pst = conn.prepareStatement(stmt, Statement.RETURN_GENERATED_KEYS);
	        pst.setString(1,password);
	        pst.setString(2,username);
	        pst.setString(3,name);
	        pst.setString(4,usertype);
	        pst.setString(5,email);
	        pst.setString(6,contact);
	        pst.setString(7,username);
	        pst.setDate(8,new java.sql.Date((Calendar.getInstance()).getTime().getTime()));	        
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			
			if(rs != null && rs.next())
				System.out.println("User Id = "+rs.getString(1));
			
			System.out.println("Query string = "+pst);
				return "Success";
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                	rs.close();
                }

			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return "error";
	}
}
