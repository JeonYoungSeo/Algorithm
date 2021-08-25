import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 9375
 */

public class Main{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
      //옷 갯수
			int n = Integer.parseInt(br.readLine());
      //맵 생성
			HashMap<String, Integer> map = new HashMap<String,Integer>();
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//첫번째 버림
				st.nextToken();
				//옷 종류 입력
				String temp = st.nextToken();
				//옷 없으면 1로 추가 있으면 갯수 1증가
				if(!map.containsKey(temp)) {
					map.put(temp, 1);
				}else {
					int temp_num = map.get(temp);
					map.put(temp, temp_num+1);
				}
			}
			
			int result = 1;
			//value 값만 받아옴
			Collection<Integer> values = map.values();
			for(int value : values) {
				result *= value+1;
			}
			//결과는 옷갯수+1 끼리 곱한뒤에 다 벗은 경우인 -1를 제외한게 정답
			System.out.println(result-1);
			
		}
	}
}
