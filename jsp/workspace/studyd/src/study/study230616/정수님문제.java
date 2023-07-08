package study.study230616;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class 정수님문제 {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int i = 1 ; i <= 10 ; i++) list1.add(i); //1부터 10까지 저장
		for(int i =3 ; i<= 11 ; i+=2) list2.add(i); // 3, 5, 7, 9, 11 저장
		
		System.out.println("list1="+list1.toString());
		System.out.println("lsit2="+list2.toString());
		
		List<Integer> result = new ArrayList<>();
		List<Integer> result2 = new ArrayList<>();
		for(int a : list1) {	
			if(list2.contains(a)) result.add(a); // 두곳에 다 있으면 첫번째 list에 저장 (교집합)
			else result2.add(a); // list1기준으로 list2에 없는 값만 저장 (차집합)
		}
		System.out.println("교집합="+result.toString());
		System.out.println("차집합="+result2.toString());
		
		result.clear();
		
		// 합집합 구하기
		
		for(int a : list1) { //list2에 없는값만 넣어주고
			if(!list2.contains(a)) result.add(a);
		}

		result.addAll(list2);
		
		
		System.out.println("합집합="+result.toString());
		
	}

}
