package studysj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Study명근님 {

	// 명근님 문제

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("입력할 정수의 개수 : ");
		int a = scan.nextInt();
		System.out.println(a+"개의 정수를 입력하세요 : ");

		int count = 0;
		int b = 0;
		int arr[] = new int[a];

		while(count<a) {

			System.out.print("정수 값 #" + (count+1) + " : ");
			b = scan.nextInt();
			arr[count] = b;
			count++;

		}

		System.out.print("탐색할 정수 값 : ");
		b= scan.nextInt();

		int[] arr2 = Arrays.copyOf(arr, arr.length);

		Arrays.sort(arr2);

		System.out.println(b+"가 있는 인덱스 번호 : "  + Arrays.binarySearch(arr2, b));

		System.out.println("정렬된 배열 : " + Arrays.toString(arr2));
		
		System.out.print("비교할 배열의 크기 : ");
		
		a = scan.nextInt();
		
		System.out.println(a+"개의 정수를 입력하세요 : ");

		count = 0;
		b = 0;
		int arr3[] = new int[a];

		while(count<a) {

			System.out.print("정수 값 #" + (count+1) + " : ");
			b = scan.nextInt();
			arr3[count] = b;
			count++;

		}

		boolean check = false;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i]==arr3[i]) {
				check=true;
			}else {
				break;
			}
		}
		System.out.println("두 배열이 일치하는지 비교 : " + check);
		System.out.println("첫번째 배열 : " +Arrays.toString(arr) );
		System.out.println("두번째 배열 : " +Arrays.toString(arr3) );
	} 

}
