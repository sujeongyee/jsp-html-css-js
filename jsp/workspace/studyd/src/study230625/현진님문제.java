package study230625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 현진님문제 {

	public static void main(String[] args) {
//		String path = "C:\\Users\\rccar\\OneDrive\\바탕 화면\\박수정\\";
		String path = System.getProperty("user.dir")+"\\src\\study230625\\";
		List<String> fileName = new ArrayList<>(Arrays.asList("a","b","c","d","e","f")); // 파일 이름이 들어있는 리스트

		
		try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));){		
			
			System.out.print("첫 번째 파일 이름을 입력하세요>>");
			String a = bread.readLine();
			System.out.print("두 번째 파일 이름을 입력하세요>>");
			String b = bread.readLine();
			
			BufferedReader br = new BufferedReader(new FileReader(path+a+".txt"));
			BufferedReader br2 = new BufferedReader(new FileReader(path+b+".txt"));

			List<String> al = new ArrayList<>();
			List<String> al2 = new ArrayList<>();
			while((a=br.readLine())!=null) al.add(a); // 각 문장을 리스트에 담아 줍니다
			while((b=br2.readLine())!=null) al2.add(b);


			if(al.containsAll(al2)) { // 두 파일이 같다면
				System.out.println("같습니다.");
				System.out.println("------------------------");
			}else {
				System.out.println("같지 않습니다. 파일 복사를 시작합니다.");
				System.out.println("--------------------------");
				System.out.println("새로운 파일 이름을 입력하세요>>");
				String fName = bread.readLine(); // 새로운 파일 이름을 입력받아
				fileName.add(fName); // 파일이름 리스트에 추가해주기
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(path+fName+".txt"));
				int count = al.size()>=al2.size()? al2.size():al.size(); // 두 파일 중 더 작은 길이	
				
				for(int i = 0 ; i < count ; i++) {
					bw.write(al.get(i)+"\n");
					bw.write(al2.get(i)+"\n");
				}
				// 혹시 카운트보다 더 크다면 나머지 문장도 작성해주기
				if(al.size()>count) {
					for(int i = count; i< al.size(); i++) {
						bw.write(al.get(i)+"\n");
					}
				}
				if(al2.size()>count) {
					for(int i = count; i<al2.size(); i++) {
						bw.write(al2.get(i)+"\n");
					}
				}
				System.out.println("복사완료!");
				System.out.println("---------------------------");
				bw.flush();
				br.close();
				br2.close();
				bw.close();
			}


		} catch (Exception e) {

		}

		System.out.print("가장 큰 파일명 : ");
		List<String> al = maxFile(fileName);
		System.out.print(al.toString()+ ", ");
		File file = new File(path+al.get(0));	
		System.out.println("크기 : " +file.length() + "byte");
		
	}

	// 가장 큰 크기의 파일을 불러와주는 메서드
	
	public static List<String> maxFile(List<String> a){
		
		String path = "C:\\Users\\rccar\\OneDrive\\바탕 화면\\박수정\\";
		//String path = System.getProperty("user.dir")+"\\src\\study230625\\";

		Map<String, Integer> hm = new HashMap<>();
		List<String> maxFile = new ArrayList<>();

		int max = 0;
		for(String name : a) {
			File file = new File(path+name+".txt");		
			if(file.length()>max) max = (int)file.length();
			hm.put(name+".txt",(int)file.length());
		}


		for(Map.Entry<String,Integer> map:hm.entrySet()) {
			if(map.getValue()==max) {
				maxFile.add(map.getKey());

			}
		};

		return maxFile;
	}

}
