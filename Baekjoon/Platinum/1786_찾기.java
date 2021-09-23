package prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-23
 * Description : 백준 1786
 */


public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlength = text.length, plength = pattern.length;
		
		//실패 함수 만들기
		int[] pi = new int[plength];
		for(int i=1, j=0; i<plength; i++) {
			while(j>0 && pattern[i]!=pattern[j]) {
				j  = pi[j-1];
			}
			if(pattern[i] == pattern[j]) pi[i] = ++j;
		}
		
		int cnt = 0; 
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0,j=0; i<tlength; i++) {
			
			while(j>0 && text[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(text[i] == pattern[j]) {
				if(j == plength-1) {
					cnt++;
					list.add((i+1)-plength+1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		bw.write(cnt+"\n");
		for(int n : list) {
			bw.write(n+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
