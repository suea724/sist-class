package com.test.java.obj.question.q1;

class Employee {
	
	/*
	 	- Employee 객체의 정보
			- 이름, 부서, 직책, 연락처, 직속상사
		- 모든 멤버 변수의 접근 지정자는 private으로 한다.
		- 멤버 접근을 위한 Setter와 Getter를 정의한다.
			- 이름 : 읽기/쓰기, 한글 2~5자 이내
			- 부서 : 읽기/쓰기, 영업부, 기획부, 총무부, 개발부, 홍보부
			- 직책 : 읽기/쓰기, 부장, 과장, 대리, 사원
			- 연락처 : 읽기/쓰기, 010-XXXX-XXXX 형식 확인
			- 직속상사 : 읽기/쓰기, 다른 직원 중 한명, 같은 부서가 아니면 될 수 없음(유효성 검사)
		- Employee 객체 메소드
			- void info() : 직원 정보 확인
	 */
	
	private String name;
	private String department;
	private String position;
	private String tel;
	private Employee boss;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		if (validName(name)) {
			this.name = name;
		} else {
			System.out.println("올바르지 않은 이름입니다.");
		}
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		
		if (validDepartment(department)) {
			this.department = department;
		} else {
			System.out.println("부서가 유효하지 않습니다.");
		}
		
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		
		if (validPosition(position)) {
			this.position = position;
		} else {
			System.out.println("직책이 유효하지 않습니다.");
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		
		if (validTel(tel)) {
			this.tel = tel;
		} else {
			System.out.println("전화번호 형식이 올바르지 않습니다.");
		}
	}

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		
		// boss가 null일 경우 department X -> NPE
		// if문에서 boss != null 조건으로 설정하면 됨 (if-else X)
		if (boss != null) {
			if (department == boss.department) {
				this.boss = boss;
			} else {
				System.out.println("직속상사는 부서가 같아야 합니다.");
			}
		}
	}
	
	// 전화번호 유효성 체크
	private boolean validTel(String tel) {
		
		// charAt(), indexOf()로 하이픈 위치 잦아서 체크할 수도 있음
		// tel.indexOf(charAt('-')) == 3 && tel.indexOf(charAt('-')) == 8
		// tel.charAt(3) == '-' && tel.charAt(8) == '-'
		// 또는 하이픈을 replace()로 제거하고 길이가 11인지 체크하는 방법도 있다.
		// -> 하지만 replace()는 있을때는 제거하고 없을 때는 넘어가기 때문에 하이픈이 없을 때도 true를 반환할 수 있다.
		if (tel.startsWith("010") 
				&& tel.length() == 13 
				&& tel.split("-")[1].length() == 4
				&& tel.split("-")[2].length() == 4) {
			return true;
		}
		return false;
	}
	
	// 직책 유효성 체크
	private boolean validPosition(String position) {
		
		// if-esle문보다 switch-case문이 가독성이 더 좋은 것 같다.
		switch (position) {
			case "부장":
			case "과장":
			case "대리":
			case "사원":
				return true;
			default:
				return false;
		}
	}
	
	// 부서 유효성 체크
	private boolean validDepartment(String department) {
		
		switch (department) {
			case "영업부":
			case "기획부":
			case "총무부":
			case "개발부":
			case "홍보부":
				return true;
			default:
				return false;
		}
	}
	
	// 이름 유효성 체크
	private boolean validName(String name) {
		
		if (name.length() < 2 || name.length() > 5) {
			return false;
		}
		
		for (int i = 0 ; i < name.length() ; i ++) {
			char c = name.charAt(i);
			
			if (c < '가' || c > '힣') {
				return false;
			}
		}
		return true;
	}

	public void info() {
		System.out.printf("[%s]\n", name);
		System.out.println("- 부서: " + department);
		System.out.println("- 직책: " + position);
		System.out.println("- 연락처: " + tel);
		System.out.println("- 직속상사: " 
		+ ((boss == null) ? "없음" : String.format("%s(%s %s)", boss.name, boss.department, boss.position)));
		System.out.println();
	}

}
