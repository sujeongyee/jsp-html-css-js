package studysj;

public class Study정수님 {

	public static void main(String[] args) {
		
		//정수님 문제
		
		String test1 = deleteChar( "(문!제@를!한~번)*풀$어%볼#까$요?)^@^", "~!@#$%&*()");
		System.out.println("(문!제@를!한~번)*풀$어%볼#까$요?)^@^" + "  ------> "+ test1);
		String test2 = deleteChar("문a제y내z느d라ik힘s들q었k다nh히vb유..." , "ayzdiksqknhvb");
		System.out.println("문a제y내z느d라ik힘s들q었k다nh히vb유..." +"----->  " + test2);
		
	}

	public static String deleteChar(String sentence , String deleteCh) {

		StringBuilder st = new StringBuilder(sentence); // 원본문자열
		StringBuilder dc = new StringBuilder(deleteCh); // 제거할문자열

		String answer = "";
		
		for(int i = 0 ; i < st.length() ; i++) { // 원본문자열에서 
			if(dc.indexOf(st.charAt(i)+"")< 0 ) { // 제거할 문자열에 없는 문자면 (없으면 음수가 나옵니다)
				answer+=st.charAt(i);
			} // answer 에 더해줍니다
			
		}
		
		return answer;
	}
}
