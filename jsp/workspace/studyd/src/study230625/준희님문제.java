package study230625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 준희님문제 {
	
	public static void main(String[] args) {
		
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String fileName = sdf.format(date);
		String path = "C:\\Users\\rccar\\OneDrive\\바탕 화면\\박수정\\" + fileName;
		//String path = "C:\\Users\\user\\Desktop\\" + fileName;
		File file = new File(path);
		file.mkdir();
				
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("오늘 날짜 : " + fileName);
			System.out.print("text 제목 > ");			
			String title = br.readLine();
			BufferedWriter bw = new BufferedWriter(new FileWriter(path +"\\"+ title + ".txt"));
			String result;
			while(!(result = br.readLine()).equals("탈출")) {
				bw.write(result + "\n");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
