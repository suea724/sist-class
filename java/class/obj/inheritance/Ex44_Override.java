package com.test.java.obj.inheritance;

public class Ex44_Override {

	public static void main(String[] args) {
		
		/**
		 * [오버로딩 vs 오버라이드]
		 * - 메서드 오버로딩
		 * 		- 메서드 이름 동일 x N개 생성 > 인자리스트를 다르게 해서
		 * - 메서드 오버라이드
		 * 		- 메서드 재정의
		 * 		- 클래스 상속시 발생
		 * 
		 * [오버라이드]
		 * - 상속관계에 있는 클래스가 같은 목적을 가지는 메서드를 구현할 때 메서드의 시그니처를 동일하게 만드는 것이 좋음!
		 * - 부모로부터 물려받은 메서드와 동일한 메서드를 자식 클래스에서 다시 선언하는 행동
		 * - 부모 메서드와 자식 메서드가 동일하게 2개 존재하게 된다. > 자식이 선언한 메서드가 호출됨
		 * 
		 * [포인트]
		 * 1. 자식 클래스가 상속받은 부모의 메서드를 그대로 사용하기 싫다
		 * 		- 상속은 거부할 수 없다. 무조건 100% 진행
		 * 2. 상속 관계에 있는 클래스의 객체들은 대부분 공통된 사용법(메서드)을 가진다.
		 * 		- 스스로 다른 형식의 메서드 생성 > 규칙 파괴
		 * 3. 겉으로 보기엔 부모의 메서드와 동일한데 내용물만 바뀐 메서드를 만들자!
		 */
		
		// 길을 가다가.. 마주쳤따..
		OverrideParent p1 = new OverrideParent();
		p1.name = "sue";
		p1.hello();
		
		OverrideChild c1 = new OverrideChild();
		c1.name = "kim";
		c1.hello(); // 오버라이딩 => 사용법 통일
		
	}

}

class OverrideParent {
	
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", this.name);
	}
}

class OverrideChild extends OverrideParent {
	
	@Override // Annotation, 애노테이션 (프로그래밍 기능)
	public void hello() {  
		System.out.printf("안녕! 난 %s\n", this.name);
	}
}