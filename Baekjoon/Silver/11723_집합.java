
/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-21
 * Description : 백준 11723
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> set = new HashSet<Integer>();      // 세트
		HashSet<Integer> setall = new HashSet<Integer>();   // 1~20인 세트
		int M = Integer.parseInt(br.readLine());
		int temp;
		StringTokenizer st;
		
		for(int j=1; j<=20; j++) {
			setall.add(j);
		}
		//각각의 명령에 맞는 역할을 수행한다.
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "add":
				temp = Integer.parseInt(st.nextToken()); 
				if(!set.contains(temp))
					set.add(temp);
				break;
			case "remove" :
				temp = Integer.parseInt(st.nextToken()); 
				if(set.contains(temp))
					set.remove(temp);
				break;
			case "check" :
				if(set.contains(Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
				break;
			case "toggle":
				temp = Integer.parseInt(st.nextToken());
				if(set.contains(temp)) {
					set.remove(temp);
				}else {
					set.add(temp);
				}
				break;
			case "all" :
				set = setall;
				break;
			case "empty" :
				set.clear();
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
