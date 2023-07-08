package Baekjoon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		int[] priorities = {2,1,3,2};
		int location = 2;
		int count = 0;
		
		Deque<Integer> que = new ArrayDeque<>();


		for(int i = 0; i< priorities.length; i++) que.offer(priorities[i]);
		
		for(int i = que.size()-1; i>=0 ; i--) {
			
		}





	}

}
