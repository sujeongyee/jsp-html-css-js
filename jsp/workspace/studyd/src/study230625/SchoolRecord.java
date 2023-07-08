package study230625;

import java.io.Serializable;

public class SchoolRecord implements Serializable {
	
	
	
	//여기서부터는 수정 없이 그대로 사용하면 됩니다.
	private String name;
	private int kor;
	private int math;
	private int total;
	private int rank;

	public SchoolRecord() {

	}



	public SchoolRecord(String name, int kor, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.total = kor+ math;
		this.rank = 1;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public boolean setKor(int kor) {

		if(kor < 0 || kor > 100) {

			return false;
		}
		this.kor = kor;

		return true;
	}

	public int getMath() {
		return math;
	}

	public boolean setMath(int math) {

		if(math < 0 || math > 100) {

			return false;
		}

		this.math = math;
		return true;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {

		this.total = kor + math;
	}

	public int getRank() {
		return rank;
	}
	

	public void plusRank() {

		this.rank++;
	}

	public void clearRank() {

		this.rank = 1;
	}
	

	public void info () {

		System.out.println(name + "님의 총점은 " + total + "점이고, 순위는 " + rank + " 등입니다." );
	}


}
