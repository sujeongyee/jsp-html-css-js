package studysj;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Study윤정님 {

	public static void main(String[] args) {
		 // 윤정님 문제
		Scanner scan = new Scanner(System.in);

x:		while(true) {
			System.out.print("수식입력=>  ");
			String cal = scan.nextLine(); // 식을 입력 받습니다

			StringTokenizer st = new StringTokenizer(cal, "+-*/" ,true); // 연산자 기준으로 자르기 (연산자 포함)
			int result = 0; // 수식의 결과값을 구해줄  result 변수

			try {
				result =Integer.parseInt(st.nextToken()); // 첫번째 숫자 
				while(st.hasMoreTokens()!=false) {
					String oper = st.nextToken();
					int a = Integer.parseInt(st.nextToken());		


					switch(oper) {					
					case "+" : result+=a;
					break;

					case "-" : result-=a;
					break;

					case "*" : result*=a;
					break;

					case "/" : result/=a;
					break;

					}	


				}	
				System.out.println("수식 결과 값 : " + result);
				break x;

			} catch (Exception e) { // 오류가 발생하면 ~
				System.out.println("수식 입력 오류!!!");
			}

		}


		scan.close();


	}

}
