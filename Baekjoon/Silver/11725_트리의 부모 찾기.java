import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static boolean[] visited;
    public static int[] memo;
    public static class Node{
        int conn;
        Node next;

        Node(int conn, Node next){
            this.conn = conn;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Node[] node = new Node[N+1];
        visited = new boolean[N+1];
        memo = new int[N+1];
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a] = new Node(b, node[a]);
            node[b] = new Node(a, node[b]);

        }

        dfs(1, node);

        for(int i=2; i<=N; i++){
            System.out.println(memo[i]);
        }


    }

    private static void dfs(int parent, Node[] node) {

        visited[parent] = true;

        for(Node curr = node[parent]; curr!=null; curr=curr.next){
            int next = curr.conn;
            if(visited[next]) continue;
            memo[next] = parent;
            dfs(next, node);

        }
    }
}
