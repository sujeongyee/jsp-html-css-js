package study.study230616;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 현진님문제 {
	
	/*
	 * 전화번호부를 만들고 이름을 검색해서 해당 이름의 번호를 출력하는 시스템을 만들어 봅시다.
	 * ** HashMap사용하기
	 * 1. Person이름으로 제네릭 클래스를 정의합니다. 클래스에 저장되는 멤버변수는 <전화번호부에 저장되는 순서, 폰 번호> 입니다.
	 * 2. 5명의 사람에 대해 이름과 번호를 입력받고, map에 차례대로 저장합니다.  map은 <String, Person> 타입입니다. 
	 * 3. exit을 입력할 때까지 전화번호부에 저장된 사람을 검색합니다.
	 * - 검색한 이름이 있으면, 저장된 순서와 번호 출력
	 * - 검색한 이름이 없으면 exception처리
	 * - exit 입력하면 프로그램 종료
	 * */

	public static class Person<Integer,String> {
		int seq;
		String phone_num;
	}


	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
 
		Map<String,Person> phone = new HashMap<>(); 
		int i =1;
		System.out.println("전화번호 저장");
		System.out.println("==========================");

		while(i <= 5) { // 5번 저장
			System.out.print("이름 >> ");
			String name = scan.next();
			System.out.print("번호 >>");
			String phone_num2 = scan.next();
			Person<Integer,String> a = new Person<Integer,String>();
			a.seq = i; //순서
			a.phone_num=phone_num2; //번호			
			phone.put(name, a);
			i++;
			System.out.println("------------------------");
		}

		System.out.println("==================================");

x:		while(true) {
			System.out.print("검색할 이름 >>");
			String name = scan.next();
			if(name.equals("exit")) {
				System.out.println("프로그램 종료");
				break x;
			}
			Person p = phone.get(name);
			try {
				if(p!=null) {
					System.out.println(p.seq+"번째, 전화번호 : "+p.phone_num);
				}else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("없는 사람입니다.");
			}
			System.out.println("--------------------------------");

		}






	}
}
