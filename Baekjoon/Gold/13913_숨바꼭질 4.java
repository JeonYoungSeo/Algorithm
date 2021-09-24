import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-24
 * Description : 백준 13913
 */


public class Main {
	//경로 저장하기위한 Node 
	public static class Node{
		int curr;
		ArrayList<Integer> road = new ArrayList<Integer>();
		
		Node(int curr,ArrayList<Integer> road){
			this.curr = curr;
			if(road != null) {
				this.road.addAll(road);
				this.road.add(curr);
			}
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        //각각의 조건에 따라 다르다.
        if(N==M) {
        	System.out.println(0);
        	System.out.println(N);
        	return ;
        }else if(N>M) {
        	System.out.println(N-M);
        	for(int i=N; i>=M; i--) {
        		System.out.print(i+" ");
        	}
        	return;
        }
        
        
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(new Node(N, new ArrayList<Integer>(N) ) );
        visited[N] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size!=0){
                Node curr = queue.poll();
                size--;

                if(curr.curr == M){
                    System.out.println(count);
                    for(int n : curr.road) {
                    	System.out.print(n+" ");
                    }
                    return;
                }

                int temp1 = curr.curr-1;
                int temp2 = curr.curr+1;
                int temp3 = curr.curr*2;

                if(temp1>=0 && !visited[temp1]){
                    queue.add(new Node(temp1, curr.road));
                    visited[temp1] = true;
                }
                if(temp2<=100000 && !visited[temp2]){
                	queue.add(new Node(temp2, curr.road));
                    visited[temp2] = true;
                }
                if(temp3<=100000 && !visited[temp3]){
                	queue.add(new Node(temp3, curr.road));
                    visited[temp3] = true;
                }
            }
            count++;
        }
        br.close();
    }
}
