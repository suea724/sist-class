package com.test.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01_RegEx {
	
	public static void main(String[] args) {
		
		/*
		
			���� ǥ����, Regular Expression
		   - Ư�� ������ ���ڿ��� �˻��ϴ� ǥ����(����)
		   
		   ���� ǥ���� �������
		   1. x
		   	- x�� ������ �ѹ���
		   	- ���� ����
		   	e.g. "a" > abc
		   
		   
		   2. ����Ƚ��
		   	- �ٷ� ���� ����(����)�� ���� Ƚ���� �ǹ�
		   
		   2.1 ����
		   	- �ٷ� �� ����� ���� Ƚ���� ���� X, �ߺ� X
		   	- ����Ƚ�� > 1
		   
		   2.2 ?
		   	- �ٷ� �� ����� ���� Ƚ���� ���� O, �ߺ� X
		   	- ����Ƚ�� > 0 ~ 1
		   	- e.g. "a?bc" > ab, abc, abbc, ac, bc, bbc, aaabc
		   	- e.g. "ȫ?�浿" > ���� �浿!
		   	- e.g. "�ڹ�?�ڵ�" > �ڹ��ڵ尡 �ֽ��ϴ�. �ڵ忡 ������ �ֳ׿�.
		   
		   2.3 +
		   	- �ٷ� �� ����� ���� Ƚ���� ���� X, �ߺ� O
		   	- ����Ƚ�� > 1 ~ ���Ѵ�
		   	- e.g. "a+bc" > ab, abc, abbc, ac, bc, bbc, aaabc
		   
		   2.4 *
		   	- �ٷ� �� ����� ���� Ƚ���� ���� O, �ߺ� O
		   	- ����Ƚ�� > 0 ~ ���Ѵ�
		   	- e.g. "a*bc" > ab, abc, abbc, ac, bc, bbc, aaabc
		   	- e.g. "ab?c+d" > abcd, bcd, abc, acd, abbcd, abccd, abcccc, acccddd
		   
		   3. ����
		   
		   3.1 [���Ű�]
		 	- e.g. "[123]" > 123. ���� 5�Դϴ�. ���̴� 21���Դϴ�. ����� 223�� �ֽ��ϴ�.
		 	- e.g. "[123]45" > 12345, 145, 245, 345, 45
		 	- e.g. "[123]?45" > 12345, 145, 245, 345, 45
		 	- e.g. "[123]+45" > 12345, 145, 245, 345, 45
		 	- e.g. "[123]*45" > 12345, 145, 245, 345, 45
		 	- e.g. "[0123456789]+" > 123. ���� 5�Դϴ�. ���̴� 21���Դϴ�. ����� 223�� �ֽ��ϴ�.
		 	- e.g. "[02468]", "[13579]+" > 2221 (��ã��)
		 	- e.g. "���ڸ� ����" > [0123456789][0123456789]
		 	- e.g. "��ȭ��ȣ �˻�"
		 
		 	- ���ӵ� ���ڸ� �����ϰ� ǥ���ϴ� ��� > �����ڵ� Ȱ��
		 		e.g. ���� > "[0123456789]" > "[0-9]"
		 		e.g. ���ҹ��� > "[abcdefghijklmnopqrstuvwxyz]" > "[a-z]"
		 		e.g. ���빮�� > "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]" > "[A-Z]"
		 		e.g. ������ > "[A-Za-z]"
		 		e.g. �ѱ� > "[��-�R]"
		 		e.g. ������ + ���� + �ѱ� > "[A-Za-z0-9��-�R]"
		 		
		 	3.2 [^���Ű�]
		 	- ���Ű��� ������ ���� �˻�
		 		e.g. [^0-9]
		 
		 	4. ����Ƚ��
		 	- �ٷ� ���� ����(����)�� ���� Ƚ���� �ǹ�
		 	- ?, +, * > �� ������ ���� ���� ����
		 
		 	4.1 {n}
				- n: ���� ���� Ƚ��
				ex) "a{1}bc" > ab, abc, abbc, ac, bc, bbc, aaabc
				ex) "a{3}bc" > ab, abc, abbc, ac, bc, bbc, aaabc
				
			4.2 {n,m}
				- n: �ּ� ���� Ƚ��
				- m: �ִ� ���� Ƚ��
				ex) "a{1,3}bc" > ab, abc, abbc, ac, bc, bbc, aaabc, aabc, aaaaaaabc
			
			4.3 {n,}
				- n: �ּ� ���� Ƚ��
				- �ִ� ���� Ƚ�� ���Ѵ�
		 	
		 	ex) ��ȭ��ȣ: "010-[0-9]{4}-[0-9]{4}"
			ex) �ֹι�ȣ: "[0-9]{6}-[0-9]{7}"
			ex) �ֹι�ȣ: "[0-9]{6}-{0,1}[0-9]{7}"
			ex) �ֹι�ȣ: "[0-9]{6}-?[0-9]{7}"
		 	
		 	ex) ����ܾ�(3����): "[A-Za-z]{3}"
				
			ex) ��ȭ��ȣ: "010-[0-9]{3,4}-[0-9]{4}"
				010-123-4567
				010-1234-5678
				
			ex) 1���� �̻� ��� ����ܾ�: "[A-Za-z]{1,}" or "[A-Za-z]+"
			ex) 2���� �̻� ��� ����ܾ�: "[A-Za-z]{2,}" or "[A-Za-z][A-Za-z]+"
			ex) 3���� �̻� ��� ����ܾ�: "[A-Za-z]{3,}" or "[A-Za-z][A-Za-z][A-Za-z]+"
			
			
			5. ó���� ��
			- �Է� ��Ʈ��(�ؽ�Ʈ �ڽ�)�� ������� ��� 
			
			5.1 ^
				- ���� ǥ������ �ݵ�� ����
				- str.startsWith()
				ex) "^ȫ�浿" > ��� ���ڿ��� 'ȫ'���� �����ϸ� ã�ƶ�!!
			
			5.2 $
				- ���� ǥ������ �ݵ�� ��
				- str.endsWith()
				ex) "ȫ�浿$" > ��� ���ڿ��� '��'���� ������ ã�ƶ�!!!
		
			
			6. ����ǥ��
				
			6.1 \d or \D
				- Digital > ����
				- \d > [0-9]
				- \D > [^0-9]
				
				ex) [0-9]{3}-[0-9]{3,4}-[0-9]{4}
				    \d{3}-\d{3,4}-\d{4}
				    
				    "\d+"
				    "\D+"
			
			6.2 \s or \S
				- ���鹮��(�����̽�, ��, ����)
				
				ex) "\s+", "\S+"
				
				ex) "ȫ\s?�浿"
				
				ȫ�浿, ȫ  �浿, ȫ �浿
			
			6.3 \w or \W
				- word(���� ��ҹ��� + ���� + '_')
				
				ex) "\w{3,5}"
			
		*/
	}
	
	private static void m3() {
		
		String txt = "�ȳ��ϼ���. ���� ȫ�浿�Դϴ�. hong@gmail.com ��? ��� �̸��� �浿�̳׿�? test_123@naver.com ��浿�̳׿�. pinn.public@gmail.com ���ʿ� �ֱ浿�� �־��. �Ѹ� �� �ֳ׿�~ ���ñ浿�̵� �ֽ��ϴ�.";
		
		//http://regexlib.com
		
		String regex = "(\\w+)@([a-zA-Z_]+?\\.[a-zA-Z]{2,3})";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		while (m1.find()) {
			System.out.println("�̸���: " + m1.group());
			System.out.println("���̵�: " + m1.group(1));
			System.out.println("������: " + m1.group(2));
			System.out.println();
		}
		
	}

	private static void m2() {
		
		String txt = "�ȳ��ϼ���. ���� ȫ�浿�Դϴ�. ��? ��� �̸��� �浿�̳׿�? ��浿�̳׿�. ���ʿ� �ֱ浿�� �־��. �Ѹ� �� �ֳ׿�~ ���ñ浿�̵� �ֽ��ϴ�.";
		
		//1. ��� �浿�� ã��!!
		
		//String regex = "([ȫ����])?�浿";
		String regex = "(ȫ|��|��|����)?�浿";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		
		while (m1.find()) {
			System.out.println("ã�� �̸�: " + m1.group());
			System.out.println("����: " + m1.group(1));
			System.out.println("����: " + m1.group().substring(0, 1));
			System.out.println();
		}
		
		
	}

	private static void m1() {
		
		String txt = "�ȳ��ϼ���. ȫ�浿�Դϴ�. 010-1234-5678 ���� ���� ǥ������ �����ϴ� ���Դϴ�. 010-8547-9854 �ۿ� �� �����ϴ�. 010-652-9854 �谡 ���Ŵϴ�.";
		
		//1. txt �ȿ� ��ȭ��ȣ�� �ִ��� ����?
		
		//String regex = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		String regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		
		//���Խ��� ����ϴ� �˻� ���� > Pattern
		Pattern p1 = Pattern.compile(regex);
		
		//�˻� ��� > Matcher
		Matcher m1 = p1.matcher(txt);
		
		//System.out.println(m1.find());
		
//		if (m1.find()) {
//			System.out.println("txt���� ��ȭ��ȣ�� �߰ߵǾ����ϴ�.");
//		} else {
//			System.out.println("txt���� ��ȭ��ȣ�� �����ϴ�.");
//		}
		
		
		while (m1.find()) {
			System.out.println("��ȭ��ȣ�� �߰��߽��ϴ�.");
			System.out.println(m1.group());
			System.out.println("��ü ���ڿ�: " + m1.group(0));
			System.out.println("ù��° ��ȣ(��Ż�): " + m1.group(1));
			System.out.println("�ι�° ��ȣ(���ڸ�): " + m1.group(2));
			System.out.println("�¹�° ��ȣ(���ڸ�): " + m1.group(3));
			System.out.println();
		}
		
	}
	

}
