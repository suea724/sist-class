package com.test.jsp;

public class TodoDto {
	
	private String seq;
	private String todo;
	private String regdate;
	private String priority;
	private String complete;
	
	public String getSeq() {
		return seq;
	}
	
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	public String getTodo() {
		return todo;
	}
	
	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getComplete() {
		return complete;
	}
	
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	public TodoDto(String seq, String todo, String regdate, String priority, String complete) {
		super();
		this.seq = seq;
		this.todo = todo;
		this.regdate = regdate;
		this.priority = priority;
		this.complete = complete;
	}

}
