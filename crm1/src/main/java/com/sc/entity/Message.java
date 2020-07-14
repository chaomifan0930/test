package com.sc.entity;

import java.io.Serializable;

public class Message implements Serializable{

	private String msgCode;//消息代号
	private String msgStatus;//消息状态
	private String msgContent;//消息内容
	
	public Message(String msgCode, String msgStatus, String msgContent) {
		super();
		this.msgCode = msgCode;
		this.msgStatus = msgStatus;
		this.msgContent = msgContent;
	}
	
	public Message() {
		super();
	}
	
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	
	@Override
	public String toString() {
		return "Message [msgCode=" + msgCode + ", msgStatus=" + msgStatus + ", msgContent=" + msgContent + "]";
	}
	
	
}
