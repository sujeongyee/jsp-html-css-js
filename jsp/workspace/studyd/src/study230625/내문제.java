package study230625;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 첨부된 text 파일을 다운 받아 현재 폴더에 저장 , 읽어옵니다 (저는 경로 System.getProperty("user.dir") 활용 했습니다!)
 * Person 클래스 선언 (멤버변수 name, age) , person 객체를 담을 list 생성
 * 읽어온 문장에서 정규표현식을 사용해서 이름과 나이를 구해서 person객체에 담아준 뒤 list에 넣어줍니다
 * 마지막으로 스트림을 활용해 list에 나이가 50세 이상인 사람들만 추려줍니다
 * 첨부한 이미지 같이 출력해주세용
 */


public class 내문제 {
	
	public static class Person {
		
		String name;
		int age;
		
		Person(String name, int age){
			this.name = name;
			this.age=age;
		}
		
	}
	
	public static void main(String[] args) {
		//String path = "C:\\Users\\rccar\\OneDrive\\바탕 화면\\박수정\\text.txt";
		String path = System.getProperty("user.dir")+"\\src\\study230625\\text.txt" ;

		List<Person> al = new ArrayList<>(); // person객체를 담을 list선언
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) { // txt파일을 읽어줍니다.
			String result;
			String sentence = "[가-힣]+\s[0-9]+"; //ex 짱구는 28
			Pattern p = Pattern.compile(sentence);
			while((result = br.readLine())!=null) {
				Matcher m = p.matcher(result);
				while(m.find()) {	

					String[] arr = (m.group()).split("는 |은 "); // 는 은 도 삭제 -> arr[0] 이름 arr[1] 나이
					Person ps = new Person(arr[0], Integer.parseInt(arr[1]));
					al.add(ps);
				}
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}

		al = al.stream().filter(aa-> aa.age >=50).toList(); // aa객체에서 age가 50을 넘는 사람만 추려주기
		
		for(Person aaa : al) {
			System.out.println(aaa.name+" : "+(124-aaa.age)+"년생"); // 24년도에서 빼주는데 음수값이 나올수 있으므로 124 에서 빼줍니다!
		}
		
	}
	
	
}
