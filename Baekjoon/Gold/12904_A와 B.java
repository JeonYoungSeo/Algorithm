import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*   백준 12904번 A와 B 문제
*    뒤에서부터 접근하면 쉽게 풀리는 문제이다.
*/


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());
		//T의 길이가 S와 같거나 작아질때까지 반복
		while(S.length()<T.length()) {
      //마지막이 A면 맨뒤 지운다.
			if(T.charAt(T.length()-1)=='A') {
				T.setLength(T.length()-1);
				continue;
			}
			//마지막이 B면 맨뒤 지우고 뒤집는다.
			if(T.charAt(T.length()-1)=='B') {
				T.setLength(T.length()-1);
				T.reverse();
				continue;
			}
		}
		// 둘이 같으면 1 다르면 0 출력
		if(S.equals(T.toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
}
