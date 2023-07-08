package study.study230616;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 이진님문제 {
	public static void main(String[] args) {

		//단어 길이마다 제일 많이 사용하는 알파벳이 무엇인지를 찾아내시오.

		String[] words = { "better", "vest", "raspy", "tearful", "dream", "accept", "ignore", "elfin", "pat", "wail",

				"itchy", "attract", "unpack", "assorted", "month", "cast", "beef", "arithmetic", "petite", "umbrella",

				"kaput", "frightened", "frame", "abounding", "yak", "resonant", "trace", "simplistic", "three", "slip",

				"train", "name", "lock", "windy", "guide", "calm", "tedious", "decisive", "illustrious", "exciting",

				"lamp", "adamant", "average", "finger", "sack", "vanish", "damaged", "bed", "compare", "notebook",

				"beds", "delight", "cowardly", "unknown", "shiver", "kill", "bright", "greedy", "makeshift", "cellar",

				"owe", "pack", "water", "paper", "rub", "incompetent", "neck", "tense", "airport", "cheap", "structure",

				"gaudy", "wound", "knot", "park", "simple", "brush", "fail", "volatile", "jam", "chubby", "pour",

				"load", "abortive", "increase", "knowledge", "meal", "cream", "stitch", "laugh", "treatment", "reach",

				"approval", "war", "kindhearted", "comparison", "past", "standing", "crown", "society" };

		Map<String,Integer> tm = new TreeMap<String,Integer>();
		System.out.print("문자열의 길이 : "); // 문자열의 길이 받기 
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();

		for(String a : words) {
			if(a.length()==length) { // 배열을 돌며 문자열의 길이가 같으면!
				String[] arr  = a.split("");
				for(int i = 0 ; i < arr.length; i++) { 
					if(tm.containsKey(arr[i])) { // map에 이미 키가 들어있다면 value값만 올려주면 된다
						tm.replace(arr[i], tm.get(arr[i])+1);						
					}else { // 아니라면 새로 넣어주기!
						tm.put(arr[i],1);
					}
				}						
			}
		}
		int[] arr = new int[tm.size()]; //알파벳 수를 저장할 배열 선언
		int index = 0;
		for(String b : tm.keySet()) {
			System.out.println( b + " - > " + tm.get(b));
			arr[index] = tm.get(b); // 알파벳 개수를 저장
			index++;
		}
		Arrays.sort(arr);
		index = arr[arr.length-1]; // 가장 큰값
		
		for(String b : tm.keySet()) {
			if(tm.get(b)==index) {
				System.out.println("가장 많이 나온 알파벳은 : " + b);
			}
		}

		
		
	}
}
