package com.tcs.ilp.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.bean.TicketBean;

import com.tcs.ilp.utility.ConnectionManager;

public class UpdateTicketImpl {

	

	public ArrayList<TicketBean> updateUser(TicketBean tb){
		
		
		int ticketid = tb.getTicketId();
		String ttype = tb.getTicketType();
		String tassignedto = tb.getTicketAssignedTo();
		String tstatus = tb.getTicketStatus();
		String[] checkbox = tb.getCheckbox();
		ArrayList<TicketBean> ticketArrUpdate = new ArrayList<TicketBean>();
		
		
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
		
			StringBuffer queryString = new StringBuffer("SELECT T.TICKET_ID, T.TICKET_TYPE, T.TICKET_DESC, T.TICKET_STATUS, T.ASSIGNED_TO FROM TCK_TICKET T WHERE 1=1 AND T.STATUS = 'A'");
			
			if(ticketid != 0)
				queryString = queryString.append(" AND T.TICKET_ID = '"+ticketid+"'");
			
			if(ttype != null)
				queryString = queryString.append(" AND T.TICKET_TYPE = '"+ttype+"'");
			
			if(tassignedto != null)
				queryString = queryString.append(" AND T.ASSIGNED_TO = '"+tassignedto+"'");
			
			if(tstatus!= null)
				queryString = queryString.append(" AND T.TICKET_STATUS = '"+tstatus+"'");
			
			if(checkbox != null)
				queryString = queryString.append(" AND T.ASSIGNED_TO = ''");
		
			
				System.out.println("Query string = "+queryString);
				rset = stmt.executeQuery(queryString.toString());
				
			
				
			while(rset.next()){
				TicketBean ticketBean = new TicketBean();
				ticketBean.setTicketId(rset.getInt("ticket_id"));
				ticketBean.setTicketType(rset.getString("ticket_type"));
				ticketBean.setTicketDesc(rset.getString("ticket_desc"));
				ticketBean.setTicketStatus(rset.getString("ticket_status"));
				ticketBean.setTicketAssignedTo(rset.getString("assigned_to"));
				
				ticketArrUpdate.add(ticketBean);
								
				}
			System.out.println("ticketArr Size == "+ticketArrUpdate.size());
					
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
		return ticketArrUpdate;
		
	}
	
	public String updateTable(TicketBean tb) {
		
		
				ConnectionManager connManager = new ConnectionManager();		
				Connection conn = null;
				PreparedStatement ps = null;
				try{
					try {
							conn = connManager.getConnection();
						} catch (ClassNotFoundException e) {				
							e.printStackTrace();
						}
					
						String query = "UPDATE TCK_TICKET SET TICKET_TYPE=?, TICKET_DESC=?, TICKET_STATUS=?, ASSIGNED_TO=? WHERE TICKET_ID=?";
						ps=conn.prepareStatement(query);
						ps.setString(1, tb.getTicketType());
						ps.setString(2, tb.getTicketDesc());
						ps.setString(3, tb.getTicketStatus());
						ps.setString(4, tb.getTicketAssignedTo());
						ps.setInt(5, tb.getTicketId());
						
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
		return "error";
	}
}
