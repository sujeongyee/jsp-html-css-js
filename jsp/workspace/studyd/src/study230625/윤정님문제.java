package study230625;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class 윤정님문제 {

	public static void main(String[] args) {

		RecordProgram r = new RecordProgram();

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while(true) {
				System.out.println("|--------------성적 관리 프로그램------------|");
				System.out.println("|1.입력 2.출력 3.삭제 4.수정 5.저장 6.열기 7.종료|");
				System.out.println("|---------------------------------------|");
				System.out.print(" : ");
				int a =0;
				while(true) {
					try {
						a = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("숫자를 입력해주세요");
					}
					if(a>0) break;
				}
				switch(a) {
				case 1 : r.inputRecord();
				break;
				case 2 : r.printRecord();
				break;
				case 3 : r.removeRecord();
				break;
				case 4 : r.updateRecord();
				break;
				case 5 : r.saveRecord(); 
				break;
				case 6 : r.openRecord();					
				break;
				case 7 :
					System.out.println("프로그램이 종료되었습니다. 이용해주셔서 감사합니다.");
					System.exit(0);
				default : System.out.println("잘못 입력했습니다 다시 입력해주세요!");
				break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}




	public static class RecordProgram{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		SchoolRecord s = new SchoolRecord();
		List<SchoolRecord> list = new ArrayList<>(); //학생 정보를 담아줄 list 선언
		String record = "";
		
		
		
		//이름과 성적을 입력 받는 inputRecord()
		public void inputRecord()  {
			try {
				System.out.print("학생 이름 입력: ");
				String name = br.readLine();
				System.out.print("국어 성적 입력: ");
				int kor = Integer.parseInt(br.readLine());
				System.out.print("수학 성적 입력: ");
				int math = Integer.parseInt(br.readLine());
				s = new SchoolRecord(name,kor,math);
				list.add(s);
				updateRank();
				System.out.println("추가되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("처리 중 오류가 발생했습니다.");
			}


		}
		//입력한 내용을 등수와 함께 출력하는 printRecord()
		public void printRecord() {
		
			for(SchoolRecord sr :list) {
				sr.info();
			}
			

		}
		//입력한 정보를 삭제하는 removeRecord()
		public void removeRecord() {

			if(list.size()==0) {
				System.out.println("**입력 후 삭제 바랍니다. **");
				return;
			}
			try {

				System.out.print("삭제할 이름 : ");
				String name = br.readLine();
				int a = list.size(); // 지금 리스트의 크기
				list = list.stream().filter(aa -> !aa.getName().equals(name)).toList(); //name이 다른 친구만 남겨줌!
				if(list.size()==a) {//새로운 리스트의 크기와 같다면 삭제가 안됐습니다!
					System.out.println("** 존재하지 않는 학생입니다.");
				}else {
					System.out.println("삭제 완료");
				}
				updateRank();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("삭제 중 오류가 발생했습니다");
			}

		}


		//입력한 정보를 수정하는 updateRecord()
		public void updateRecord() {

			if(list.size()==0) {
				System.out.println("**수정할 내용이 없습니다. 입력 후 이용 바랍니다. **");
				return;
			}

			try {
				System.out.print("변경할 이름 : ");
				String name = br.readLine();
				int result = 0;
				for(SchoolRecord sr:list) {
					if(sr.getName().equals(name)) { 
						result+=1;
						System.out.print("국어 점수를 변경하세요:");
						sr.setKor(Integer.parseInt(br.readLine()));
						System.out.print("수학 점수를 변경하세요:");
						sr.setMath(Integer.parseInt(br.readLine()));
						sr.setTotal();
						System.out.println("변경되었습니다.");
						updateRank();
					}
				}
				if(result==0) {
					System.out.println("이름을 다시 확인 바랍니다.");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("변경 중 오류가 발생했습니다");
			}



		}
		//등수를 수정하는 updateRank()
		public void updateRank() {

			List<Integer> al = new ArrayList<>(); //총 점수를 담아줍니다.
			for(SchoolRecord sr :list) {// 반복을 돌며 모든 rank를 맞춰주고!
				al.add(sr.getTotal());
				sr.clearRank();
			}
			al = al.stream().sorted().toList(); // 총점수를 정렬

			for(int i = al.size()-1; i>=0;i--) { // 큰점수부터 내려오면서 
x:				for(int j = 0 ; j< list.size();j++) { // 리스트를 돌려주고
					if(al.get(i)==list.get(j).getTotal()) { // 점수가 같다면
						for(int z = 0 ; z<(al.size()-1)-i ;z++) { //plusRank를 몇번해줄지 -> 가장 큰 점수는 0번 그 다음 점수는 1번 그 다음 점수는 2번
							list.get(j).plusRank();
						}
						break x;
					}
				}
			}						

		}
		//내용을 파일로 저장하는 saveRecord()
		public void saveRecord() {

			byte[] student;
			try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos);) {				
				oos.writeObject(list);
				student = bos.toByteArray();
				record = Base64.getEncoder().encodeToString(student); // 파일 기록
//				System.out.println(record);
				System.out.println("저장되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일로 저장 중 오류 발생");
			}

		}
		//이전 정보를 불러오는 openRecord()
		public void openRecord() {
			
			byte[] student = Base64.getDecoder().decode(record);
			
			try (ByteArrayInputStream bais = new ByteArrayInputStream(student);
				 ObjectInputStream ois = new ObjectInputStream(bais)){
				Object read =  ois.readObject();
				List<SchoolRecord> result = (List<SchoolRecord>)read; // 강제 형변환 해주기 list<string>
//				System.out.println(result.toString());
				System.out.println("불러오기 성공!");
//				for(SchoolRecord s : result) {
//					System.out.println(s.getName()+"님은 총 "+s.getTotal()+"점을 받아 "+s.getRank()+"등 달성");					
//				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일을 불러오는 도중 오류가 발생했습니다.");
			}
			
		}
	}



}
