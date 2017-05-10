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

public class TTypeConfigImpl {

	ConnectionManager connManager = new ConnectionManager();		
	
	
	ResultSet rset = null;		
	Connection conn = null;
	PreparedStatement ps = null;
	
	
	public ArrayList<TicketBean> tTypeConfig(TicketBean tb){

		
		
		String ttype = tb.getTicketType();
		String status = tb.getStatus();
		
		ArrayList<TicketBean> ticketArr = new ArrayList<TicketBean>();
		Statement stmt = null;
		
		try {
			try {
				conn = connManager.getConnection();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
			
			stmt = conn.createStatement();	
		
			StringBuffer queryString = new StringBuffer("SELECT T.TICKET_TYPE_ID, T.TICKET_TYPE, T.STATUS, T.CREATED_BY, T.CREATED_DATE, T.UPDATED_BY, T.UPDATED_DATE FROM TCK_TYPE_MST T WHERE 1=1");
			
			if(ttype != null)
				queryString = queryString.append(" AND T.TICKET_TYPE = '"+ttype+"'");
						
			if(status != null)
				queryString = queryString.append(" AND T.TICKET_TYPE = '"+status+"'");
				System.out.println("Query string = "+queryString);
				rset = stmt.executeQuery(queryString.toString());
				
			
				
			while(rset.next()){
				TicketBean ticketBean = new TicketBean();
				ticketBean.setTicketTypeId(rset.getInt("ticket_type_id"));
				ticketBean.setTicketType(rset.getString("ticket_type"));
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
	//If add button is called
		public String tTypeAdd(TicketBean tb, UserBean ub){
			
			String ttype = tb.getTicketType();
			String username = ub.getUsername();
			try{
				
				try {
						conn = connManager.getConnection();
					}catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			//stmt = conn.createStatement();	
			String query = "INSERT INTO TCK_TYPE_MST (TICKET_TYPE_ID, TICKET_TYPE, STATUS, CREATED_BY, CREATED_DATE) VALUES(nextval('TICKET_TYPE_ID_seq'), ?, ?, ?, ?)";
			ps=conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ttype);
			ps.setString(2, "A");
			ps.setString(3, username);
			ps.setDate(4, new java.sql.Date((Calendar.getInstance()).getTime().getTime()) );
			ps.executeUpdate();
			
			System.out.println("Add Query == "+ps);
			
			return "Success";
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		
			finally{
				
				try {
				//	stmt.close();
					conn.close();
				//	rset.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			return "Error";
		}
		//if remove button is called
	public String tTypeRemove(TicketBean tb){
			
			String ttype = tb.getTicketType();
			try{
				
				try {
						conn = connManager.getConnection();
					}catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			//stmt = conn.createStatement();	
			String query = "UPDATE TCK_TYPE_MST SET STATUS = 'I' WHERE TICKET_TYPE = ?";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ttype);
			ps.executeUpdate();
			rset = ps.getGeneratedKeys();
			System.out.println("Remove Query == "+ps);
			
			return "Success";
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		
			finally{
				
				try {
				//	stmt.close();
					conn.close();
					//rset.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			return "Error";
		}
		//If update button is called
		public String tTypeUpdate(TicketBean tb, UserBean ub){
			
			String ttype = tb.getTicketType();
			String username = ub.getUsername();
			int ttypeid = tb.getTicketTypeId();
			String status = tb.getStatus();
			try{
				
				try {
						conn = connManager.getConnection();
					}catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		//	stmt = conn.createStatement();	
			String query = "UPDATE TCK_TYPE_MST SET TICKET_TYPE = ?, STATUS = ?, UPDATED_BY = ?, UPDATED_DATE = ? WHERE TICKET_TYPE_ID = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ttype);
			ps.setString(2, status);
			ps.setString(3, username);
			ps.setDate(4, new java.sql.Date((Calendar.getInstance()).getTime().getTime()) );
			ps.setInt(5, ttypeid);
			ps.executeUpdate();
			
			System.out.println("Update Query == "+ps);
			
			return "Success";
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		
			finally{
				
				try {
		//			stmt.close();
					conn.close();
					rset.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			return "Error";
		}
}
