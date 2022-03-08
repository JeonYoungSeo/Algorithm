import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int s,e;

        Node(int s, int e){
            this.s=s;
            this.e=e;
        }
        @Override
        public int compareTo(Node o) {
            if(s!=e){
                return this.s-o.s;
            }

            return this.e-o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M==0){
            System.out.println(N);
            return;
        }
        Node[] nodes = new Node[M];

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(s,e);
        }

        Arrays.sort(nodes);

        int start = nodes[0].s;
        int end = nodes[0].e;
        int result = start-1;
        if(result<0) result = 0;

        for(int i=1; i<M; i++){

            if(nodes[i].s<=end){
                end = Math.max(end,nodes[i].e);
                continue;
            }
            result++;
            result += nodes[i].s-end-1;
            end = nodes[i].e;

        }
        result += N-end+1;

        System.out.println(result);
    }
}
