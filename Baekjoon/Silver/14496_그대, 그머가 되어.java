import java.util.*;
import java.io.*;


public class Main
{
    public static class Node{
        int num;
        Node next;

        Node(int num, Node next){
            this.num = num;
            this.next = next;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] node = new Node[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            node[from] = new Node(to, node[from]);
            node[to] = new Node(from, node[to]);
        }

        Queue<Integer> que = new LinkedList<>();

        boolean[] visited = new boolean[N+1];
        que.add(a);
        visited[a] = true;
        int result = 0;
        while(!que.isEmpty()){
            int ea = que.size();

            while(ea-->0){
                int curr = que.poll();

                if(curr==b){
                    System.out.println(result);
                    return;
                }

                for(Node search = node[curr]; search!=null; search=search.next){
                    if(!visited[search.num]){
                        visited[search.num] = true;
                        que.add(search.num);
                    }

                }

            }
            result ++;
        }

        System.out.println(-1);



    }
}
