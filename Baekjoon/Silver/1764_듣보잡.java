/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-21
 * Description : 백준 1764
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<String> set = new HashSet<String>(); //듣지도 못한사람
		HashSet<String> set2 = new HashSet<String>(); //보지도 못한 사람
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//각각 입력
		for(int i=1; i<=N; i++) {
			set.add(br.readLine());
		}
		for(int i=0; i<M; i++) {
			set2.add(br.readLine());
		}
    
		List<String> lst = new ArrayList<String>();
    //이터레이터로 하나씩 접근
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String str = it.next();
      //두개다 있으면 리스트에 추가
			if(set2.contains(str)) 
				lst.add(str);
		}
		//스트링 배열에 넣어서 sort
		String[] lst2 = new String[lst.size()];
		for(int i=0;i<lst.size(); i++) {
			lst2[i] = lst.get(i).toString();
		}
		Arrays.sort(lst2);
    
    //출력
		bw.write(lst2.length+"\n");
		for(String s : lst2) {
			bw.write(s+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
