import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-29
 * Description : 백준 9019
 */

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
	out : for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken()); 
			int result = Integer.parseInt(st.nextToken());
			
			char[] inst = {'D','S','L','R'};
			//BFS사용
			Queue<String> queue = new LinkedList<String>();
			Queue<Integer> numque = new LinkedList<Integer>();
			boolean[] visited = new boolean[10001];
			
			for(int i=0; i<4; i++) {
				queue.add(""+inst[i]);
				numque.add(input);
			}
			visited[input]= true;
			
			while(!queue.isEmpty()) {
				
				String curr = queue.poll();
				int num = numque.poll();
				
				switch(curr.charAt(curr.length()-1)) {
				case 'D' :
					num *= 2;
					num = num%10000;
					
					break;
				case 'S' :
					num --;
					
					if(num == -1) num = 9999;
					break;
				case 'L' :
					num*= 10;
					
					num += num/10000;
					
					num -= (num/10000)*10000;
					
					break ;
				case 'R' :
					num += (num%10)*10000;
					
					num /= 10;
					break;
				}
				
				if(num == result) {
					System.out.println(curr.toString());
					continue out;
				}
				
				for(int i=0; i<4; i++) {
					if(!visited[num]) {
						queue.add(curr+inst[i]);
						numque.add(num);
					}
				}
				visited[num] = true;
			}
		}
	}
}
