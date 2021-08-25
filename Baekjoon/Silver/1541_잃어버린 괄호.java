import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 1541
 */

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열 입력
		String str = br.readLine();
		//초기값 = +
		char c= '+';
		//숫자 입력할 변수
		StringBuilder sb = new StringBuilder();
    //결과물
		int result = 0;
		for(int i=0; i<str.length(); i++) {
      //+나 - 가올때마다 연산 진행
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {
				int temp = Integer.parseInt(sb.toString());
				if(c == '+') {
          //더해주고 sb초기화
					result += temp;
					sb.setLength(0);
				}else {
          //빼주고 sb초기화
					result -= temp;
					sb.setLength(0);
				}
				//-만나면 c를 -로
				if(str.charAt(i)=='-') c = '-';
				continue;
			}
			//연산자 아니면 sb에 추가
			sb.append(str.charAt(i));
		}
		//마지막은 연산자가 없으므로 한번더 해준다.
		int temp = Integer.parseInt(sb.toString());
		if(c == '+') {
			result += temp;
			sb.setLength(0);
		}else {
			result -= temp;
			sb.setLength(0);
		}
		//출력
		System.out.println(result);
		
	}
}
