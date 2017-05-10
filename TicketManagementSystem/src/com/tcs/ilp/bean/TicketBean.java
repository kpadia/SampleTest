package com.tcs.ilp.bean;

import java.awt.Checkbox;
import java.util.Date;

public class TicketBean {
	public int ticketid;
	public String ticketType;
	public String ticketDesc;
	public String ticketStatus;
	public String status;
	public String ticketComments;
	public String ticketAssignedTo;
	public String ticketCreatedBy;
	public Date ticketCreatedDate;
	public String ticketUpdateBy;
	public Date ticketUpdatedDate;
	public int ticketSubscriberUID;
	public int ticketStatusId;
	public int ticketTypeId;
	public String[] checkbox;

	
	
	
	public String[] getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
	public int getTicketStatusId() {
		return ticketStatusId;
	}
	public void setTicketStatusId(int ticketStatusId) {
		this.ticketStatusId = ticketStatusId;
	}
	public int getTicketTypeId() {
		return ticketTypeId;
	}
	public void setTicketTypeId(int ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
	public int getTicketId() {
		return ticketid;
	}
	public void setTicketId(int ticketid) {
		this.ticketid = ticketid;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicketDesc() {
		return ticketDesc;
	}
	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTicketComments() {
		return ticketComments;
	}
	public void setTicketComments(String ticketComments) {
		this.ticketComments = ticketComments;
	}
	public String getTicketAssignedTo() {
		return ticketAssignedTo;
	}
	public void setTicketAssignedTo(String ticketAssignedTo) {
		this.ticketAssignedTo = ticketAssignedTo;
	}
	public String getTicketCreatedBy() {
		return ticketCreatedBy;
	}
	public void setTicketCreatedBy(String ticketCreatedBy) {
		this.ticketCreatedBy = ticketCreatedBy;
	}
	public Date getTicketCreatedDate() {
		return ticketCreatedDate;
	}
	public void setTicketCreatedDate(Date ticketCreatedDate) {
		this.ticketCreatedDate = ticketCreatedDate;
	}
	public String getTicketUpdateBy() {
		return ticketUpdateBy;
	}
	public void setTicketUpdateBy(String ticketUpdateBy) {
		this.ticketUpdateBy = ticketUpdateBy;
	}
	public Date getTicketUpdatedDate() {
		return ticketUpdatedDate;
	}
	public void setTicketUpdatedDate(Date ticketUpdatedDate) {
		this.ticketUpdatedDate = ticketUpdatedDate;
	}
	public int getTicketSubscriberUID() {
		return ticketSubscriberUID;
	}
	public void setTicketSubscriberUID(int ticketSubscriberUID) {
		this.ticketSubscriberUID = ticketSubscriberUID;
	}
	

}
