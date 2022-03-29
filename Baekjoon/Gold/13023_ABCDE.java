import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int link;
        Node next;

        Node(int link, Node next){
            this.link = link;
            this.next = next;
        }
    }

    static Node[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new Node[N];
        visited = new boolean[N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a] = new Node(b, nodes[a]);
            nodes[b] = new Node(a, nodes[b]);
        }

        for(int i=0; i<N; i++){
            int result = dfs(i,0);
            if(result == 1){
                System.out.println(1);
                return ;
            }
        }

        System.out.println(0);

    }

    private static int dfs(int curr,int dep) {

        if(dep==5) return 1;

        int result = 0;

        for(Node c = nodes[curr] ; c!=null; c=c.next){
            if(visited[c.link]) continue;
            visited[c.link] = true;
            result = dfs(c.link, dep+1);
            visited[c.link] = false;
            if(result == 1) return 1;
        }

        return result;
    }
}
