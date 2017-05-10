package com.tcs.ilp.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcs.ilp.bean.TicketBean;

import com.tcs.ilp.utility.ConnectionManager;

public class SearchTicketImpl {

	

	public ArrayList<TicketBean> searchUser(TicketBean tb){
		
		
		int ticketid = tb.getTicketId();
		String ttype = tb.getTicketType();
		String tstatus = tb.getTicketStatus();
		String tassignedto = tb.getTicketAssignedTo();
		String[] checkbox = tb.getCheckbox();
		ArrayList<TicketBean> ticketArrSearch = new ArrayList<TicketBean>();
		
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
			
			if(tstatus != null)
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
				
				ticketArrSearch.add(ticketBean);
								
				}
			
			for(TicketBean ticketbean : ticketArrSearch)
			{	
				
				
				System.out.println("Ticketid = "+ticketbean.getTicketId());
				System.out.println("Tickettype = "+ticketbean.getTicketType());
				System.out.println("Ticketdesc = "+ticketbean.getTicketDesc());
				System.out.println("Ticketstatus= "+ticketbean.getTicketStatus());
				System.out.println("TicketassignedTo = "+ticketbean.getTicketAssignedTo());
				
				
			}
			
				
			
			System.out.println("ticketArr = "+ticketArrSearch.size());
			
			
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
		return ticketArrSearch;
		
	}

}
