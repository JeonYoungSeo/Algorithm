import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			//갯수 입력
			int N = Integer.parseInt(br.readLine());
			//케이스 입력
			String str = br.readLine();
			
			char[] ch = new char[N];
			
			List<Integer> lst = new ArrayList<Integer>();
			List<Integer> lst_temp = new ArrayList<Integer>();
			//후위연산으로 변환
			for(int i=0; i<N; i++) {
				if(i%2==0) {
					lst.add((int)str.charAt(i)-'0');
				}else {
					if(str.charAt(i)=='+') {
						while(!lst_temp.isEmpty()) {
							lst.add(lst_temp.get(lst_temp.size()-1));
							lst_temp.remove(lst_temp.size()-1);
						}
						lst_temp.add(-1);
					}else{
						lst_temp.add(-2);
					}
				}
			}
			while(!lst_temp.isEmpty()) {
				lst.add(lst_temp.get(lst_temp.size()-1));
				lst_temp.remove(lst_temp.size()-1);
			}
			
			//-2 = 곱하기 -1= 더하기
			int cur = 0;
			int result = 0;
			while(true) {
				if(lst.size()==1) {
					result = lst.get(0);
					break;
				}
				if(lst.get(cur)==-2) {
					int temp = lst.get(cur-2)*lst.get(cur-1);
					cur -= 2;
					for(int i=0; i<3; i++) 
						lst.remove(cur);
					lst.add(cur,temp);
					cur--;
					if(cur<0) cur=0;
				}else if(lst.get(cur)==-1) {
					int temp = lst.get(cur-2)+lst.get(cur-1);
					cur -= 2;
					for(int i=0; i<3; i++) 
						lst.remove(cur);
					lst.add(cur,temp);
					cur--;
					if(cur<0) cur=0;
				}
				else {
					cur++;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
		
		
	}
}
