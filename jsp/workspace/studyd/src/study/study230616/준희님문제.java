package study.study230616;

import java.util.Scanner;
import java.util.TreeSet;

public class 준희님문제 {

	public static void main(String[] args) {
//		 문자나 숫자를 10번 입력할때 만약 중복값이면 "중복값입니다"를 출력하고 새로 입력 받아주세요.
//		 (TreeSet을 이용합니다.)
		
		
		Scanner scan = new Scanner(System.in);
		 
		int num = 0;
		while(num!=3) {
			TreeSet<Integer> ts = new TreeSet<>();
			TreeSet<String> ts2 = new TreeSet<>();
			System.out.println("숫자나 문자를 10번 입력해주세요");
			System.out.println("1.숫자 2.문자 3.종료");
			num = scan.nextInt();
			switch(num) {
			case 1 : 
				System.out.println("숫자를 입력해주세요");
				while(ts.size()<10) {
					int b = ts.size();
					int a = scan.nextInt();
					ts.add(a);
					if(ts.size()==b) {
						System.out.println("중복값입니다. 숫자를 다시 입력해주세요");
					}
				}
				System.out.println(ts.toString());
				break;
			case 2 :
				System.out.println("문자를 입력해주세요");
				while(ts2.size()<10) {
					int b = ts2.size();
					String a = scan.next();
					ts2.add(a);
					if(ts2.size() == b) {
						System.out.println("중복값입니다. 문자를 다시 입력해주세요");
					}
				}
				System.out.println(ts2.toString());	
			}
		}
	}
}
