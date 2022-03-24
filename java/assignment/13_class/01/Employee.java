package com.test.java.obj.question;

class Employee {
	
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
		
		if (boss == null) {
			this.boss = boss;
		} else {
			if (department == boss.department) {
				this.boss = boss;
			} else {
				System.out.println("직속상사는 부서가 같아야 합니다.");
			}
		}
	}
	
	private boolean validTel(String tel) {
		
		if (tel.startsWith("010") 
				&& tel.length() == 13 
				&& tel.split("-").length == 3) {
			return true;
		}
		return false;
	}
	
	private boolean validPosition(String position) {
		
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
