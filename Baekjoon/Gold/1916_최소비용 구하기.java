import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-12
 * Description : 백준 1916
 */

public class Main{
	public static class Node{
		int next,weight;
		Node link;
		
		Node(int next, int weight, Node link){
			this.next = next;
			this.weight = weight;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[N+1];
		
	
		//입력받음
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			node[start] = new Node(next, weight,node[start]);
		}
		
		//방문 리스트
		boolean[] visited = new boolean[N+1];
		//최솟값 저장 하는 리스트 
		int[] min_weight = new int[N+1];
		Arrays.fill(min_weight, Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		min_weight[start] = 0;
		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min_weight[j]<min) {
					min = min_weight[j];
					start = j;
				}
			}
			
			visited[start] = true;
			if(start == end) {
				break;
			}
			
			for(Node check = node[start]; check!=null; check = check.link) {
				if(!visited[check.next] && min_weight[check.next]>min+check.weight) {
					min_weight[check.next] = min + check.weight;
				}
			}
		}
		
		System.out.println(min_weight[end]);
		
	}
}
