package study230625;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class 정수님문제 {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\rccar\\OneDrive\\바탕 화면\\박수정\\saying.txt";
		//String path = System.getProperty("user.dir")+"\\src\\study230625\\saying.txt";
		
		System.out.println("속담 퀴즈입니다!! 빈 칸에 알맞은 말을 입력하시오.");
		System.out.println("====================================");
		
		int count = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in))
		   ) {
			String result = "";
			while((result = br.readLine())!=null) {
				result+="/"+br.readLine(); //두줄을 받아와서 뒤에 / 를 같이 넣어줍니다!
				String[] arr = result.split("/"); // /기준으로 잘라주고 문제 , 답
				System.out.println("(문제)"+arr[0]); 
				System.out.print("정답을 입력해주세요 => ");
				String dab = br2.readLine();
				if(dab.equals(arr[1])) {
					System.out.println("정답입니다!\n");					
					count++; // 정답 횟수를 세줍니다!
				}else {
					System.out.println("오답입니다. 정답은 " + arr[1] + "입니다.\n");
				}
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=======================================");
		System.out.println("퀴즈 끝! 수고링");
		System.out.println("정답 갯수 : " + count + " 오답 갯수 : " + (10-count));
		
		
	}

}
