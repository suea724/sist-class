package com.test.java.student;

public class Score {
	
	private String seq;
	private int kor;
	private int eng;
	private int math;
	
	public Score(String seq, int kor, int eng, int math) {
		this.seq = seq;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return String.format("Score [seq=%s, kor=%s, eng=%s, math=%s]", seq, kor, eng, math);
	}

}
