import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int next, dist;
        Node nextTo;

        Node(int next, int dist, Node nextTo){
            this.next = next;
            this.dist = dist;
            this.nextTo = nextTo;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N+1];
        boolean[] visited = new boolean[N+1];
        int ea = N;
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                node[num] = new Node(next, dist, node[num]);
            }
        }
        int result = dfs(1,node,visited);

        System.out.println(Math.max(result, longest));
    }

    static int longest = 0;

    private static int dfs(int num, Node[] node, boolean[] visited) {
        visited[num] = true;

        int first = 0, second = 0;
        int ea = 0;
        for(Node curr = node[num]; curr!=null; curr=curr.nextTo) {
            int next = curr.next;
            int dist = curr.dist;
            ea++;
            if(visited[next]) continue;

            int temp = dist+dfs(next, node, visited);

            if(temp>first){
                second = first;
                first = temp;
            }else{
                if(temp>second){
                    second = temp;
                }
            }

        }
        if(ea>=2){
            longest = Math.max(longest, first+second);
        }
        return first;
    }
}
