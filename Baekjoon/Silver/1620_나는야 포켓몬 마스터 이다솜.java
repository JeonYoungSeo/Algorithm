/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-21
 * Description : 백준 1620
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//문자열을 key로 한 맵과 숫자를 key로 한 맵 생성
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//입력
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			map.put(str, i);
			map2.put(i, str);
		}
		//숫자면 map2사용 문자열이면 map사용하여 출력
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			boolean isNumberic = str.chars().allMatch( Character::isDigit );
			if(isNumberic) {
				bw.write(map2.get(Integer.parseInt(str)).toString()+"\n");
			}else {
				bw.write(map.get(str).toString()+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
