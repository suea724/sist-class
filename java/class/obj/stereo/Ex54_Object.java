package com.test.java.obj.stereo;

import java.util.Calendar;
import java.util.Date;

public class Ex54_Object {

	public static void main(String[] args) {
		
		// 업캐스팅
		SSS s1 = new TTT();
		
		// [Object형 변수]
		// 1. 모든 것을 담을 수 있음
		// 2. 변수에 값을 수정할 때는 같은 데이터형으로만 수정하는 것이 좋음 > if not, 형변환하는 경우에 헷갈림
		
		// [Object 클래스 장점]
		// - 모든 클래스는 Object 클래스로 업 캐스팅할 수 있음 > 만능
		Object o1 = new SSS();
		Object o2 = new TTT();
		Object o3 = new Date();
		Object o4 = Calendar.getInstance();
		Object o5 = new G304();
		
		// [Object 클래스 단점]
		// - 다운 캐스팅이 종종 필요하다.
		// - 다운 캐스팅을 하기 위해서 원래 자료의 자료형을 유추하기 힘들다.
		System.out.println(o4);
		
		// [값형 변수를 참조형 변수에 어떻게 넣느냐?!]
		// - 주솟값을 저장하는 변수에는 주솟값만, 리터럴을 저장하는 변수에는 리터럴만
		// - Wrapper Class(Util)
		// - 값이 int이면 Integer 클래스로 객체를 상성한다. new Integer(10)
		// 		=> Boxing: 값형 데이터를 자동으로 객체로 만드는 작업
		// - 참조 변수에 저장되는 값은 데이터를 감싼 Wrapper 클래스의 주솟값이 들어간다.
		Object o6 = 100;
		System.out.println(o6.getClass()); // Integer
		// System.out.println(o6 * 2); (주솟값 * 데이터) => 불가능
		
		System.out.println((int)o6 * 2);
		System.out.println((Integer)o6 * 2);
		
	}

}

class SSS {
	
}

class TTT extends SSS {
	
}