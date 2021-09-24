import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-24
 * Description : 백준 12851
 */


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(N);
        visited[N] = 0;
        int time = 0;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int curr = queue.poll();

                if(curr == M){
                    count++;
                }

                int temp1 = curr-1;
                int temp2 = curr+1;
                int temp3 = curr*2;

                if(temp1>=0){
                	if(visited[temp1]>=visited[curr]) {
                		queue.add(temp1);
                    	visited[temp1] = visited[curr]+1;
                	}
                }
                if(temp2<=100000){
                	if(visited[temp2]>=visited[curr]) {
                		queue.add(temp2);
                    	visited[temp2] = visited[curr]+1;
                	}
                }
                if(temp3<=100000){
                	if(visited[temp3]>=visited[curr]) {
	                    queue.add(temp3);
	                    visited[temp3] = visited[curr]+1;
                	}
                }
            }
            if(count!=0) {
            	break;
            }
            time++;
        }
        System.out.println(time+"\n"+count);
        br.close();
    }
}
