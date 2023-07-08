package study.study230616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myQuestion {

	public static void main(String[] args) {
		
		/*
		 * 주어진 문자열을 이용해 다음과 같이 문제를 풀어보세요!! (정규표현식 ,map 필수사용)
		 * 1. 정규 표현식을 이용해서 quiz 문자열을 첨부한 이미지와 같이 나눠줍니다 
		 * 2. 나눠진 문자열에서 이름과 점수를 <String,Integer> 형태로 map에 담아줍니다
		 * 3. 점수가 높은 친구를 순서대로 출력해줍니다 (map 사용)
		 * 저는 map에 담아줄 때 list 에 점수 따로 넣어주고 , array 클래스 같이 사용했습니다! (다른 방법으로도 가능합니다!)
		 * */
		
		String quiz = "단비 학생은 60점입니다 짱구 학생은 55점입니다 짱아 학생은 70점입니다 맹구 학생은 80점 입니다 훈이 학생은 시험을 치루지 않아 0점입니다 유리 학생은 86점입니다 김철수 학생은 저번 시험에서 우수한 성적을 거둬 100점입니다!";
		
		ArrayList<Integer> list  = new ArrayList<>();
		Map<String,Integer> map = new TreeMap<>();

		String pattern = "[가-힣]{2,3} 학생은[가-힣\s]*[0-9]+점\\s*입니다\\!*";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(quiz);
		
		while(m.find()) {
			String a = m.group();			
			String[] arr = a.split("점입니다| |입니다|점|!");
			map.put(arr[0], Integer.parseInt(arr[arr.length-1]));
			list.add(Integer.parseInt(arr[arr.length-1]));
			
			System.out.println(m.group());
			System.out.println("----------");
		}
		
		int[] arr2 = new int[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			arr2[i] = list.get(i);
		}
		
		Arrays.sort(arr2);

				
		
		for(int i = arr2.length-1 ; i >=0 ; i--) {
			for(Map.Entry<String, Integer> map2 : map.entrySet()) {
				if(map2.getValue() == arr2[i]){
					System.out.println(map2.getKey() + "는 " +map2.getValue() + "점입니다! " + (Math.abs(i-7)) + "등이네요" );
					System.out.println("----------------");
				}
			}
		}
		
		
		
		
		
	}
} 
