package studysj;

import java.util.Arrays;

public class Study나 {

	 // 내 문제
	public static void main(String[] args) {
		
		/*
		 * 
		 * 숫자와 영문자(소문자)로 이루어진 arr스트링 배열이 있습니다.
		 * 배열의 각 요소에서 숫자만을 빼와서 새로운 int 타입 배열에 넣어주려고 합니다.
		 * arr과 같은 길이의 int 타입 arr2배열을 선언하고,
		 * 각 요소의 문자를 (StringBuffer or StringBuilder 사용) int로 변환해서 arr2에 넣어주는 코드를 작성하시오 (예외 1 발생)
		 * 예외가 발생되면 요소에서 소문자를 제외한 숫자값을 배열에 !!두번!! 넣어줍니다 (예외 2 발생)
		 * 예외가 발생되면 배열의 길이를 1개 늘려서 넣어줍니다
		 * 두 예외를 처리하여 결과를 출력하세요!
		 * 
		 * 단 if문은 catch문 안에서만 사용 가능합니다.
		 * 
		 */

		
		String[] arr = {"75h","123","457","a789","ggg0","fgd49","ddd","444"};

		int[] arr2 = new int[arr.length]; //arr과 같은 길이의 int 타입 arr2배열을 선언하고

		int index = 0; // arr (원본배열)
		int index2 = 0; // arr2 (result 배열)
		
		
		while(index<arr.length) {	//숫자만을 빼와서 새로운 int 타입 배열에 넣어주려고 합니다.		
		// 중첩 try catch문	
			try {					
					arr2[index2] = Integer.parseInt(arr[index]); 
					
					index++;
					index2++;															
				
			} catch (NumberFormatException e) { // 문자를 숫자로 변환할때 (문자 제거후 arr2에 두번 넣기)
				
				try {
					
					StringBuilder sb = new StringBuilder(arr[index]);
					
					for(int i = sb.length()-1 ; i>=0; i--) { // 숫자 9는 아스키코드 57
						if((sb.charAt(i)-58)>0) { // 58을 빼도 0보다 크다면 문자
							sb.deleteCharAt(i); // 문자를 지워주기!
						}
					}
					
					if(sb.length()!=0) {  //요소에서 문자를 빼고 숫자만 남았다 int로 변환해주고 arr2에 두번 넣어준다
						arr2[index2] = Integer.parseInt(sb.toString());
						arr2[index2+1] = Integer.parseInt(sb.toString());
						index++;
						index2+=2;
					}else {// 요소가 문자로만 이루어진 경우는 인덱스값만 늘려줌
						index++;
					}
										
				} catch (ArrayIndexOutOfBoundsException d) { // 배열의 길이를 벗어났을 때	
					arr2 = Arrays.copyOf(arr2, arr2.length+1);
				}
				
			} catch (ArrayIndexOutOfBoundsException e) { // 배열의 길이를 벗어났을 때				
				arr2 = Arrays.copyOf(arr2, arr2.length+1);								
			}		
			
		} // while문 종료
				
		System.out.println(Arrays.toString(arr2));
				
		
		
	}

}
