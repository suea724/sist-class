package com.test.spring.aop;

public interface Memo {
	
	// �޸� ����
	void add(String memo);
	
	// �޸� �б�
	String read(int seq);
	
	// �޸� �����ϱ�
	boolean edit(int seq, String memo);
	
	// �޸� �����ϱ�
	boolean del(int seq);

}
