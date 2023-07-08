package studysj;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Study현진님 {
	// 현진님 문제
	public static void main(String[] args) {

		move();

	}

	public static void move() {

		Scanner scan = new Scanner(System.in);
s:		while(true) {

			String[] arr = {"□","□","□","□","□","□","□","□","□"};
			int b = setRandom(); // "■"의 위치
			arr[b]= "■";

r:			while(true) {

				try {

					System.out.println(Arrays.toString(arr));
					System.out.println("[1.왼쪽이동 / 2.오른쪽이동 / 3. 종료] ");
					System.out.print(" >> ");

					int num = scan.nextInt();

					switch (num) {
					case 1 :  // 왼쪽 이동
						String temp = arr[b];
						arr[b] = arr[b-1];
						arr[b-1] =temp;
						b--;
						break;
					case 2 : // 오른쪽 이동
						temp = arr[b];
						arr[b] = arr[b+1];
						arr[b+1] =temp;
						b++;
						break;
					case 3 : 
						System.out.println("이동 종료");
						break s;
					default : 
						System.out.println("1~3 사이의 숫자만 입력");
						break;
					}

				} catch (InputMismatchException e) {
					scan.next(); // 위에 문자 입력 후 엔터 때문에 무한루프 발생
					System.out.println("오류 발생! 숫자를 입력하세요.");

				} catch (ArrayIndexOutOfBoundsException e) {

					if(b==8) { // b가 가장 오른쪽에 있을 때
						System.out.println("오류 발생 ! >> 오른쪽으로 더이상 이동 못함");
					}else { // b가 가장 왼쪽에 있을 때
						System.out.println("오류 발생 ! >> 왼쪽으로 더이상 이동 못함");
					}
					break r;

				}
				System.out.println("--------------------------------------");

			}
		
		}
		
		scan.close();
	
	}
	public static int setRandom() {

		return (int)(Math.random()*9); // 0부터 9까지의 랜덤수 반환
	}

}
