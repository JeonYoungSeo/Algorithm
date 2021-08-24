import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-24
 * Description : 백준 1753
 */

public class Main{
	public static class Node{
		int end,weight;
		Node link;
		Node(int end, int weight, Node link){
			this.end = end;
			this.weight = weight;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken())+1;
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		Node[] lst = new Node[V];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			lst[u] = new Node(v,w,lst[u]);
		}
		
		
		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		boolean visited[] = new boolean[V];
		for(int i=1; i<V; i++) {
			
			//1. 시작점에서 다음까지 최소거리
			int min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=1; j<V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			if(current==-1) break;
			visited[current] = true;
			
			//2. 방문하지 않았고 간선이 존재하며,
			//min+vertex가 해당 distance보다 작다
			//cur에 있는 정점 확인
			for(Node node = lst[current]; node!=null; node = node.link) {
				if(!visited[node.end] && distance[node.end]>min+node.weight) {
					distance[node.end] = min+node.weight;
				}
				
			}
			
			
		}
		
		for(int i=1; i<V; i++) {
			if(distance[i]==Integer.MAX_VALUE){
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}
}
