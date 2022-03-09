import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int num ;
        Node next;

        Node(int num, Node next){
            this.num = num;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];
        int[] cnt = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            cnt[B]++;
            nodes[A] = new Node(B ,nodes[A]);
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(cnt[i]==0){
                que.add(i);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!que.isEmpty()){
            int curr = que.poll();

            result.append(curr+" ");

            for(Node c=nodes[curr]; c!=null; c=c.next){
                cnt[c.num]--;
                if(cnt[c.num]==0){
                    que.add(c.num);
                }
            }
        }

        System.out.println(result);

    }
}
