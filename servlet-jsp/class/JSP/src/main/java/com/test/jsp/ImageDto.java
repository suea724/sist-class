package com.test.jsp;

public class ImageDto {
	
	private String seq;
	private String fileName;
	private String subject;
	private String regdate;
	
	public String getSeq() {
		return seq;
	}
	
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public ImageDto(String seq, String fileName, String subject, String regdate) {
		super();
		this.seq = seq;
		this.fileName = fileName;
		this.subject = subject;
		this.regdate = regdate;
	}
}
