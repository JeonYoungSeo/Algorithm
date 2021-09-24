import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-24
 * Description : 백준 16953
 */


public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Queue<Long> queue = new LinkedList<Long>();
		
		queue.add((long)A);
		
		int count = 1;
		while(!queue.isEmpty()) {
			int len = queue.size();
			count++;
			while(len-->0) {
				long curr = queue.poll();
				
				long num1 = curr*2;
				long num2 = curr*10+1;
				//목표값 나오면 출력하고 정지
				if(num1==B || num2==B) {
					bw.write(count+"\n");
					bw.flush();
					bw.close();
					br.close();
					return ;
				}
				//B를 넘지 않으면 다시 큐에 넣어준다.
				if(num1<B) {
					queue.add(num1);
				}
				
				if(num2<B) {
					queue.add(num2);
				}
			}
		}
		
		bw.write("-1");
		bw.flush();
		bw.close();
		br.close();
	}
}
