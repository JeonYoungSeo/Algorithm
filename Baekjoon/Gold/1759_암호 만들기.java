import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-23
 * Description : 백준 1759
 */

public class Main{
	static int L,C;
	static char[] arr;
	static List<String> lst; 
	static boolean[] selected;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 암호의 길이, 문자의 개수
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
    //완성된 문자열 저장 위함
		lst = new ArrayList<String>();
    //사용 가능 문자 저장 배열
		arr = new char[C];
    //사용한 배열 확인
		selected  = new boolean[C];
		st = new StringTokenizer(br.readLine());
    //사용가능한 문자 입력 
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
    
		StringBuilder sb = new StringBuilder();
    //permutation 함수 실행
		permu(0, sb);
		//문자열을 배열로 가져와서 문자열순으로 정렬
		String[] lstr = new String[lst.size()];
		for(int i=0; i<lst.size(); i++) {
			lstr[i] = new String(lst.get(i));
		}
		
		Arrays.sort(lstr);	
		//출력
		for(String s : lstr){
			System.out.println(s);
		}
	}
	//순열 함수 실행
	public static void permu(int count, StringBuilder sb) {
    //사전순이 아니라면 다시 뒤로 간다.
		for(int i=0; i<sb.length()-1; i++) {
			if(sb.charAt(i)>sb.charAt(i+1)) {
				return;
			}
		}
		//기저조건 
		if(count == L) {
			
			int count_a = 0;
			int count_b = 0;
			//모음이 1개 이상, 자음이 2개이상이 아니라면 저장하지 않는다.
			for(int i=0; i<L; i++) {
				if(sb.charAt(i)=='a' || sb.charAt(i)=='e'|| sb.charAt(i)=='i'||sb.charAt(i)=='o'||sb.charAt(i)=='u')
					count_a++;
				else 
					count_b++;
			}
			
			if(count_a<1 || count_b<2) return;
			
			lst.add(sb.toString());
		}
		
		//순열 함수 구현
		for(int i=0; i<C; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			sb.append(arr[i]);
			permu(count+1, sb);
			selected[i] = false;
			sb.setLength(sb.length()-1);
		}
	}
}
