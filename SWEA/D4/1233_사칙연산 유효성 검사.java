import java.util.*;
import java.io.*;

public class Main2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[] node = new char[N+1];
			
			for(int i = 1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String temp = st.nextToken();
				node[i] = temp.charAt(temp.length()-1);
			}
			
			if(check(node,1)) {
				bw.write("#"+tc+" "+"1\n");
			}else {
				bw.write("#"+tc+" "+"0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static private boolean check(char[] node, int i) {
		//48~57가 숫자
		boolean c1 = false;
		boolean c2 = false;
		if((int)node[i] >=48) {
			if(i*2<node.length) {
				return false;
			}
			return true;
		}else {
			if(i*2<node.length) {
				c1 = check(node, i*2);
			}
			if(i*2+1<node.length) {
				c2 = check(node,i*2+1);
			}
		}
		//왼쪽오른쪽 노드 모두 숫자여야지 성립 
		return (c1 && c2);
	}
}
