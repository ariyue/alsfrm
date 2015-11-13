package com.als.lcs.u;

/**
 * license Bean
 * @author Vincent
 *
 */
public class L {

	private static final String S;
	private static final String L;
	private static final String A;
	
	
	private String ipAddress;
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getIssuedTime() {
		return issuedTime;
	}
	public void setIssuedTime(String issuedTime) {
		this.issuedTime = issuedTime;
	}
	public String getNotBeforeTime() {
		return notBeforeTime;
	}
	public void setNotBeforeTime(String notBeforeTime) {
		this.notBeforeTime = notBeforeTime;
	}
	public String getNotAfterTime() {
		return notAfterTime;
	}
	public void setNotAfterTime(String notAfterTime) {
		this.notAfterTime = notAfterTime;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	private String macAddress;
	private String issuedTime;
	private String notBeforeTime;
	private String notAfterTime;
	private String userType;//developer: 开发; user: 发布
	private String info;
	private String signature;
	private String userName;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String toString(){
		//return  "┣" +  this.macAddress + "┫┣" + this.ipAddress +"┫"+ S +"┣" + this.issuedTime + "┫┣" +this.notBeforeTime +"┫┣" + this.notAfterTime +"┫"+ L +"┣" + this.userType+"┫┣" + this.userName + A  + "┫";
		
		return  "|" +  this.macAddress + "||" + this.ipAddress +"|"+ S +"|" + this.issuedTime + "||" +this.notBeforeTime +"||" + this.notAfterTime +"|"+ L +"|" + this.userType+"||" + this.userName + A  + "|";
	}
	
	static {
		S = "S";
		L = "L";
		A = "A";
	}
	
}
