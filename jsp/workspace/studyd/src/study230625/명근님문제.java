package study230625;

import java.io.BufferedReader;
import java.io.FileReader;

public class 명근님문제 {
	
	public static void main(String[] args) {
		String path = "C:\\Users\\rccar\\OneDrive\\바탕 화면\\박수정\\";
		//String path = System.getProperty("user.dir")+"\\src\\study230625\\";
		int count = countWordOccurrencesInDirectory(path,"apple");
		System.out.print(count);
		
	}
	
	public static int countWordOccurrencesInDirectory(String directory, String word) {
	
		System.out.print("단어 \""+ word + "\"의 등장 횟수 : ");
		String[] fileName = {"quiz1","quiz2","quiz3"}; // fileName 배열 선언
		int count = 0;
		for(String name : fileName) {
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(directory+name+".txt"));				
				String result;
				
				int length = word.length(); // 찾을 단어의 길이
				while((result = br.readLine())!=null) {
					result = result.toLowerCase(); // 소문자로 통일
					result = result.replaceAll("[^a-z]",""); // 소문자가 아니라면 없애주기!
					int a = result.length(); // 지금 문자열의 길이를 int a에 담아줍니다				
					result = result.replaceAll(word,""); // word를 없애주고
					count+=(a-result.length())/length; // (원래 문자열 길이 - word를 없애고 난 후 길이)/찾을단어의길이 -> 몇개
				}
				
				
			} catch (Exception e) {
				System.out.println("디렉토리를 읽는 도중 오류가 발생하였습니다.");
			} 
			
		}
		
			
		
		return count;
	}

}
