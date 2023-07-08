package study230625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진님문제 {

	public static void main(String[] args) {



		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("문자열을 입력하세요 : ");
			String str = br.readLine();
			String[] arr = str.split(" "); // 공백 기준으로 단어들은 잘라줍니다!
			int sum = 0; // 총 단어의 길이
			String min = arr[0]; //가장 짧은 단어
			String max = arr[0]; //가장 긴 단어
			for(String a : arr) {
				sum+=a.length();
				if(a.length()<min.length()) {
					min=a;
				}else if(a.length()>max.length()) {
					max =a;
				}				
			}
			System.out.println("단어 개수: " + arr.length);
			System.out.println("평균 길이: " + (sum/arr.length));
			System.out.println("가장 긴 단어: " + max);
			System.out.println("가장 짧은 단어: " + min);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
