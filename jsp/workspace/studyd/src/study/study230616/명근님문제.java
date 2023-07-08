package study.study230616;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 명근님문제 {

	public static void main(String[] args) {

		System.out.println("당신의 로또를 구매할 아이디는 : hello_world");
		System.out.print("비밀번호를 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		String pw = scan.next();

		// (최소 8자리에 대문자, 소문자, 숫자, 특수문자 각 1개 이상 포함)
		Matcher m = Pattern.compile("[a-z]+").matcher(pw);
		Matcher m2 = Pattern.compile("[A-Z]+").matcher(pw);
		Matcher m3 = Pattern.compile("[0-9]+").matcher(pw);
		Matcher m4 = Pattern.compile("[\\$\\@\\!\\%\\*\\?\\&]+").matcher(pw);
		
		TreeSet<Integer> lotto = new TreeSet<>();
		Random ran = new Random();
		
		if(pw.length()>=8 && m.find() && m2.find() && m3.find() &&m4.find()) { // 조건을 다 만족해야만 로또를 살수 있음
			System.out.println("로그인성공");
			int i = 1;
			while(i<=5) {
				while(lotto.size()<=5) {
					lotto.add(ran.nextInt(45)+1); // 0이상 45미만에 1을 더해준다 
				}
				System.out.println("로또 구매 "+i+"번째 : ");
				System.out.println("로또 번호 :" + lotto.toString());
				lotto.clear();
				i++;
			}			
		}else {
			System.out.println("로그인 실패 ! 다음 주에 사세요~!!!");
		}


	}

}
