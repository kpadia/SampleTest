package com.tcs.ilp.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.bean.UserBean;

import com.tcs.ilp.utility.ConnectionManager;

public class TStatusConfigImpl {

	ConnectionManager connManager = new ConnectionManager();		
	
	Statement stmt = null;
	ResultSet rset = null;		
	Connection conn = null;
	PreparedStatement ps = null;
	

	public ArrayList<TicketBean> tStatusConfig(TicketBean tb){
		
		String tstatus = tb.getTicketStatus();
		String status = tb.getStatus();
		
		
		ArrayList<TicketBean> ticketArr = new ArrayList<TicketBean>();
		
		
		try {
			
			try {
				conn = connManager.getConnection();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
			stmt = conn.createStatement();	
		
			StringBuffer queryString = new StringBuffer("SELECT T.TICKET_STATUS_ID, T.TICKET_STATUS, T.STATUS, T.CREATED_BY, T.CREATED_DATE, T.UPDATED_BY, T.UPDATED_DATE FROM TCK_STATUS_MST T WHERE 1=1");
			
			if(tstatus != null)
				queryString = queryString.append(" AND T.TICKET_STATUS = '"+tstatus+"'");
			
			if(status!= null)
				queryString = queryString.append(" AND T.STATUS = '"+status+"'");
			
				System.out.println("Query string = "+queryString);
				rset = stmt.executeQuery(queryString.toString());
				
			
				
			while(rset.next()){
				TicketBean ticketBean = new TicketBean();
				ticketBean.setTicketStatusId(rset.getInt("ticket_status_id"));
				ticketBean.setTicketStatus(rset.getString("ticket_status"));
				ticketBean.setStatus(rset.getString("status"));
				ticketBean.setTicketCreatedBy(rset.getString("created_by"));
				ticketBean.setTicketCreatedDate(rset.getDate("created_date"));
				ticketBean.setTicketUpdateBy(rset.getString("updated_by"));
				ticketBean.setTicketUpdatedDate(rset.getDate("updated_date"));
				
				ticketArr.add(ticketBean);
								
				}
			System.out.println("ticketArr = "+ticketArr.size());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		finally{
			
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return ticketArr;
	}
	public String tStatusAdd(TicketBean tb, UserBean ub){
		String tstatus = tb.getTicketStatus();
		String username = ub.getUsername();
	try{
		try {
				conn = connManager.getConnection();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
		
			String query = "INSERT INTO TCK_STATUS_MST (TICKET_STATUS_ID, TICKET_STATUS, STATUS, CREATED_BY, CREATED_DATE) VALUES(nextval('TICKET_STATUS_ID_seq'), ?, ?, ?, ?)";
			ps=conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tstatus);
			ps.setString(2, "A");
			ps.setString(3, username);
			ps.setDate(4, new java.sql.Date((Calendar.getInstance()).getTime().getTime()) );
			ps.executeUpdate();
			rset = ps.getGeneratedKeys();
			if(rset != null && rset.next())
				System.out.println("Ticket Status Id = "+rset.getString(1));
		    System.out.println("Addition Query :: "+ps);
		    return "Success";
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		try {
				conn.close();
				ps.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
}
return "Error";
}
	public String tStatusRemove(TicketBean tb){
		String tstatus = tb.getTicketStatus();
		
		try{
			try {
					conn = connManager.getConnection();
				} catch (ClassNotFoundException e) {				
					e.printStackTrace();
				}
			
				String query = "UPDATE TCK_STATUS_MST SET STATUS ='I' WHERE TICKET_STATUS=?";
				ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, tstatus);
				ps.executeUpdate();
				rset = ps.getGeneratedKeys();
				if(rset !=null && rset.next()){
					System.out.println("Ticket status id == "+rset.getInt(1));
				}
			    System.out.println("Query :: "+ps);
			    return "Success";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try {
					conn.close();
					ps.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
	}
	return "Error";
	}
	public String tStatusUpdate(TicketBean tb, UserBean ub){
		
		String tstatus = tb.getTicketStatus();
		String status = tb.getStatus();
		String username = ub.getUsername();
		int tstatusid = tb.getTicketStatusId();
		try{
			try {
					conn = connManager.getConnection();
				} catch (ClassNotFoundException e) {				
					e.printStackTrace();
				}
			
				String query = "UPDATE TCK_STATUS_MST SET TICKET_STATUS = ?, STATUS = ?, UPDATED_BY = ?, UPDATED_DATE = ? WHERE TICKET_STATUS_ID = ?";
				ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,  tstatus);
				ps.setString(2, status);
				ps.setString(3, username);
				ps.setDate(4, new java.sql.Date((Calendar.getInstance()).getTime().getTime()) );
				ps.setInt(5, tstatusid);
				
			    ps.executeUpdate();
			    
			    System.out.println("Query :: "+ps);
			    return "Success";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try {
					conn.close();
					ps.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
	}
	return "Error";
	}
}
