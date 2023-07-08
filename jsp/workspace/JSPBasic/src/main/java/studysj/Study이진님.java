package studysj;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Study이진님 {

	public static void main(String[] args) {
		
		// 이진님 문제

		Scanner scan = new Scanner(System.in);

		int count = 1;
		int a = 0;
		
		
		Random rd = new Random();
		int answer = rd.nextInt(49) + 1; //1부터 50
		
		System.out.println("1부터 50까지의 숫자를 맞춰보세요!");
		
x:		while(true) {

			try {
				
				a = scan.nextInt();

				if(a>50) {
					throw new Exception("숫자의 범위를 벗어났습니다. 다시 입력하세요.");
				}



			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요.");
			}
			
			if(a == answer) {
				System.out.println("숫자를 맞췄습니다 정답은 : " + a);
				System.out.println("시도횟수 : " + count);
				break x;
			}else if (a > answer){
				System.out.println("틀렸습니다 ! 다시 맞춰보세요!");
				//System.out.println("힌트 : 더 작은 수 입니다");
				System.out.println("시도횟수 : " + count);
			}else{
				System.out.println("틀렸습니다 ! 다시 맞춰보세요!");
				//System.out.println("힌트 : 더 큰 수 입니다");
				System.out.println("시도횟수 : " + count);
			}
			
			count++;
		}

	}






}
