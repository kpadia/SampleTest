package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.tcs.ilp.bean.UserBean;
import com.tcs.ilp.utility.ConnectionManager;

public class LoginImpl {

	

	public String validateUser(UserBean ub){
		
		
		String username = ub.getUsername();
		String password = ub.getPassword();
		String usertype = ub.getUserType();
		
		ConnectionManager connManager = new ConnectionManager();		
		
		Statement stmt = null;
		ResultSet rset = null;		
		Connection conn = null;
		try {
			
			try {
				conn = connManager.getConnection();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
			stmt = conn.createStatement();				
			String queryString = "SELECT T.USER_NAME, T.PASSWORD, T.USER_TYPE FROM TCK_USERS T WHERE T.USER_NAME = '"+username+"' AND T.PASSWORD = '"+password+"' AND T.USER_TYPE = '"+usertype+"'";
			System.out.println("Query string = "+queryString);
			rset = stmt.executeQuery(queryString);
			if(rset.next()){
				System.out.println("UserTYpe = "+usertype);
				return "Success";
			}else{
				return "NODATAFOUND";
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return "error";
	}
}
