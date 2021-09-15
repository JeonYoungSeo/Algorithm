import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-15
 * Description : 백준 1197 프림 알고리즘 적용 
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        Node[] node = new Node[V+1];
        
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine()); 
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	node[a] = new Node(b,c, node[a]);
        	node[b] = new Node(a,c, node[b]);
        }
        
        boolean visited[] = new boolean[V+1];
        
        int[] min_edge = new int[V+1];
        Arrays.fill(min_edge, Integer.MAX_VALUE);
        min_edge[1] = 0;
        int result = 0;
        
        for(int i=0; i<V; i++) {
        	int min = Integer.MAX_VALUE;
        	int min_vertex = 0;
        	
        	for(int j=1; j<=V; j++) {
        		if(!visited[j] && min>min_edge[j]) {
        			min = min_edge[j];
        			min_vertex = j;
        		}
        	}
        	
        	visited[min_vertex] = true;
        	result += min;
        	
        	for(Node check = node[min_vertex]; check!=null; check = check.link ) {
        		if(!visited[check.next] && min_edge[check.next]>check.weight) {
        			min_edge[check.next]=check.weight;
        		}
        	}
        	
        	
        }
        
        bw.write(result+"\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
