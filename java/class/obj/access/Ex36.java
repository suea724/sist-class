package com.test.java.obj.access;

public class Ex36 {

	public static void main(String[] args) {
		
		/**
		 * 클래스 멤버 변수에 배열이 있을 때 setter 생성
		 */
		
		// 컴퓨터
		// - CPU
		// - MainBoard
		// - Memory
		// - Storage
		
		CPU cpu = new CPU();
		cpu.setModel("Intel i5");
		cpu.setSpeed("1.8");
		
		MainBoard mainBoard = new MainBoard();
		mainBoard.setModel("M5000");
		
		Storage storage = new Storage();
		storage.setModel("SM");
		storage.setType("SSD");
		storage.setSize(500);
		
		Computer computer = new Computer();
		computer.setCpu(cpu);
		computer.setMainBoard(mainBoard);
		computer.setStorage(storage);
		
//		// Memory가 들어갈 수 있는 공간만 할당
//		Memory[] mlist = new Memory[2]; 
//		
//		// 메모리 배열에 입력
//		mlist[0] = new Memory();
//		mlist[1] = new Memory();
//		
//		computer.setMemoryList(mlist);
		
		Memory memory = new Memory();
		computer.setMemory(memory);
		
		Memory memory1 = new Memory();
		computer.setMemory(memory1);
		
		Memory memory2 = new Memory();
		computer.setMemory(memory2);
		
		Memory memory3 = new Memory();
		computer.setMemory(memory3);
		
//		Memory memory4 = new Memory(); // 더 이상 꽂을 수 없음
//		computer.setMemory(memory4);
		
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory();
//		computer.removeMemory(); // 더 이상 뺄 수 없음
		
		User hong = new User();
		
		hong.setNick(0, "강아지");
		hong.setNick(1, "고양이");
		hong.setNick(2, "고슴도치");
		hong.setNick(2, "말");
		
		System.out.println(hong.getNick(0));
		System.out.println(hong.getNick(1));
		System.out.println(hong.getNick(2));
	}
	
}

class Computer {
	
	private CPU cpu;
	private MainBoard mainBoard;
	private Memory[] memoryList = new Memory[4]; // 클래스 멤버 변수에 배열도 들어갈 수 있음
	private int i = 0; // 메모리 관리를 위한 변수
	private Storage storage;
	
	public CPU getCpu() {
		return cpu;
	}
	
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
	public MainBoard getMainBoard() {
		return mainBoard;
	}
	
	public void setMainBoard(MainBoard mainBoard) {
		this.mainBoard = mainBoard;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	// 불안정한 코드
//	public Memory[] getMemoryList() {
//		return memoryList;
//	}
//
//	public void setMemoryList(Memory[] memoryList) {
//		this.memoryList = memoryList;
//	}
	
	public void setMemory(Memory memory) { // 메모리 꽂기
		
//		if (i != memoryList.length) {
//			this.memoryList[i] = memory;
//			i ++;
//		} else {
//			System.out.println("더 이상 남아있는 메모리 슬롯이 없습니다.");
//		}
		
		if (i == 4) {
			System.out.println("더 이상 남아있는 메모리 슬롯이 없습니다.");
			return; // 빈 리턴문 > 메서드 중지
		}
		
		this.memoryList[i] = memory;
		i++;
	}
	
	public void removeMemory() { // 메모리 뽑기

		if (i == 0) {
			System.out.println("더 이상 메모리가 남아있지 않습니다.");
			return;
		}
		
		i--;
		this.memoryList[i] = null; // NULL 상수, NULL 리터럴
	}
}

class CPU {
	
	private String model;
	private String speed;
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
}

class MainBoard {
	
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

class Memory {

	private String model;
	private int size;
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}

class Storage {
	
	private String model;
	private String type;
	private int size;
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}

class User {
	
	// 배열 관리해주는 변수 X
	private String name;
	private int age;
	private String[] nick = new String[10];
	
	public void setNick(int index, String value) {
		
		if (nick[index] != null) {
			System.out.println("선택한 인덱스에 값이 저장되어 있습니다.");
			return;
		}
		
		this.nick[index] = value;
	}
	
	public String getNick(int index) {
		return this.nick[index];
	}
}
