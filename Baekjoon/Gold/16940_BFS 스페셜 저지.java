import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int curr;
        Node next;

        Node(int curr, Node next){
            this.curr = curr;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N+1];
        Node[] nodes = new Node[N+1];

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes[A] = new Node(B,nodes[A]);
            nodes[B] = new Node(A,nodes[B]);
        }

        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }
        if(answer[0]!=1){
            System.out.println(0);
            return;
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        boolean[] able = new boolean[N+1];
        visited[1] = true;

        int pos = 1;
        int[] parent = new int[N+1];
        int pa_pos = 0;

        while(!que.isEmpty()){
            int size = que.size();
            int able_num = 0;
            int s_p = pos;
            while(size-->0){
                int curr = que.poll();

                for(Node c = nodes[curr]; c!=null; c=c.next){
                    if(visited[c.curr]) continue;

                    que.add(c.curr);
                    visited[c.curr] = true;
                    able[c.curr] = true;
                    able_num++;
                    parent[c.curr] = curr;
                }
            }
            while(able_num!=0){
                if(able[answer[pos]]){
                    if(pos>N){
                        System.out.println(0);
                        return;
                    }
                    while(answer[pa_pos] != parent[answer[pos]]) {
                        pa_pos++;
                        if(pa_pos==s_p){
                            System.out.println(0);
                            return;
                        }
                    }
                    able[answer[pos]] = false;
                    pos++;
                    able_num--;
                }else{
                    System.out.println(0);
                    return;
                }
            }

        }
        System.out.println(1);
    }
}
