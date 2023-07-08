package studysj;

import java.util.Scanner;

public class Study준희님 {

	public static void main(String[] args) {
		
		//준희님 문제
		
		Scanner scan = new Scanner(System.in);
x:		while(true) {
			System.out.print("공백없이 문자열을 입력해주세요>");
			String a = scan.next();

			StringBuilder sb = new StringBuilder(a);
			StringBuilder answer = new StringBuilder(a);
			if(a.equals(sb.reverse().toString())){
				System.out.println("회문입니다");
				break x;
			}else {
				System.out.println("회문이 아닙니다.");
				System.out.println("회문으로 바꾸겠습니다.");

				for(int i = a.length()-2 ; i>= 0 ; i--) {
					answer.append(a.charAt(i));
				}
				System.out.println(answer.toString());				
			}
		}
	
		System.out.print("첫번째 숫자 >");
		String a = scan.next();
		System.out.print("두번째 숫자 >");
		String b = scan.next();
		
		System.out.println("두 수의 합은 : "+ (Integer.parseInt(a) + Integer.parseInt(b)) + "입니다");
	

	}

}
