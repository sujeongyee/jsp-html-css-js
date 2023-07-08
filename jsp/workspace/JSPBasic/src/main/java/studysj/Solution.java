package studysj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		
		int number = 10;
		int limit = 3;
		int power = 2;
		
		ArrayList<Integer> al = new ArrayList<>();
		int count = 0;		
		for(int i = 1 ; i <=number ; i++) {		
x:			for(int j = 1 ; j<=i ; j++) {
				if(j>number/2) {
					count+=1;
					break x;
				}
				if(i%j==0) count++;
				System.out.println(j);
			}			
			if(count> limit) {
				al.add(power);
			}else {
				al.add(count);
			}

			count=0;
		}
		count = 0;

		for(int a : al) {
			count+=a;
		}
		System.out.println(count);

	}
}
