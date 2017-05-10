package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.bean.UserBean;
import com.tcs.ilp.utility.ConnectionManager;

public class CreateTicketImpl {

	public String createUser(TicketBean tb, UserBean ub){
		
		
		String ttype = tb.getTicketType();
		String tdesc = tb.getTicketDesc();
		String u = ub.getUsername();
		
		ConnectionManager connManager = new ConnectionManager();		
		
		
		
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			
			try {
				conn = connManager.getConnection();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
			String stmt = "INSERT INTO TCK_TICKET (TICKET_ID, TICKET_TYPE, TICKET_DESC, CREATED_BY, CREATED_DATE, STATUS, TICKET_STATUS) VALUES(nextval('TICKET_ID_seq'), ?, ?, ?, ?, ?, ?)";
			
			pst = conn.prepareStatement(stmt);
			pst.setString(1, ttype);
			pst.setString(2, tdesc);
			pst.setString(3, u);
			pst.setDate(4, new java.sql.Date((Calendar.getInstance()).getTime().getTime()));	 
			pst.setString(5, "A");
			pst.setString(6, "Open");
			pst.executeUpdate();
			
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

			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return "error";
	}
}
